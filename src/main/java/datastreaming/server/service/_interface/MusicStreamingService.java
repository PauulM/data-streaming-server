package datastreaming.server.service._interface;

import datastreaming.server.exception.SongNotFoundByIdException;

import java.io.IOException;

public interface MusicStreamingService {
    byte[] getSongManifestFile(Long songId) throws SongNotFoundByIdException, IOException;
    byte[] getSongSegmentFile(Long songId, Integer segmentNo) throws SongNotFoundByIdException, IOException;
}
