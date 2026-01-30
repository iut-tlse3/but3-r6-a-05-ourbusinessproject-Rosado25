package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private final EntityManager entityManager;


    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Create and persist a new project with the given title and description
     * @param aTitle the title of the project
     * @param enterprise the enterprise owning the project
     * @param aDescription the description of the project
     * @return the created project
     */
    public Project newProject(String aTitle, String aDescription, Enterprise enterprise) {
        Project project = new Project();
        project.setTitle(aTitle);
        project.setDescription(aDescription);
        project.setEnterprise(enterprise);
        this.entityManager.persist(project);
        this.entityManager.flush();
        enterprise.addProject(project);
        return project;
    }

    /**
     * Find a project by its id
     * @param id the id of the project
     * @return the found project
     */
    public Project findProjectById(Object id) {
        return entityManager.find(Project.class, id);
    }

    /**
     * Create and persist a new enterprise with the given parameters
     * @param aName the name of the enterprise
     * @param aDescription the description of the enterprise
     * @param aContactName the contact name of the enterprise
     * @param mail the contact email of the enterprise
     * @return the created enterprise
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
     * Find an enterprise by its id
     * @param anId this id is cool
     * @return the found enterprise
     */
    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class, anId);
    }

    /**
     * Find all projects ordered by title ascending
     * @return the list of all projects
     */
    public List<Project> findAllProjects() {
        String query="SELECT p FROM Project p ORDER BY title ASC";
        TypedQuery<Project> typedQuery=entityManager.createQuery(query, Project.class);
        return typedQuery.getResultList();
    }
}