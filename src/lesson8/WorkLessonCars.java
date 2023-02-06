package lesson8;

public class WorkLessonCars {
    public static void main(String[] args) {
        Truck truck = new Truck(100);
        Transportation transportation = truck;
        Go goTruck = truck;
        if (transportation.transport(101)) {
            goTruck.go();
        } else {
            System.out.println("Truck can't go");
        }

        Automobile automobile = new Automobile(5);
        TransportPassengers transportPassengers = automobile;
        Go goAutomobile = automobile;
        if (transportPassengers.move(5)) {
            goAutomobile.go();
        } else {
            System.out.println("Automobile can't go.");
        }

        Go[] goArray = new Go[3];
        goArray[0] = goTruck;
        goArray[1] = goAutomobile;
        goArray[2] = new Train();
        for (Go go : goArray) {
            go.go();
        }
    }
}

    class Train implements Go {
        @Override
        public void go() {
            System.out.println("Train is going.");
        }
    }
    class Car implements Go {
        int wheelsNumber;
        @Override
        public void go() { System.out.println("Car is going.");}
    }

    class Truck extends Car implements Transportation {
        private final int weightTransportedCargo;

        Truck(int weightTransportedCargo) {
            this.weightTransportedCargo = weightTransportedCargo;
        }

        @Override
        public boolean transport(int weight) {
            return weight <= weightTransportedCargo;
        }
    }

    class Automobile extends Car implements TransportPassengers {
        private final int passengersNumber;

        Automobile(int passengersNumber) {
            this.passengersNumber = passengersNumber;
        }

        @Override
        public boolean move(int passengersNumber) {
            return this.passengersNumber >= passengersNumber;
        }
    }

    interface Transportation {
        boolean transport(int weight);
    }

    interface TransportPassengers {
        boolean move(int passengersNumber);
    }
    interface Go {
        void go();
    }