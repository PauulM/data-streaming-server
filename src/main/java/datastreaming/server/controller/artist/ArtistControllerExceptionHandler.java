package datastreaming.server.controller.artist;

import datastreaming.server.exception.ArtistNotFoundByIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {ArtistController.class})
public class ArtistControllerExceptionHandler {

    @ExceptionHandler(ArtistNotFoundByIdException.class)
    public ResponseEntity handleArtistNotFound(ArtistNotFoundByIdException ex){
        return ResponseEntity.status(404).body(ex.getExceptionMessageAndId());
    }
}
