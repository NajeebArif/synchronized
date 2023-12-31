package narif.java.books.poc.reentrancy;

import java.util.concurrent.locks.StampedLock;

public class A {

    public synchronized void greet(){
        System.out.println("Greetings from Class A. Thread name: "+Thread.currentThread().getName());
    }
}
