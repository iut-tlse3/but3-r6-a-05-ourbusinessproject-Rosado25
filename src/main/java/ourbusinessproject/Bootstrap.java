package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Bootstrap {
    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    @Getter
    private final InitializationService initializationService;

    /**
     * Create a Boostrap objet with the given initialisation service
     * @param initializationService the initialisation service
     */
    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            this.initializationService.initProjects();
        } catch (RuntimeException e) {
            logger.error("Error during initialization", e);
        }
    }

}