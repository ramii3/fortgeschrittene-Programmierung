package de.unitrier.st.fp.s23.blatt06.aufgabe1;

public class CommunicationDeadlock {
    private int count=0;
    private static CommunicationDeadlock dataRace;
    private void increment() throws InterruptedException {
        synchronized (dataRace){
            while (count>9){
                dataRace.wait();
            }
            int c = count;
            c=c+1;
            System.out.printf("Increment: %d\n", c);
            count = c;

            dataRace.notifyAll();
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

        dataRace.notifyAll();
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
        //Aufgabe 1.5:
        dataRace=new CommunicationDeadlock();
        IncrementThreadDR incrementThreadDR1=new IncrementThreadDR();
        IncrementThreadDR incrementThreadDR2=new IncrementThreadDR();
        IncrementThreadDR incrementThreadDR3=new IncrementThreadDR();
        DecrementThreadDR decrementThreadDR1=new DecrementThreadDR();
        DecrementThreadDR decrementThreadDR2=new DecrementThreadDR();

        incrementThreadDR1.start();
        incrementThreadDR2.start();
        incrementThreadDR3.start();
        decrementThreadDR1.start();
        decrementThreadDR2.start();

        incrementThreadDR1.interrupt();
        incrementThreadDR2.interrupt();
        incrementThreadDR3.interrupt();
        decrementThreadDR1.interrupt();
        decrementThreadDR2.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        new CommunicationDeadlock().startThreads();
    }
}