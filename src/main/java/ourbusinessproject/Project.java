package ourbusinessproject;

import jakarta.validation.constraints.NotEmpty;

public class Project {

    @NotEmpty
    private String title;
    private String description;

    public Project() {}

    public void setDescription(String description) {
        this.description = description;

    }

    public void setTitle(String title) {
        this.title = title;


    }
}
