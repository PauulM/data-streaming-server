package datastreaming.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album implements Serializable {

    private static final long serialVersionUID = -2899697322081813556L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "albumid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artistid")
    private Artist artist;

    @Column(name = "albumname")
    private String name;

    @Column(name = "albumyear")
    private String albumYear;

    @Column(name = "publisher")
    private  String publisher;

    @Column(name = "albumartworkfilepath")
    private String artworkFilePath;

    @Column(name = "albumpath")
    private String albumPath;

    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private List<Song> songs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(String albumYear) {
        this.albumYear = albumYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getArtworkFilePath() {
        return artworkFilePath;
    }

    public void setArtworkFilePath(String artworkFilePath) {
        this.artworkFilePath = artworkFilePath;
    }

    public String getAlbumPath() {
        return albumPath;
    }

    public void setAlbumPath(String albumPath) {
        this.albumPath = albumPath;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", artist=" + artist +
                ", name='" + name + '\'' +
                ", albumYear='" + albumYear + '\'' +
                ", publisher='" + publisher + '\'' +
                ", artworkFilePath='" + artworkFilePath + '\'' +
                ", albumPath='" + albumPath + '\'' +
                ", songs=" + songs +
                '}';
    }
}
