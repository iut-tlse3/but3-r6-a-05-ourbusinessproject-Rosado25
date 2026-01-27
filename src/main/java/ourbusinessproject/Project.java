package ourbusinessproject;

import jakarta.validation.constraints.NotBlank;

public class Project {

    @NotBlank
    private String title;
    private String description;

    /**
     * Set the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
