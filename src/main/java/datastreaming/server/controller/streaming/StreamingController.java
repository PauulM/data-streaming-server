package datastreaming.server.controller.streaming;

import datastreaming.server.exception.SongNotFoundByIdException;
import datastreaming.server.service._interface.MusicStreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/streaming/music")
public class StreamingController {

    private MusicStreamingService musicStreamingService;

    @Autowired
    public StreamingController(MusicStreamingService musicStreamingService) {
        this.musicStreamingService = musicStreamingService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.OPTIONS, value = "/{songId}/manifest.m3u8")
    public void aaa(@PathVariable(value = "songId") Long songId, HttpServletResponse response, HttpServletRequest request){
        Map<String, String> m = getHeadersInfo(request);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }

    @CrossOrigin
    @GetMapping("/{songId}/manifest.m3u8")
    public void getSongManifest(@PathVariable(value = "songId") Long songId, HttpServletResponse response, HttpServletRequest request) throws SongNotFoundByIdException, IOException {
        Map<String, String> m = getHeadersInfo(request);
        response.getOutputStream().write(musicStreamingService.getSongManifestFile(songId));
        response.setContentType("application/x-mpegURL");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }

    @CrossOrigin
    @GetMapping("/{songId}/segment/{segmentNo}")
    public void getSongSegment(@PathVariable(value = "songId") Long songId,
                               @PathVariable(value = "segmentNo") Integer segmentNo,
                               HttpServletResponse response) throws SongNotFoundByIdException, IOException{
        response.setContentType("video/MP2T");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        response.getOutputStream().write(musicStreamingService.getSongSegmentFile(songId, segmentNo));
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

}
