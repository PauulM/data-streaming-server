package datastreaming.server.utils;

import datastreaming.server.dto.SearchDTO;
import datastreaming.server.dto.SearchLimitOffsetDTO;
import datastreaming.server.exception.AlbumNotFoundByIdException;
import datastreaming.server.exception.ArtistNotFoundByIdException;

public interface SearchService {

    SearchDTO searchEverything(String queryString, SearchLimitOffsetDTO searchLimitOffsetDTO) throws ArtistNotFoundByIdException, AlbumNotFoundByIdException;

    Integer prepareLimit(Integer limitParam);

    Integer prepareOffset(Integer offsetParam);
}
