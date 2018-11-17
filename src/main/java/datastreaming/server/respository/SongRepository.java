package datastreaming.server.respository;

import datastreaming.server.model.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {

    @Query("select s from Song s where s.album.id = :albumId")
    List<Song> retrieveSongsByAlbumId(@Param("albumId") Long albumId);

    @Query(value = "SELECT * FROM Songs WHERE UPPER(songname) LIKE CONCAT('%',upper(?1),'%') LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Song> searchSongsByName(String queryString, Integer limit, Integer offset);
}
