package practice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(2099);
        Help stub = (Help) registry.lookup("Solver");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                int a, b, c;
                System.out.println("Введите коэффициенты квадратного уравнения: ");
                String[] str = reader.readLine().split(" ");
                a = Integer.parseInt(str[0]);
                b = Integer.parseInt(str[1]);
                c = Integer.parseInt(str[2]);
                System.out.println(stub.solveTask(a, b, c));

            }
        }
    }
    public static double[] parseNumbers(String input) throws NumberFormatException {
        try {
            String[] splitInput = input.split(" ");
            if (splitInput.length != 3) {
                throw new IllegalArgumentException("Input string should contain 3 numbers separated by spaces");
            }
            double[] numbers = new double[3];
            try {
                numbers[0] = Double.parseDouble(splitInput[0]);
                numbers[1] = Double.parseDouble(splitInput[1]);
                numbers[2] = Double.parseDouble(splitInput[2]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid number format in input string");
            }
            return numbers;
        }catch (NullPointerException e){
            throw new NullPointerException("Input string is null");
        }
    }
}
