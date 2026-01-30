package ourbusinessproject;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Partnership {

    @Setter
    @NotNull
    private Date CreationDate;
    @NotNull
    @Setter
    private Enterprise enterprise;
    @NotNull
    @Setter
    private Project project;

}
