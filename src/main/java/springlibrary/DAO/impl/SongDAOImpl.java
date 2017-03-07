package springlibrary.DAO.impl;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springlibrary.DAO.interfaces.SongDAO;
import springlibrary.entities.Author;
import springlibrary.entities.Genre;
import springlibrary.entities.Song;

import java.util.List;

@Component
public class SongDAOImpl implements SongDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList songProjection;

    public SongDAOImpl() {
        songProjection = Projections.projectionList();
        songProjection.add(Projections.property("id"), "id");
        songProjection.add(Projections.property("name"), "name");
        songProjection.add(Projections.property("time"), "time");
        songProjection.add(Projections.property("image"), "image");
        songProjection.add(Projections.property("genre"), "genre");
        songProjection.add(Projections.property("publishdate"), "publishdate");
        songProjection.add(Projections.property("author"), "author");
        songProjection.add(Projections.property("rating"), "rating");
        songProjection.add(Projections.property("voteCount"), "voteCount");
        songProjection.add(Projections.property("album"), "album");

    }


    @Override
    @Transactional
    public List<Song> getSongs() {
        List<Song> songs = createSongList(createSongCriteria());
        return songs;
    }


    @Override
    @Transactional
    public List<Song> getSongs(Author author) {
        List<Song> songs = createSongList(createSongCriteria().add(Restrictions.ilike
                ("author.name", author.getName(), MatchMode.ANYWHERE)));

        return songs;
    }



    @Override
    @Transactional
    public List<Song> getSongs(String songName) {
        List<Song> songs = createSongList(createSongCriteria().add(Restrictions.ilike
                ("s.name", songName, MatchMode.ANYWHERE)));

        return songs;
    }



    @Override
    @Transactional
    public List<Song> getSongs(Genre genre) {
        List<Song> songs = createSongList(createSongCriteria().add(Restrictions.ilike
                ("genre.name", genre.getName())));

        return songs;
    }

    @Override
    @Transactional
    public List<Song> getSongs(Character letter) {
        List<Song> songs = createSongList(createSongCriteria().add(Restrictions.ilike
                ("s.name", letter.toString(), MatchMode.START)));
        return songs;
    }

    private DetachedCriteria createSongCriteria() {
        DetachedCriteria songListCriteria = DetachedCriteria.forClass(Song.class, "s");
        createAliases(songListCriteria);
        return songListCriteria;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("s.author", "author");
        criteria.createAlias("s.genre", "genre");
        criteria.createAlias("s.publishdate", "publishdate");
        criteria.createAlias("s.album", "album");
    }

    private List<Song> createSongList(DetachedCriteria bookListCriteria) {
        Criteria criteria = bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("s.name")).setProjection(songProjection).setResultTransformer(Transformers.aliasToBean(Song.class));
        return criteria.list();
    }
}
