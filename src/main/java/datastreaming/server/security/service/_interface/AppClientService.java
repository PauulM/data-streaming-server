package datastreaming.server.security.service._interface;

import datastreaming.server.security.model.AppClient;

public interface AppClientService {

    AppClient findByClientName(String clientName);
}
