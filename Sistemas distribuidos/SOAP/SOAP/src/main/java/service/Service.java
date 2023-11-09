package service;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Service {

    private final List<Song> songs;

    public Service() {
        songs = new ArrayList<>();
        songs.add(new Song("Song1", "Artist1", "Genre1"));
        songs.add(new Song("Song2", "Artist2", "Genre2"));
        songs.add(new Song("Song3", "Artist1", "Genre1"));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchArtist")
    public List<String> searchByArtist(String artist) {
        List<String> result = new ArrayList<>();
        songs.stream().filter(song -> (song.getArtist().equalsIgnoreCase(artist))).forEachOrdered(song -> {
            result.add(song.toString());
        });
        return result;
    }

    @WebMethod(operationName = "searchGender")
    public List<String> searchByGender(String gender) {
        List<String> result = new ArrayList<>();
        songs.stream().filter(song -> (song.getGenre().equalsIgnoreCase(gender))).forEachOrdered(song -> {
            result.add(song.toString());
        });
        return result;
    }

    @WebMethod(operationName = "searchName")
    public List<String> searchName(@WebParam(name = "name") final String name) {
        List<String> result = new ArrayList<>();
        songs.stream().filter(song -> (song.getName().equalsIgnoreCase(name))).forEachOrdered(song -> {
            result.add(song.toString());
        });
        return result;
    }
}
