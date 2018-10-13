package datastreaming.server.service.implementation;

import datastreaming.server.respository.ClientAuthorityRepository;
import datastreaming.server.service._interface.ClientAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientAuthorityServiceImpl implements ClientAuthorityService {

    @Autowired
    private ClientAuthorityRepository clientAuthorityRepository;
}
