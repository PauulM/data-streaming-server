package datastreaming.server.respository;

import datastreaming.server.model.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {

    @Query(value = "SELECT * FROM Songs WHERE albumid = ?1 LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Song> retrieveSongsByAlbumIdWithLimit(Long albumId, Integer limit, Integer offset);

    @Query(value = "SELECT * FROM Songs WHERE albumid = ?1", nativeQuery = true)
    List<Song> retrieveSongsByAlbumId(Long albumId);

    @Query(value = "SELECT * FROM Songs WHERE UPPER(songname) LIKE CONCAT('%',upper(?1),'%') LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Song> searchSongsByName(String queryString, Integer limit, Integer offset);

    @Query(value = "SELECT * FROM Songs LIMIT ?1 OFFSET ?2", nativeQuery = true)
    List<Song> findAll(Integer limit, Integer offset);
}
