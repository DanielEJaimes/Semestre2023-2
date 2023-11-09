package main;

import classes.Song;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicServer {

    public static void main(String[] args) {

        Song[] arrayCanciones = {
            new Song("LALA", "Myke Towers", "LA VIDA ES UNA"),
            new Song("Minina", "Carre, Spreen", "Minina"),
            new Song("DISCULPE OFICIAL", "DobleP, PACOREMIX", "DISCULPE OFICIAL"),
            new Song("512", "Mora, Jhayco", "Primer Dia de Clases"),
            new Song("Demasiadas Mujeres", "C. Tangana", "El Madrileño"),};

        ServerSocket servidor;
        Socket sc;
        final int PORT = 5000;

        try {
            servidor = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");

            while (true) {
                sc = servidor.accept();
                System.out.println("Cliente conectado");

                DataInputStream in = new DataInputStream(sc.getInputStream()); //Recibir mensaje
                DataOutputStream out = new DataOutputStream(sc.getOutputStream()); //Devolver mensaje

                String solicitud = in.readUTF();
                System.out.println("Solicitud cliente:" + solicitud);
                Song cancionEncontrada = buscarCancion(solicitud, arrayCanciones);

                if (cancionEncontrada != null) {
                    // Si la canción existe, la enviamos al cliente
                    out.writeUTF("Canción encontrada: " + cancionEncontrada.getName()
                            + " - Álbum: " + cancionEncontrada.getAlbum()
                            + " - Artista: " + cancionEncontrada.getArtist());
                } else {
                    // Si la canción no existe, enviamos un mensaje de aviso al cliente
                    out.writeUTF("La canción solicitada no se encontró en la base de datos.");
                }

                    out.flush();
            }

        } catch (IOException ex) {
            Logger.getLogger(MusicServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Song buscarCancion(String nombreCancion, Song[] arrayCanciones) {
        for (Song cancion : arrayCanciones) {
            if (cancion.getName().equalsIgnoreCase(nombreCancion)) {
                return cancion; // Se encontró la canción
            }
        }
        return null; // La canción no fue encontrada
    }
}
