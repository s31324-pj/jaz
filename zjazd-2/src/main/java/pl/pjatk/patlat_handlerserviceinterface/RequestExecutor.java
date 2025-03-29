package pl.pjatk.patlat_handlerserviceinterface;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class RequestExecutor {



    public RequestExecutor(FacadeService facadeService) {

    }


}
