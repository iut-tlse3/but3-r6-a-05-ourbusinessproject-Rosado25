package ourbusinessproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    private final EnterpriseProjectService enterpriseProjectService;

    /**
     * Create a ProjectController with the given enterprise project service
     * @param enterpriseProjectService the enterprise project service
     */
    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    /**
     * Find all projects with their associated enterprises
     */
    @GetMapping("/api/projects")
    public Iterable<Project> findAllProjectsWithEnterprises() {
        return enterpriseProjectService.findAllProjects();
    }
}
