package datastreaming.server.utils;

import datastreaming.server.dto.SearchDTO;

public interface SearchService {

    SearchDTO searchEverything(String queryString, Integer limit, Integer offset);
    Integer prepareLimit(Integer limitParam);
    Integer prepareOffset(Integer offsetParam);
}
