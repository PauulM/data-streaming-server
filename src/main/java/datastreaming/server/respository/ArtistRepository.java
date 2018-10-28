package datastreaming.server.respository;

import datastreaming.server.model.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

    @Query("select a from Artist a where a.name = :name")
    Artist retrieveArtistByName(@Param("name") String name);

    @Query("select a from Artist a where upper(a.name) like concat('%',upper(:queryString),'%')")
    List<Artist> searchArtistsByName(@Param("queryString") String queryString);
}
