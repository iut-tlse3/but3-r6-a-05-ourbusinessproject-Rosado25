package ourbusinessproject;

import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {

    @Getter private Project project1E1;
    @Getter private Project project1E2;
    @Getter private Project project2E1;
    @Getter private Enterprise enterprise1;
    @Getter private Enterprise enterprise2;

    /**
     * This method initializes the project data.
     */
    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    /**
     * Initialization of the initial list of projects
     */
    @Transactional
    public void initProjects() {

        /*
          Grâce à l'annotation @Transactional, Spring exécute toute cette méthode
          dans une seule transaction de base de données.

          Cela garantit la propriété d'atomicité : soit tous les projets sont créés,
          soit aucun ne l'est.
         */

        initEnterprise();
        project1E1 = enterpriseProjectService.newProject("p1E1","P1E1 desc",enterprise1);
        project1E2 = enterpriseProjectService.newProject("p1E2","P1E2 desc",enterprise2);
        project2E1 = enterpriseProjectService.newProject("p2E1","P2E1 desc",enterprise1);
    }

    private void initEnterprise() {
        // enterprise 1
        enterprise1 = enterpriseProjectService.newEnterprise(
                "MyComp1",
                "My comp1 description",
                "comp1 contact name",
                "comp1@com.com");
        // enterprise 2
        enterprise2 = enterpriseProjectService.newEnterprise(
                "MyComp2",
                "My comp2 description",
                "comp2 contact name",
                "comp2@com.com");
    }

}