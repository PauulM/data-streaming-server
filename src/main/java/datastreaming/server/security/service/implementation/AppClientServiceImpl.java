package datastreaming.server.security.service.implementation;

import datastreaming.server.security.model.AppClient;
import datastreaming.server.security.repository.AppClientRepository;
import datastreaming.server.security.service._interface.AppClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppClientServiceImpl implements AppClientService {

    @Autowired
    private AppClientRepository appClientRepository;

    @Override
    public AppClient findByClientName(String clientName) {
        return appClientRepository.findByClientName(clientName);
    }
}
