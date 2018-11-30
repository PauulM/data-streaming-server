package datastreaming.server.controller.album;

import datastreaming.server.exception.AlbumNotFoundByIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice(assignableTypes = {AlbumController.class})
public class AlbumControllerExceptionHandler {

    @ExceptionHandler(AlbumNotFoundByIdException.class)
    public ResponseEntity handleAlbumNotFoundById(AlbumNotFoundByIdException ex) {
        return ResponseEntity.status(404).body(ex.getExceptionMessageAndId());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException ex) {
        return ResponseEntity.status(500).body(ex.getMessage());
    }

}
