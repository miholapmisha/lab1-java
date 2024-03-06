import java.util.List;

public class ThreadsStopper implements Runnable {

    private final List<ComputationThread> computationThreads;

    private final int interruptTimeMilliseconds;

    public ThreadsStopper(List<ComputationThread> computationThreads, int interruptTimeMilliseconds) {
        this.computationThreads = computationThreads;
        this.interruptTimeMilliseconds = interruptTimeMilliseconds;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(interruptTimeMilliseconds);

            for (ComputationThread computationThread : computationThreads) {
                computationThread.stopComputation();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
