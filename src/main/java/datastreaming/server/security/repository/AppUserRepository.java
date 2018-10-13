package datastreaming.server.security.repository;

import datastreaming.server.security.model.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    @Query("select u from AppUser u where u.userName = :userName")
    AppUser findByUserName(@Param("userName") String userName);
}
