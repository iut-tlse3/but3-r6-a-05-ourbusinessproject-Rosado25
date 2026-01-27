package ourbusinessproject;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank private String name;
    @Size(min=10) private String description;
    @NotBlank private String contactName;
    @NotBlank @Email private String contactEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set Name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Set Description
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Set ContactName
     * @param contactName
     */
    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    /**
     * Set ContactEmail
     * @param contactEmail
     */
    public void setContactEmail(String contactEmail){
        this.contactEmail = contactEmail;
    }
}
