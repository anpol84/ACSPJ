package practice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 12345);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String message;
            Thread getMessage = new Thread(new GetMessage(serverInput));
            getMessage.start();
            while(true) {
                message = input.readLine();

                output.println(message);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class GetMessage implements Runnable{
        private BufferedReader input;
        public GetMessage(BufferedReader input){
            this.input = input;
        }

        @Override
        public void run() {
            List<String> responses = new ArrayList<>();
            while (true){
                try {
                    String s;
                    s = input.readLine();
                    while (s != null && !s.isEmpty()){
                        responses.add(s);
                        s = input.readLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (!responses.isEmpty()) {
                    for (String response : responses){
                        System.out.println(response);
                    }
                }
                responses.clear();
            }
        }
    }
}