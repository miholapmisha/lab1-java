public class ComputationThread extends Thread {

    private final int sequenceNumber;

    private final double step;

    private double currentValue = 0.0;

    private int numberSequenceElements = 0;

    private boolean isStopped = false;

    public ComputationThread(int sequenceNumber, double step) {
        this.step = step;
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public void run() {

        try {
            while (!isStopped) {
                numberSequenceElements++;
                currentValue += step;
                Thread.sleep(1000);
            }

            System.out.printf("%s Sequence number: %s, total elements: %s, last value: %s.%n",
                    Thread.currentThread().getName(), getSequenceNumber(), getNumberElements(), getCurrentValue());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public int getNumberElements() {
        return numberSequenceElements;
    }

    public synchronized void stopComputation() {
        isStopped = true;
    }
}
