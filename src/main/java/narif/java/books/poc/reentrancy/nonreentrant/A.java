package narif.java.books.poc.reentrancy.nonreentrant;

import java.util.concurrent.Semaphore;

public class A {
    protected int count;

    protected final int PERMITS = Integer.MAX_VALUE;

    protected final Semaphore semaphore= new Semaphore(PERMITS, true);

    public void increment(){
        try {
            semaphore.acquire(PERMITS);
            count++;
            System.out.println("Count incremented from A.");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            semaphore.release(PERMITS);
        }
    }

    public void riskyIncrement() {
        try {
            semaphore.acquire(PERMITS);
            count++;
            System.out.println("RISKY: Count incremented from A.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
