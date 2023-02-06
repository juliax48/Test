package lesson23;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Task1 {
    public static void main(String[] args) {
        ChildrenFactory childrenFactory = new LocalChildrenFactory();
        List<Child> youngChildren = childrenFactory.create(7, 1, 5);
        List<Child> oldChildren = childrenFactory.create(5, 6, 10);

        List<Child> mixedChildren = mixChildren(youngChildren, oldChildren);

        Semaphore semaphore = new Semaphore(8);
        PlayGround playGround = new LocalPlayGround(semaphore);

        ExecutorService executorService = Executors.newFixedThreadPool(12);
        Consumer<Child> consumer = (child) -> {
            Runnable runnable = () -> playGround.play(child);
            executorService.submit(runnable);
        };

        //mixedChildren.forEach((child) -> executorService.submit(() -> playGround.play(child)));
        mixedChildren.forEach(consumer);

        executorService.shutdown();
    }

    private static List<Child> mixChildren(List<Child> list1, List<Child> list2) {
        List<Child> mixedChildren = new LinkedList<>(list1);
        mixedChildren.addAll(list2);

        Random random = new Random();
        int attempts = Math.min(list1.size(), list2.size());

        for (; attempts > 0; attempts--) {
            int list1Index = random.nextInt(list1.size() - 1);
            int list2Index = random.nextInt(list2.size() - 1) + list1.size();

            Child childToSwap = mixedChildren.get(list1Index);
            mixedChildren.set(list1Index, mixedChildren.get(list2Index));
            mixedChildren.set(list2Index, childToSwap);
        }
        return mixedChildren;
    }

}

interface ChildrenFactory {
    List<Child> create(int childrenAmount, int minAge, int maxAge);
}

class LocalChildrenFactory implements ChildrenFactory {
    @Override
    public List<Child> create(int childrenAmount, int minAge, int maxAge) {
        List<Child> children = new ArrayList<>(childrenAmount);
        Random random = new Random();

        for (int childNumber = 1; childNumber <= childrenAmount; childNumber++) {
            children.add(new Child("Child" + childNumber, random.nextInt(maxAge - minAge) + minAge));
        }

        return children;
    }
}

interface PlayGround {
    void play(Child child);
}

class LocalPlayGround implements PlayGround {
    private final Semaphore semaphore;

    public LocalPlayGround(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void play(Child child) {
        try {
            int blockPlaces = child.getAge() <= 5 ? 1 : 2;
            semaphore.acquire(blockPlaces);

            child.play();
            TimeUnit.MILLISECONDS.sleep(100);

            System.out.println(Thread.currentThread().getName() + " " + child.getName() + " has finished to play");
            semaphore.release(blockPlaces);
        } catch (InterruptedException ex) {
            String errorMessage = String.format("Child %s cannot play. %s", child.getName(), ex.getMessage());
            System.out.println(errorMessage);
        }
    }
}

class Child {

    private final String name;
    private final int age;

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void play() {
        System.out.println(Thread.currentThread().getName() + " " + name + " is playing, age is " + age);
    }

    @Override
    public String toString() {
        return "childName = '" + name + '\'' +
                ", childAge = " + age;
    }
}