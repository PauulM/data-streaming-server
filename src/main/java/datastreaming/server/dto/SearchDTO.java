package datastreaming.server.dto;

import datastreaming.server.model.Album;
import datastreaming.server.model.Artist;
import datastreaming.server.model.Song;

import java.io.Serializable;
import java.util.List;

public class SearchDTO implements Serializable {

    private static final long serialVersionUID = 1849246451758087748L;

    private List<Artist> artists;
    private List<Album> albums;
    private List<Song> songs;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
