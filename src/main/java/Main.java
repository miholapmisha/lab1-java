import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Write number of computational threads:");
        int countComputationalThreads = scanner.nextInt();
        List<ComputationThread> computationThreads = getListOfComputationalThreads(countComputationalThreads);
        System.out.println("Write interval:");
        int interval = scanner.nextInt();
        ThreadsStopper stopper = new ThreadsStopper(computationThreads, interval);
        new Thread(stopper).start();
        runThreads(computationThreads);

    }

    private static void runThreads(List<ComputationThread> threads) {

        for (Thread thread : threads) {
            thread.start();
        }
    }


    private static List<ComputationThread> getListOfComputationalThreads(int countComputationalThreads) {
        List<ComputationThread> computationThreadList = new ArrayList<>(countComputationalThreads);

        while (countComputationalThreads != 0) {

            int sequenceNumber = computationThreadList.size() + 1;
            System.out.println("Write step for " + sequenceNumber + " thread: ");
            int step = scanner.nextInt();
            computationThreadList.add(new ComputationThread(sequenceNumber, step));
            countComputationalThreads--;
        }

        return computationThreadList;
    }
}