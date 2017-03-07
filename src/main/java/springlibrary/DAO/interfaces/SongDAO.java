package springlibrary.DAO.interfaces;


import springlibrary.entities.Author;
import springlibrary.entities.Genre;
import springlibrary.entities.Song;

import java.util.List;

public interface SongDAO {
    List<Song> getSongs();
    List<Song> getSongs(Author author);
    List<Song> getSongs(String songName);
    List<Song> getSongs(Genre genre);
    List<Song> getSongs(Character letter);
}
