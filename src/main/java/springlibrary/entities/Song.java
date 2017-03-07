package springlibrary.entities;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by aleksandrsmaskalenko on 04/03/2017.
 */
public class Song implements Serializable{
    private int id;
    private String name;
    private byte[] content;
    private String time;
    private byte[] image;
    private Integer rating;
    private Long voteCount;
    private Genre genre;
    private Album album;
    private Author author;
    private PublishDate publishdate;

    public Song() {
    }

    public Song(int id, String name, byte[] content, String time, byte[] image, Integer rating, Long voteCount, Genre genre, Album album, Author author, PublishDate publishdate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.time = time;
        this.image = image;
        this.rating = rating;
        this.voteCount = voteCount;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.publishdate = publishdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PublishDate getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(PublishDate publishdate) {
        this.publishdate = publishdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (id != song.id) return false;
        if (genre != song.genre) return false;
        if (album != song.album) return false;
        if (author != song.author) return false;
        if (publishdate != song.publishdate) return false;
        if (name != null ? !name.equals(song.name) : song.name != null) return false;
        if (!Arrays.equals(content, song.content)) return false;
        if (time != null ? !time.equals(song.time) : song.time != null) return false;
        if (!Arrays.equals(image, song.image)) return false;
        if (rating != null ? !rating.equals(song.rating) : song.rating != null) return false;
        if (voteCount != null ? !voteCount.equals(song.voteCount) : song.voteCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        result = 31 * result + genre.hashCode();
        result = 31 * result + album.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publishdate.hashCode();
        return result;
    }
}
