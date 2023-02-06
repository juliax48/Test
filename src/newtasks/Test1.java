package newtasks;

public class Test1 {
    public static void main(String[] args) {
        Test5 test1 = new Test5();
        test1.setId(5);
        test1.setNumber(10);

        test1.outPutDisplay(5,10);
    }
}


class Test5 {
    int id;
    int number;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void outPutDisplay (int id, int number) {
        System.out.println("id is" + id + " and number is " + number);
    }
}
