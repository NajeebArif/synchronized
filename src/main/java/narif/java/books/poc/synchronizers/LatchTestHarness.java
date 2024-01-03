package narif.java.books.poc.synchronizers;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;

public class LatchTestHarness {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(3);
        Thread thread1 = createTestHarnessThread(startGate, endGate);
        Thread thread2 = createTestHarnessThread(startGate, endGate);
        Thread thread3 = createTestHarnessThread(startGate, endGate);
        Thread thread4 = createTestHarnessThread(startGate, endGate);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        startGate.countDown();
        System.out.println("WAITING FOR EVERYONE TO COMPLETE!");
        endGate.await();
    }

    public static Thread createTestHarnessThread(final CountDownLatch startGate, final CountDownLatch endGate){
        return new Thread(() -> {
            try{
                startGate.await();
                String name = Thread.currentThread().getName();
                System.out.println("GATE OPENED for "+ name +" at "+ Instant.now().getEpochSecond());
                System.out.println("DOING SOME SERIOUS STUFF IN "+name);
                Thread.sleep(1000);
                endGate.countDown();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
