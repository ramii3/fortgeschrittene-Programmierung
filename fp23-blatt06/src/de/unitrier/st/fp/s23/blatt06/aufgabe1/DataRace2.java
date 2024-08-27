package de.unitrier.st.fp.s23.blatt06.aufgabe1;

public class DataRace2 {
    private int count=0;
    private static DataRace2 dataRace;
    private void increment() throws InterruptedException {
        synchronized (dataRace){
            while (count>9){
                dataRace.wait();
            }
            int c = count;
            c=c+1;
            System.out.printf("Increment: %d\n", c);
            count = c;

            dataRace.notify();
        }
    }
    private synchronized void decrement() throws InterruptedException {
        while (count<1){
            dataRace.wait();
        }
        int c=count;
        c=c-1;
        System.out.printf("Decrement: %d\n", c);
        count=c;

        dataRace.notify();
    }

    class IncrementThreadDR extends Thread{
        @Override public void run(){
            while (!this.isInterrupted()){
                try {
                    dataRace.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class DecrementThreadDR extends Thread{
        @Override public void run(){
            while (!this.isInterrupted()){
                try {
                    dataRace.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void startThreads() throws InterruptedException{
        //Aufgabe 1.3:
        dataRace=new DataRace2();
        IncrementThreadDR incrementThreadDR=new IncrementThreadDR();
        DecrementThreadDR decrementThreadDR=new DecrementThreadDR();

        incrementThreadDR.start();
        decrementThreadDR.start();

        Thread.sleep(100);

        //dataRace.notify();

        incrementThreadDR.interrupt();
        decrementThreadDR.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        new DataRace2().startThreads();
    }
}