package pl.pjatk.zjazd4patlat;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UseMineException {

    @GetMapping("/use-exception")
    public MineException handleRuntimeException(final RuntimeException e) {
        throw new RuntimeException("Exception occurred on request. Exception message: " + e.getLocalizedMessage());
    }

}
