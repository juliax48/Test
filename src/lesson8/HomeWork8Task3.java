package lesson8;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork8Task3 {
    public static void main(String[] args) {
        Tram tram1 = new Tram(0, 24, 80_000, 12, 2222);
        Taxi taxi1 = new Taxi(10, 5, 12_000, 24, 3333);
        Taxi taxi2 = new Taxi(6, 8, 15_000, 20, 4444);
        Bus bus1 = new Bus(18, 36, 50_000, 10, 5555);
        Bus bus2 = new Bus(14, 12, 30_000, 8, 6666);

        tram1.drive();
        taxi2.info();

        ParkCars park = new ParkCars(5);
        park.addTransport(taxi1);
        park.addTransport(taxi2);
        park.addTransport(bus1);
        park.addTransport(bus2);
        park.addTransport(tram1);

        park.drive();

        Scanner scanner = new Scanner(System.in);
        System.out.println("To find transport.txt enter number of passengers: ");
        int numPassengers = scanner.nextInt();

        System.out.println("Enter fuel consumption: ");
        int fuelConsumption = scanner.nextInt();

        System.out.println("Enter cost transportation: ");
        int costTransportation = scanner.nextInt();

        PublicTransport[] foundtranspots = park.findPublicTransports(numPassengers, fuelConsumption, costTransportation);
        if (foundtranspots.length == 0) {
            System.out.println("not found");
        } else {
            for (PublicTransport foundtranspot : foundtranspots) {
                System.out.println(foundtranspot.getType() + " ");
            }
        }
        park.sortOffFuelConsumption();

        System.out.println(" ");
        System.out.println("All transport.txt in park cost " + park.getCostTransport() + "$");
    }

}

interface Actions {
    public void drive();
}

interface Information {
    public void info();
}

class ParkCars implements Actions {
    private final PublicTransport[] transports;
    private int currentElement;

    public ParkCars(int numberOfTranspors) {
        this.transports = new PublicTransport[numberOfTranspors];
        this.currentElement = 0;
    }

    @Override
    public void drive() {
        System.out.print("Go to park ");
        for (PublicTransport transport : transports) {
            System.out.print(transport.getType() + " , ");
        }
        System.out.println(" ");
    }

    public boolean addTransport(final PublicTransport transport) {
        if (currentElement == transports.length) {
            return false;
        }
        transports[currentElement] = transport;
        currentElement++;
        return true;
    }

    public int getCostTransport() {
        int finalCost = 0;
        for (PublicTransport transport : transports) {
            finalCost += transport.getCostTransport();
        }
        return finalCost;
    }

    public void sortOffFuelConsumption() {
        for (int indexRow = 0; indexRow < transports.length - 1; indexRow++) {
            for (int indexColumn = transports.length - 1; indexColumn > indexRow; indexColumn--) {
                if (transports[indexColumn - 1].getFuelConsumption() > transports[indexColumn].getFuelConsumption()) {
                    PublicTransport tmp = transports[indexColumn - 1];
                    transports[indexColumn - 1] = transports[indexColumn];
                    transports[indexColumn] = tmp;
                }
            }
        }
        System.out.print("Sort off fuel consumption: ");
        for (PublicTransport transport : transports) {
            System.out.print(transport.getType() + " " + transport.getFuelConsumption() + " l/100km, ");
        }
    }

    public PublicTransport[] findPublicTransports(int numberPassenger, int fuelConsumption, int costTransportation) {
        PublicTransport[] foundtransports = new PublicTransport[0];

        for (PublicTransport transport : transports) {
            boolean isMatched = transport.getNumberPassangers() <= numberPassenger
                    && transport.getFuelConsumption() <= fuelConsumption
                    && transport.getCostTransportation() <= costTransportation;

            if (isMatched) {
                foundtransports = Arrays.copyOf(foundtransports, foundtransports.length + 1);
                foundtransports[foundtransports.length - 1] = transport;
            }
        }
        return foundtransports;
    }

}

abstract class Transport {
    private final long costTransport;
    private final int numberPassangers;

    public Transport(long costTransport, int numberPassangers) {
        this.costTransport = costTransport;
        this.numberPassangers = numberPassangers;
    }

    public long getCostTransport() {
        return costTransport;
    }

    public int getNumberPassangers() {
        return numberPassangers;
    }
}

class PublicTransport extends Transport implements Information, Actions {

    private final TransportType type;
    private final int number;
    private final int fuelConsumption;
    private final int costTransportation;

    public PublicTransport(TransportType type, int fuelConsumption, int numberOfPassangers, long costTransport, int number, int costTransportation) {
        super(costTransport, numberOfPassangers);
        this.type = type;
        this.fuelConsumption = fuelConsumption;
        this.number = number;
        this.costTransportation = costTransportation;
    }

    public TransportType getType() {
        return type;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getCostTransportation() {
        return costTransportation;
    }

    @Override
    public void drive() {
        System.out.println("Go on route " + type);
    }

    @Override
    public void info() {
        System.out.println("Show number: " + type + " № " + number);
    }

}

class Tram extends PublicTransport {

    public Tram(int fuelConsumption, int numberOfpassangers, long costTransport, int costTransportation, int number) {
        super(TransportType.TRAM, fuelConsumption, numberOfpassangers, costTransport, number, costTransportation);
    }

}

class Bus extends PublicTransport {
    public Bus(int fuelConsumption, int numberOfpassangers, long costTransport, int costTransportation, int number) {
        super(TransportType.BUS, fuelConsumption, numberOfpassangers, costTransport, number, costTransportation);
    }

}

class Taxi extends PublicTransport {
    public Taxi(int fuelConsumption, int numberOfpassangers, long costTransport, int costTransportation, int number) {
        super(TransportType.TAXI, fuelConsumption, numberOfpassangers, costTransport, number, costTransportation);
    }
}

enum TransportType {
    BUS, TRAM, TAXI
}