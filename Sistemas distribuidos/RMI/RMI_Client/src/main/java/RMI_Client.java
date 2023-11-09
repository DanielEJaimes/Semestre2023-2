import Interfaces.iRMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost"); // Cambiar a la dirección del servidor si es necesario
            iRMI messageService = (iRMI) registry.lookup("MessageService");
            
            String response = messageService.sendMessage("Hola desde el cliente!");
            System.out.println("Respuesta del servidor: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
