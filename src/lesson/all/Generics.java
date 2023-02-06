package lesson.all;


public class Generics {
    public static void main(String[] args) {


    }


    public void skrin(String dg){
        System.out.println("Clean potato");
    }
}


class User {
    private String login;
    private int password;

    public User(String login, int password) {
        this.login = login;
        this.password = password;
    }


    public void createQuery() {
        Query query = new Query();
        query.printToLog();
    }

    class Query {

        public void printToLog() {
            System.out.println("User" + login + password + " sent massage");
        }
    }
}