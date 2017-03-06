package springlibrary.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springlibrary.DAO.interfaces.SongDAO;
import springlibrary.entities.Song;

import java.util.List;

@Component
@Scope("singleton")
public class LibraryFacade {

    @Autowired
    private SongDAO songDAO;

    private List<Song> songs;

    public List<Song> getSongs() {
        if (songs == null) {
            songs = songDAO.getSongs();
        }
        return songs;
    }
}
