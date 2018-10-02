package datastreaming.server.service._interface;

import datastreaming.server.model.AppUser;

public interface AppUserService {

    AppUser findUserByUsername(String username);
}
