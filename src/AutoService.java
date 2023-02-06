import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AutoService {
    public static void main(String[] args) throws IOException {
//        String text = "Ninja ZX-14, automobile \n" +
//                "Audi Q7, automobile \n" +
//                "Audi Q9!, microbus\n" +
//                "Sprinter 264, microbus\n" +
//                "Transporter T5, automobile\n" +
//                "BMW M5, automobile\n" +
//                "Mazda CX7, motobike\n" +
//                "Ninja, **";
//        try {
//            writeFile(text);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        List<String> validTransport = new ArrayList<>();
//        List<String> invalidTransport = new ArrayList<>();
//
//        readTransportFile(validTransport, invalidTransport);
//        writeInvalidTransportToFile(invalidTransport);

        Semaphore semaphoreParking = new Semaphore(5, true);
        Semaphore semaphoreService = new Semaphore(2, true);
        AutoDiagnosticService autoDiagnosticService = new AutoDiagnosticService(semaphoreService, semaphoreParking);

        List<TransportX> transportXList = Arrays.asList(
                new Automobile("a1", autoDiagnosticService),
                new Automobile("a2", autoDiagnosticService),
                new Automobile("a3", autoDiagnosticService),
                new Automobile("a4", autoDiagnosticService),
                new MicroBus("B1", autoDiagnosticService),
                new MicroBus("B2", autoDiagnosticService),
                new MotorBike("M1", autoDiagnosticService));

        ExecutorService executorService = Executors.newFixedThreadPool(10);


//        transportXList.forEach(transportX -> {
//            try {
//                executorService.submit(transportX::doDiagnostic);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.shutdown();
    }

    public static void writeFile(String text) throws Exception {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transport.txt", StandardCharsets.ISO_8859_1))) {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        }
    }

    static void readTransportFile(List<String> validTransport, List<String> invalidTransport) {
        try (BufferedReader reader = new BufferedReader(new FileReader("transport.txt", StandardCharsets.UTF_8), 512)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] entry = line.split(", ");
                Pattern validatePattern = Pattern.compile("^([A-Za-z]+)([A-Z]*|[a-z]*|[0-9 -]*)*([A-Z]|[a-z]|[0-9])$");
                Matcher validateMatcher = validatePattern.matcher(entry[0]);
                if (!validateMatcher.find()) {
                    validTransport.add(line);
                } else {
                    invalidTransport.add(line);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void writeInvalidTransportToFile(List<String> invalidTransport) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("invalid transport.txt", StandardCharsets.UTF_8), 256)) {
            for (String item : invalidTransport) {
                bufferedWriter.append(item).append("\n");
            }
            bufferedWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}


enum TypeTransport {
    AUTOMOBILE(20), MICROBUS(30), MOTORBIKE(10);
    int cost;

    TypeTransport(int cost) {
        this.cost = cost;
    }
}


abstract class TransportX {
    private TypeTransport type;
    private String model;
    AutoDiagnosticService service;

    List<String> validTransport = new ArrayList<String>(), invalidTransport = new ArrayList<String>();


    public TransportX (TypeTransport type, String model, AutoDiagnosticService service) {
        this.type = type;
        this.model = model;
        this.service = service;
        List<TransportX> validTransport = new ArrayList<>();
        List<TransportX> invalidTransport = new ArrayList<>();

    }
    public void doDiagnostic() throws InterruptedException {
        service.doDiagnostic(this);
    }
}


class Automobile extends TransportX {
    public Automobile(String model, AutoDiagnosticService service) {
        super(TypeTransport.AUTOMOBILE, model, service);
    }
}

class MicroBus extends TransportX {
    public MicroBus(String model, AutoDiagnosticService service) {
        super(TypeTransport.MICROBUS, model, service);
    }
}

class MotorBike extends TransportX {
    public MotorBike(String model, AutoDiagnosticService service) {
        super(TypeTransport.MOTORBIKE, model, service);
    }
}


class AutoDiagnosticService {
    private Semaphore semaphoreDiagnostic;
    private Semaphore semaphoreParking;

    public AutoDiagnosticService(Semaphore semaphoreDiagnostinc, Semaphore semaphoreParking) {
        this.semaphoreDiagnostic = semaphoreDiagnostinc;
        this.semaphoreParking = semaphoreParking;
    }

    public void doDiagnostic(TransportX transportX) throws InterruptedException {
        semaphoreParking.acquire();
        System.out.println("Entred to parking");
        TimeUnit.MILLISECONDS.sleep(1000);
        semaphoreDiagnostic.acquire();
        System.out.println("Ented to service");
        TimeUnit.MILLISECONDS.sleep(1000);
        semaphoreDiagnostic.release();
        semaphoreParking.release();
    }
}


