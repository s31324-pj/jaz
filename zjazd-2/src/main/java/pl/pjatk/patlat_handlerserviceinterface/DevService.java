package pl.pjatk.patlat_handlerserviceinterface;

import org.springframework.stereotype.Service;

@Service
public class DevService implements HandlerServiceInterface {

    @Override
    public String Handler() {
        System.out.println("Hello from Dev");
        return null;
    }

}
