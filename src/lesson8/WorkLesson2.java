package lesson8;

public class WorkLesson2 {
    public static void main(String[] args) {
        Plane plane = new Plane();
        Laptop laptop = new Laptop();

        Render[] renders = new Render[2];
        renders[0] = plane;
        renders[1] = laptop;

        System.out.println("renders\n");
        for (Render render : renders) {
            render.renderInformation();
            render.renderCommonInformation();
            render.stop();
            render.enable();
            System.out.println();
        }
    }

}

interface Stopper {

    default void stop() {
        System.out.println("Default Stopper");
    }

}

interface Enabler {

    void enable();

}

interface Render extends Enabler, Stopper {

    default void renderCommonInformation() {
        System.out.println("Default renderCommonInformation");
    }

    void renderInformation();

}

class Plane implements Render, Enabler {

    @Override
    public void renderInformation() {
        System.out.println("Render Plane info");
    }

    @Override
    public void enable() {
        System.out.println("Enabler Plane");
    }
}

class Device {

}

class Laptop extends Device implements Render, Enabler {
    @Override
    public void renderInformation() {
        System.out.println("Render Laptop info");
    }

    @Override
    public void enable() {
        System.out.println("Enabler Laptop");
    }

    @Override
    public void renderCommonInformation() {
        System.out.println("Render common Laptop Info");
    }
}

