package ourbusinessproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Get and Set the name of the enterprise
     */
    @NotBlank private String name;

    /**
     * Get and Set the description of the enterprise
     */
    @Size(min = 10)  private String description;

    /**
     * Get and Set the contact name of the enterprise
     */
    @NotBlank private String contactName;

    /**
     * Get and Set the contact email of the enterprise
     */
    @NotBlank @Email private String contactEmail;

    public Enterprise() {}

    @JsonIgnore
    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    /**
     * Add a project to the enterprise's list of projects
     * @param project the project to add
     */
    public void addProject(Project project) {
        if(this.projects == null) {
            this.projects = new ArrayList<>();
        }
        this.projects.add(project);
    }
}