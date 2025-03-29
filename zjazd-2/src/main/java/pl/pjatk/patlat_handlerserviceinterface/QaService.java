package pl.pjatk.patlat_handlerserviceinterface;

import org.springframework.stereotype.Service;

@Service
public class QaService implements HandlerServiceInterface {

    @Override
    public String Handler() {
        System.out.println("Hello from QA");
        return null;
    }

}
