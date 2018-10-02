package datastreaming.server.service.implementation;

import datastreaming.server.model.AppUser;
import datastreaming.server.respository.AppUserRepository;
import datastreaming.server.service._interface.AppUserService;
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
