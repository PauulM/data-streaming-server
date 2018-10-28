package datastreaming.server.respository;

import datastreaming.server.model.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    @Query("select a from Album a where a.artist.id = :artistId")
    List<Album> findAlbumsByArtistId(@Param("artistId") Long artistId);

    @Query("select a from Album a where upper(a.name) like concat('%',upper(:queryString),'%')")
    List<Album> searchAlbumsByName(@Param("queryString") String queryString);
}
