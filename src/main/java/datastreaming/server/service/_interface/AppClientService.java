package datastreaming.server.service._interface;

import datastreaming.server.model.AppClient;

public interface AppClientService {

    AppClient findByClientName(String clientName);
}
