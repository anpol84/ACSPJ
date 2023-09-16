package practice2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Help extends Remote {
    Answer solveTask(int a, int b, int c) throws RemoteException;
}
