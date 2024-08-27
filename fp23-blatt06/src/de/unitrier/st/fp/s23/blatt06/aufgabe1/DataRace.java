package de.unitrier.st.fp.s23.blatt06.aufgabe1;

public class DataRace {
    private int count=0;
    private int increment(){
        int c=count;
        c++;
        System.out.printf("Increment: %d\n", c);
        return c;
    }
    private int decrement(){
        int c=count;
        c--;
        System.out.printf("Decrement: %d\n", c);
        return c;
    }

    class IncrementThreadDR extends Thread{
        @Override public void run(){
            while (!this.isInterrupted()){
                count=increment();
            }
        }
    }

    class DecrementThreadDR extends Thread{
        @Override public void run(){
            while (!this.isInterrupted()){
                count=decrement();
            }
        }
    }

    private void startThreads() throws InterruptedException{
        //Aufgabe 1.2:
        IncrementThreadDR incrementThreadDR=new IncrementThreadDR();
        DecrementThreadDR decrementThreadDR=new DecrementThreadDR();

        incrementThreadDR.start();
        decrementThreadDR.start();

        Thread.sleep(100);

        incrementThreadDR.interrupt();
        decrementThreadDR.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        new DataRace().startThreads();
    }
}