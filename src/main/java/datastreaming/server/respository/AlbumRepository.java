package datastreaming.server.respository;

import datastreaming.server.model.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    @Query(value = "SELECT * FROM Albums WHERE artistid = ?1 LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Album> findAlbumsByArtistId(Long artistId, Integer limit, Integer offset);

    @Query(value = "SELECT * FROM Albums WHERE UPPER(albumname) LIKE CONCAT('%',upper(?1),'%') LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Album> searchAlbumsByName(String queryString, Integer limit, Integer offset);

    @Query(value = "SELECT * FROM Albums WHERE UPPER(albumname) = UPPER(?1)", nativeQuery = true)
    List<Album> searchAlbumsByNameAccurate(String queryString);

    @Query(value = "SELECT * FROM Albums LIMIT ?1 OFFSET ?2", nativeQuery = true)
    List<Album> findAll(Integer limit, Integer offset);

}
