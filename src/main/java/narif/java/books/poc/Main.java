package narif.java.books.poc;

import narif.java.books.poc.reentrancy.B;

public class Main {
    public static void main(String[] args) {
//        testReentrancy();
        narif.java.books.poc.reentrancy.nonreentrant.B b = new narif.java.books.poc.reentrancy.nonreentrant.B();
        b.increment();
    }

    private static void testReentrancy() {
        B b = new B();
        b.greet();
    }
}