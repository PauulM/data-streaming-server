package datastreaming.server.controller;

import datastreaming.server.model.Artist;
import datastreaming.server.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/hello")
public class TestController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/{name}")
    Artist hello(@PathVariable String name) {
        return artistService.retrieveArtistByName(name);
    }
}