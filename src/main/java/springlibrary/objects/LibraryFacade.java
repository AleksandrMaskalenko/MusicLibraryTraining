package springlibrary.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springlibrary.DAO.interfaces.SongDAO;
import springlibrary.entities.Author;
import springlibrary.entities.Song;

import java.util.List;

@Component
@Scope("singleton")
public class LibraryFacade {

    @Autowired
    private SongDAO songDAO;

    @Autowired
    private SearchCriteria searchCriteria;

    private List<Song> songs;

    public List<Song> getSongs() {
        if (songs == null) {
            songs = songDAO.getSongs();
        }
        return songs;
    }

    public void searchSongsByLetter() {
        songs = songDAO.getSongs(searchCriteria.getLetter());
    }

    public void searchSongsByGenre() {
        songs = songDAO.getSongs(searchCriteria.getGenre());
    }

    public void searchSongsByText() {

        switch (searchCriteria.getSearchType()){
            case TITLE:
                songs = songDAO.getSongs(searchCriteria.getText());
                break;
            case AUTHOR:
                songs = songDAO.getSongs(new Author(searchCriteria.getText()));
                break;
        }

    }
}
