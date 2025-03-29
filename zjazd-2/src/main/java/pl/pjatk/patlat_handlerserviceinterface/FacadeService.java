package pl.pjatk.patlat_handlerserviceinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.lang.System.getProperty;

@Service
public class FacadeService {

    private final List<HandlerServiceInterface> services;
    private String environment;

    public FacadeService(List<HandlerServiceInterface> services, @Value("${app.environment:dev}") String environment) {
        this.services = services;
        this.environment = environment;
    }

    public String execute(String requestParam) {
        switch (environment.toLowerCase()) {
            case "dev":
                for (HandlerServiceInterface service : services) {
                    if (service instanceof DevService) {
                        return service.Handler();
                    }
                }
                throw new IllegalStateException("Brak DevService");

            case "qa":
                for (HandlerServiceInterface service : services) {
                    if (service instanceof QaService) {
                        return service.Handler();
                    }
                }
                throw new IllegalStateException("Brak QaService");

            case "prod":
                for (HandlerServiceInterface service : services) {
                    if (service instanceof ProdService) {
                        return service.Handler();
                    }
                }
                throw new IllegalStateException("Brak ProdService");

            default:
                throw new IllegalStateException("Nieznane środowisko: " + environment);
        }
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }


}
