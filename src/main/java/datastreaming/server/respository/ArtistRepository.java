package datastreaming.server.respository;

import datastreaming.server.model.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

    @Query("select a from Artist a where a.name = :name")
    Artist retrieveArtistByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Artists WHERE UPPER(artistname) LIKE CONCAT('%',upper(?1),'%') LIMIT ?2 OFFSET ?3", nativeQuery = true)
    List<Artist> searchArtistsByName(String queryString, Integer limit, Integer offset);

    @Query(value = "SELECT * FROM Artists LIMIT ?1 OFFSET ?2", nativeQuery = true)
    List<Artist> findAll(Integer limit, Integer offset);
}
