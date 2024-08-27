package de.unitrier.st.fp.s23.blatt06.aufgabe1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CommunicationDeadlock2 {
    private int count=0;
    private static CommunicationDeadlock2 dataRace;

    final Lock lock=new ReentrantLock();

    final Condition notFull= lock.newCondition();
    private void increment(){
        try {
            lock.lock();
            while (count>9){
                notFull.await();
            }
            int c = count;
            c=c+1;
            System.out.printf("Increment: %d\n", c);
            count = c;

            notFull.signalAll();
        } catch (Exception e) {

        }
        finally {
            lock.unlock();
        }
    }
    private void decrement(){
        try {
            lock.lock();
            while (count<1){
                notFull.await();
            }
            int c = count;
            c=c-1;
            System.out.printf("Increment: %d\n", c);
            count = c;

            notFull.signalAll();
        } catch (Exception e) {

        }
        finally {
            lock.unlock();
        }
    }

    class IncrementThreadDR extends Thread{
        @Override public void run(){
            while (!this.isInterrupted()){
                dataRace.increment();
            }
        }
    }

    class DecrementThreadDR extends Thread{
        @Override public void run(){
            while (!this.isInterrupted()){
                dataRace.decrement();
            }
        }
    }

    private void startThreads() throws InterruptedException{
        //Aufgabe 1.5:
        dataRace=new CommunicationDeadlock2();
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
        new CommunicationDeadlock2().startThreads();
    }
}