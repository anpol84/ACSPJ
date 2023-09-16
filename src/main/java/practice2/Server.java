package practice2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        HelpImpl help = new HelpImpl();
        Help stub = (Help) UnicastRemoteObject.exportObject(help, 0);
        Registry registry = LocateRegistry.createRegistry(2099);
        registry.bind("Solver", stub);
    }
}
