import Interfaces.iRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server extends UnicastRemoteObject implements iRMI {
    protected RMI_Server() throws RemoteException {
        super();
    }

    @Override
    public String sendMessage(String message) throws RemoteException {
        System.out.println("Mensaje recibido: " + message);
        return "Mensaje recibido: " + message;
    }

    public static void main(String[] args) {
        try {
            RMI_Server server = new RMI_Server();
            java.rmi.registry.LocateRegistry.createRegistry(1099); // Registro RMI
            java.rmi.Naming.rebind("MessageService", server);
            System.out.println("Servidor listo...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
