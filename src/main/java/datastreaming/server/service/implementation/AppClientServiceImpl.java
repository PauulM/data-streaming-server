package datastreaming.server.service.implementation;

import datastreaming.server.model.AppClient;
import datastreaming.server.respository.AppClientRepository;
import datastreaming.server.service._interface.AppClientService;
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
