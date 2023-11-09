package service;

import java.util.List;
import java.util.Scanner;

public class MainClientSoap {

    public static void main(String[] args) {
        ServiceService servicio = new ServiceService();
        Service port = servicio.getServicePort();
        
        Scanner scanner = new Scanner(System.in);
        
        int choice = -1;
        
        while (choice != 0) {
            System.out.println("Choose an option:");
            System.out.println("1. Search by name");
            System.out.println("2. Search by artist");
            System.out.println("3. Search by genre");
            System.out.println("0. Exit");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the name: ");
                    String name = scanner.next();
                    List<String> songsByName = port.searchName(name);
                    System.out.println("Songs with name '" + name + "': " + songsByName);
                    break;
                case 2:
                    System.out.print("Enter the artist: ");
                    String artist = scanner.next();
                    List<String> songsByArtist = port.searchArtist(artist);
                    System.out.println("Songs by artist '" + artist + "': " + songsByArtist);
                    break;
                case 3:
                    System.out.print("Enter the genre: ");
                    String genre = scanner.next();
                    List<String> songsByGenre = port.searchGender(genre);
                    System.out.println("Songs with genre '" + genre + "': " + songsByGenre);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }
        
        scanner.close();
    }
}
