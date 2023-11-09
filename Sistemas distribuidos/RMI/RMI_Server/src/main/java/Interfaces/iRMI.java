package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iRMI extends Remote {
    String sendMessage(String message) throws RemoteException;
}
