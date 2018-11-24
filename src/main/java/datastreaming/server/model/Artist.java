package datastreaming.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist implements Serializable {

    private static final long serialVersionUID = 8969018447256598435L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistid")
    private Long id;

    @Column(name = "artistname")
    private String name;

    @Column(name = "artistpath")
    private String directoryPath;

    @Column(name = "artistartworkfilepath")
    @JsonIgnore
    private String artworkDirectoryPath;

    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private List<Album> albums;

    public Artist() {
    }

    public Artist(String name, String directoryPath, String artworkDirectoryPath) {
        this.name = name;
        this.directoryPath = directoryPath;
        this.artworkDirectoryPath = artworkDirectoryPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getArtworkDirectoryPath() {
        return artworkDirectoryPath;
    }

    public void setArtworkDirectoryPath(String artworkDirectoryPath) {
        this.artworkDirectoryPath = artworkDirectoryPath;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directoryPath='" + directoryPath + '\'' +
                ", artworkDirectoryPath='" + artworkDirectoryPath + '\'' +
                '}';
    }
}
