package practice1;

public class Main {
    public static void main(String[] args) {
        PingPong printer = new PingPong();

        Thread pingThread = new Thread(printer, "Ping");
        Thread pongThread = new Thread(printer, "Pong");

        pingThread.start();
        pongThread.start();
    }
}




