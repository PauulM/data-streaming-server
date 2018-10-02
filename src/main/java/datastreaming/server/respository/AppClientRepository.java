package datastreaming.server.respository;

import datastreaming.server.model.AppClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AppClientRepository extends CrudRepository<AppClient,Long> {

    @Query("select c from AppClient c where c.clientName = :clientName")
    AppClient findByClientName(@Param("clientName") String clientName);
}
