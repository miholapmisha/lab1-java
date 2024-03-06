import java.util.List;

public class BreakThread extends Thread{

    private final List<ComputationThread> computationThreads;

    private final int interruptTimeMilliseconds;

    public BreakThread(int interruptTimeMilliseconds, List<ComputationThread> computationThreads) {
        this.interruptTimeMilliseconds = interruptTimeMilliseconds;
        this.computationThreads = computationThreads;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(interruptTimeMilliseconds);

            for(ComputationThread computationThread : computationThreads) {
                computationThread.stopComputation();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
