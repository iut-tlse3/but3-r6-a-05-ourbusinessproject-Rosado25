package ourbusinessproject;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Enterprise {

    @NotBlank private String name;
    @Size(min=10) private String description;
    @NotBlank private String contactName;
    @NotBlank @Email private String contactEmail;

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
