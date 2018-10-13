package datastreaming.server.security.service._interface;

import datastreaming.server.security.model.AppUser;

public interface AppUserService {

    AppUser findUserByUsername(String username);
}
