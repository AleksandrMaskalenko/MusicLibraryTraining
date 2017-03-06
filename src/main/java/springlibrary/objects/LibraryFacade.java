package springlibrary.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springlibrary.DAO.interfaces.SongDAO;
import springlibrary.entities.Song;

import java.util.List;


public class LibraryFacade {

    private SongDAO songDAO;


    public void setSongDAO(SongDAO songDAO) {
        this.songDAO = songDAO;
        songs = songDAO.getSongs();
    }

    private List<Song> songs;


    public List<Song> getSongs() {
        return songs;
    }




}
