package de.unitrier.st.fp.s23.blatt06.aufgabe1;

public class RaceCondition {

    class IncrementThreadRC extends Thread{
        private int count=0;
        @Override public void run(){
            while (!this.isInterrupted()){
                System.out.printf("Increment: %d\n", count++);
            }
        }
    }

    class DecrementThread extends Thread{
        private static int count=0;
        @Override public void run(){
            while (!this.isInterrupted()){
                System.out.printf("Increment: %d\n", count--);
            }
        }
    }

    private void startThreads() throws InterruptedException{
        //Aufgabe 1.1:
        IncrementThreadRC incrementThreadRC=new IncrementThreadRC();
        IncrementThreadRC incrementThreadRC2=new IncrementThreadRC();

        incrementThreadRC.start();
        incrementThreadRC2.start();

        Thread.sleep(20);

        incrementThreadRC.interrupt();
        incrementThreadRC2.interrupt();
    }

    public static void main(String[] args) throws InterruptedException{
        new RaceCondition().startThreads();
    }
}