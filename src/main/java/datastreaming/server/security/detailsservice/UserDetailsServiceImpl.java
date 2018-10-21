package datastreaming.server.security.detailsservice;

import datastreaming.server.security.details.UserDetailsImpl;
import datastreaming.server.security.model.AppUser;
import datastreaming.server.security.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUserName(username);
        if(appUser == null)
            throw new UsernameNotFoundException("Invalid user");
        return new UserDetailsImpl(appUser);
    }
}
