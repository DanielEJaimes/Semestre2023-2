package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicClient {

    public static void main(String[] args) {

        final String HOST = "127.0.0.1";
        final int PORT = 5000;

        try {

            while (true) {
            Socket sc = new Socket(HOST, PORT);

            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese el nombre de la canción (o 'salir' para terminar): \n");
                String solicitud = scanner.nextLine();

                if (solicitud.equalsIgnoreCase("salir")) {
                    break; // Si el usuario ingresa "salir", terminamos el bucle y cerramos la conexión
                } else {
                    out.writeUTF(solicitud); // Enviar la solicitud al servidor
                    String respuesta = in.readUTF(); // Recibir la respuesta del servidor
                    System.out.println(respuesta);
                }

            sc.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(MusicClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
