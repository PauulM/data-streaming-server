package datastreaming.server.respository;

import datastreaming.server.model.UserAuthority;
import org.springframework.data.repository.CrudRepository;

public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Long> {
}
