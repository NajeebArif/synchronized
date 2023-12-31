package narif.java.books.poc.reentrancy;

public class B extends A{

    @Override
    public synchronized void greet() {
        System.out.println("Greetings from B. Deligating to A now. Thread: "+Thread.currentThread().getName());
        super.greet();
        System.out.println("Back to B!");
    }
}
