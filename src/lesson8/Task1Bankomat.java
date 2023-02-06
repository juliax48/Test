package lesson8;

import java.util.*;

public class Task1Bankomat {
    public static void main(String[] args) {
        Atm atm = new Atm( 2, 4, 10);
        boolean result = false;
        while (!result) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите суммы для выдачи: ");
            result = atm.giveMoney(scanner.nextInt());
            atm.giveMoney(2345);
            atm.addMonney(10, 10, 10);
            System.out.println(" ");
            scanner.close();
        }
    }
}


class Atm {

    private int x100;
    private int x50;
    private int x20;

    private int toIssueX100;
    private int toIssueX50;
    private int toIssueX20;

    private boolean isSuccessIssue = false;

    public Atm(int x100, int x50, int x20) {
        this.x100 = x100;
        this.x50 = x50;
        this.x20 = x20;
    }

    public void addMonney(int x100, int x50, int x20) {
        this.x100 += x100;
        this.x50 += x50;
        this.x20 += x20;
    }

    public boolean giveMoney(int value) {
        clearToIssue();
        int c100, c50, c20 = 0;
        for (c100 = x100; c100 >= 0; c100--) {
            c50 = 0;
            if (issueCalculate(c100, c50, c20, value)) {
                printCheck();
                return true;
            }
            for (c50 = x50; c50 >= 0; c50 --) {
                c20 = 0;
                if (issueCalculate(c100, c50, c20, value)) {
                    printCheck();
                    return true;
                }
                for (c20 = x20; c20 >= 0; c20--) {
                    if (issueCalculate(c100, c50, c20, value)) {
                        printCheck();
                        return true;
                    }
                }
            }
        }
        printCheck();
        return false;
    }

    private boolean issueCalculate(int toIssueX100, int toIssueX50, int toIssueX20, int balance) {
        int result = balance - (toIssueX100 *100) - (toIssueX50 * 50) - (toIssueX20 * 20);
        if (result == 0) {
            this.toIssueX20 = toIssueX20;
            this.toIssueX50 = toIssueX50;
            this.toIssueX100 = toIssueX100;
            isSuccessIssue = true;
            return true;
        }
        return false;
    }


    private void printCheck() {
        if (isSuccessIssue) {
            System.out.println("Выдано:" + ((100 * toIssueX100) + (50 * toIssueX50) + (20 * toIssueX20)) + "р.");
            System.out.println("100р. х " + toIssueX100 + ", " + "50р. х " + toIssueX50 + ", " + "20р. х " + toIssueX20);
        } else {
            System.out.println("Не возможно выдать введенную сумму.");
        }
    }

    private void clearToIssue() {
        toIssueX20 = 0;
        toIssueX50 = 0;
        toIssueX100 = 0;
        isSuccessIssue = false;
    }

}

