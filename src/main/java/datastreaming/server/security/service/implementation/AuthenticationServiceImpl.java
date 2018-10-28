package datastreaming.server.security.service.implementation;

import datastreaming.server.security.model.AppUser;
import datastreaming.server.security.service._interface.AppUserService;
import datastreaming.server.security.service._interface.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public AppUser getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return appUserService.findUserByUsername(authentication.getPrincipal().toString());
    }
}
