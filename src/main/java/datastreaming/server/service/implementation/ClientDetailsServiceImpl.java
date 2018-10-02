package datastreaming.server.service.implementation;

import datastreaming.server.respository.AppClientRepository;
import datastreaming.server.security.ClientDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ClientDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private AppClientRepository appClientRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return new ClientDetailsImpl(appClientRepository.findByClientName(s));
    }
}
