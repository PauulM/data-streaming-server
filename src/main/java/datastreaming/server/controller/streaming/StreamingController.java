package datastreaming.server.controller.streaming;

import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.service._interface.MusicStreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api/streaming/music")
public class StreamingController {

    private MusicStreamingService musicStreamingService;

    @Autowired
    public StreamingController(MusicStreamingService musicStreamingService) {
        this.musicStreamingService = musicStreamingService;
    }

    @GetMapping("/{songId}/manifest.m3u8")
    public void getSongManifest(@PathVariable(value = "songId") Long songId, HttpServletResponse response) throws SongNotFoundByIdException, IOException {
        response.getOutputStream().write(musicStreamingService.getSongManifestFile(songId));
        response.setContentType("application/x-mpegURL");
        response.setHeader("Access-Control-Allow-Origin", "*");

    }

    @GetMapping("/{songId}/segment/{segmentNo}")
    public void getSongSegment(@PathVariable(value = "songId") Long songId,
                               @PathVariable(value = "segmentNo") Integer segmentNo,
                               HttpServletResponse response) throws SongNotFoundByIdException, IOException{
        response.setContentType("video/MP2T");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getOutputStream().write(musicStreamingService.getSongSegmentFile(songId, segmentNo));
    }

}
