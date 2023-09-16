package practice1;

public class PingPong implements Runnable {

    @Override
    public synchronized void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
                notify();
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}