package datastreaming.server.security.service.implementation;

import datastreaming.server.security.model.AppUser;
import datastreaming.server.security.repository.AppUserRepository;
import datastreaming.server.security.service._interface.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser findUserByUsername(String username) {
        return appUserRepository.findByUserName(username);
    }
}
