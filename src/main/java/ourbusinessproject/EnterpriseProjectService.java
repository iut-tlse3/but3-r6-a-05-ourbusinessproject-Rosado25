package ourbusinessproject;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseProjectService {

    private EntityManager entityManager;

    /**
     * EnterpriseProjectService
     * @param entityManager
     */
    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * getEntityManager
     * @return entityManager
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     * newProject
     * @param title
     * @param description
     * @return project
     */
    public Project newProject(String title, String description) {
        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        this.entityManager.persist(project);
        this.entityManager.flush();
        return project;
    }

    /**
     * newEnterprise
     * @param aName
     * @param aDescription
     * @param aContactName
     * @param mail
     * @return enterprise
     */
    public Enterprise newEnterprise(String aName, String aDescription, String aContactName, String mail) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(aName);
        enterprise.setDescription(aDescription);
        enterprise.setContactName(aContactName);
        enterprise.setContactEmail(mail);
        this.entityManager.persist(enterprise);
        this.entityManager.flush();
        return enterprise;
    }

    /**
     * findProjectById
     * @param anId
     * @return project
     */
    public Project findProjectById(Long anId) {
        return entityManager.find(Project.class, anId);
    }

    /**
     * findEnterpriseById
     * @param anId
     * @return Enterprise
     */
    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class, anId);
    }
}
