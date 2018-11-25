package datastreaming.server.controller.streaming;

import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.service._interface.MusicStreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/streaming/music")
public class StreamingController {

    private MusicStreamingService musicStreamingService;

    @Autowired
    public StreamingController(MusicStreamingService musicStreamingService) {
        this.musicStreamingService = musicStreamingService;
    }


    @GetMapping("/{songId}/manifest.m3u8")
    @CrossOrigin
    public void getSongManifest(@PathVariable(value = "songId") Long songId, HttpServletResponse response) throws SongNotFoundByIdException, IOException {
        response.getOutputStream().write(musicStreamingService.getSongManifestFile(songId));
        response.setContentType("application/x-mpegURL");
    }

    @GetMapping("/{songId}/segment/{segmentNo}")
    @CrossOrigin
    public void getSongSegment(@PathVariable(value = "songId") Long songId,
                               @PathVariable(value = "segmentNo") Integer segmentNo,
                               HttpServletResponse response) throws SongNotFoundByIdException, IOException{
        response.setContentType("video/MP2T");
        response.getOutputStream().write(musicStreamingService.getSongSegmentFile(songId, segmentNo));
    }

}
