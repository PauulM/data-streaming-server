package datastreaming.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "songs")
public class Song implements Serializable {

    private static final long serialVersionUID = -7637388305046665494L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "songid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "albumid")
    private Album album;

    @Column(name = "songname")
    private String name;

    @Column(name = "songfilepath")
    private String filePath;

    @Column(name = "songno")
    private Integer songNo;

    @Column(name = "length")
    private String length;

    @Column(name = "quality")
    private String quality;

    @Column(name = "genres")
    private String genres;

    @Column(name = "size")
    private BigDecimal size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getSongNo() {
        return songNo;
    }

    public void setSongNo(Integer songNo) {
        this.songNo = songNo;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", album=" + album +
                ", name='" + name + '\'' +
                ", filePath='" + filePath + '\'' +
                ", songNo=" + songNo +
                ", length='" + length + '\'' +
                ", quality='" + quality + '\'' +
                ", genres='" + genres + '\'' +
                ", size=" + size +
                '}';
    }
}
