package datastreaming.server.controller.streaming;

import datastreaming.server.exception.SongNotFoundByIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice(assignableTypes = {StreamingController.class})
public class StreamingControllerExceptionHandler {

    @ExceptionHandler(SongNotFoundByIdException.class)
    public ResponseEntity handleSongNotFoundById(SongNotFoundByIdException ex){
        return ResponseEntity.status(404).body(ex.getExceptionMessageAndId());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException ex){
        return ResponseEntity.status(500).body(ex.getMessage());
    }
}
