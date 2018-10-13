package datastreaming.server.service.implementation;

import datastreaming.server.respository.UserAuthorityRepository;
import datastreaming.server.service._interface.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAuthorityServiceImpl implements UserAuthorityService {

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;
}
