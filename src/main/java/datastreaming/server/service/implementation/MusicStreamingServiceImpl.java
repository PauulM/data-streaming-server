package datastreaming.server.service.implementation;

import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.model.Song;
import datastreaming.server.respository.SongRepository;
import datastreaming.server.service._interface.MusicStreamingService;
import datastreaming.server.service._interface.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class MusicStreamingServiceImpl implements MusicStreamingService {

    private SongService songService;

    @Autowired
    public MusicStreamingServiceImpl(SongService songService) {
        this.songService = songService;
    }

    @Override
    public byte[] getSongManifestFile(Long songId) throws SongNotFoundByIdException, IOException {
        Song song = songService.retrieveSongById(songId);
        return loadFile(song.getManifestFilePath());
    }

    private byte[] loadFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        return buffer;
    }

    @Override
    public byte[] getSongSegmentFile(Long songId, Integer segmentNo) throws SongNotFoundByIdException, IOException {
        Song song = songService.retrieveSongById(songId);
        return loadFile(song.getSegmentFilePrefix() + segmentNo + ".ts");
    }
}
