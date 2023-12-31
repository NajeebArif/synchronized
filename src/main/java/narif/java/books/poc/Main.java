package narif.java.books.poc;

import narif.java.books.poc.reentrancy.B;

public class Main {
    public static void main(String[] args) {
//        testReentrancy();
        testNonReentrancy();
    }

    private static void testNonReentrancy() {
        narif.java.books.poc.reentrancy.nonreentrant.B b = new narif.java.books.poc.reentrancy.nonreentrant.B();
        //b.riskyIncrement(); // this will result in deadlock.
        b.increment();
    }

    private static void testReentrancy() {
        B b = new B();
        b.greet();
    }
}