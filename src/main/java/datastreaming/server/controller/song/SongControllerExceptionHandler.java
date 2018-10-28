package datastreaming.server.controller.song;

import datastreaming.server.exception.SongNotFoundByIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {SongController.class})
public class SongControllerExceptionHandler {

    @ExceptionHandler(SongNotFoundByIdException.class)
    public ResponseEntity handleSongNotFoundById(SongNotFoundByIdException ex){
        return ResponseEntity.status(404).body(ex.getExceptionMessageAndId());
    }
}
