package datastreaming.server.controller.album;

import datastreaming.server.exception.AlbumNotFoundByIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {AlbumController.class})
public class AlbumControllerExceptionHandler {

    @ExceptionHandler(AlbumNotFoundByIdException.class)
    public ResponseEntity handleAlbumNotFoundById(AlbumNotFoundByIdException ex){
        return ResponseEntity.status(404).body(ex.getExceptionMessageAndId());
    }
}
