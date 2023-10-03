package practice2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Help extends Remote {
    Answer solveTask(double a, double b, double c) throws RemoteException;
}

