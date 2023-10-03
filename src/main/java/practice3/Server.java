package practice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
    private static List<PrintWriter> clients = new ArrayList<>();
    private static List<String> messages = new ArrayList<>();
    private static class MessageWriter implements Runnable{
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(5000);
                    if (!messages.isEmpty()) {
                        StringBuilder s = new StringBuilder();
                        for (String message : messages) {
                            s.append(message).append("\n");
                        }
                        for (PrintWriter writer : clients) {
                            writer.println(s);
                        }
                        messages.clear();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            Thread messageWriter = new Thread(new MessageWriter());
            messageWriter.start();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(output);

                Thread clientThread = new Thread(() -> {
                    try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        while (true) {
                            String message = input.readLine();
                            if (message == null) {
                                clients.remove(output);
                                break;
                            }
                            messages.add(message);
                            System.out.println("Received: " + message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}