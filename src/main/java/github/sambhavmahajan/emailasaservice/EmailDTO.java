package github.sambhavmahajan.emailasaservice;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO {
    @NotNull
    private String password;
    @Email
    @NotNull
    private String to;
    @NotNull
    private String subject;
    @NotNull
    private String body;
}
