package narif.java.books.poc.reentrancy.nonreentrant;

public class B extends A{

    @Override
    public void increment() {
        try {
            semaphore.acquire(PERMITS);
            count++;
            System.out.println("Count incremented from B.");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            semaphore.release(PERMITS);
        }
        super.increment();
        try {
            semaphore.acquire(PERMITS);
            count++;
            System.out.println("Count incremented from B Again");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            semaphore.release(PERMITS);
        }
    }
}
