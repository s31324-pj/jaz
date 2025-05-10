package pl.pjatk.zjazd4patlat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class MineException {


    @GetMapping("/exception")
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(final RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception message: " + e.getLocalizedMessage());
    }

}
