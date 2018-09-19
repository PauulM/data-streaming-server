package datastreaming.server.model;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistid")
    public Long id;

    @Column(name = "artistname")
    public String name;

    @Column(name = "artistpath")
    public String directoryPath;

    @Column(name = "artistartworkfilepath")
    public String artworkDirectoryPath;

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
