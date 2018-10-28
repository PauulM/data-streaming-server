package datastreaming.server.respository;

import datastreaming.server.model.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {

    @Query("select s from Song s where s.album.id = :albumId")
    public List<Song> retrieveSongsByAlbumId(@Param("albumId") Long albumId);
}
