package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String title;
    private String description;
    @ManyToOne
    @NotNull
    private Enterprise enterprise;

    /**
     * getEnterprise
     * @return Entreprise
     */
    public Enterprise getEnterprise() {
        return enterprise;
    }

    /**
     * setEnterprise
     * @param enterprise
     */
    public void setEnterprise( Enterprise enterprise ) {
        this.enterprise = enterprise;
    }

    /**
     * Set the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get Id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
