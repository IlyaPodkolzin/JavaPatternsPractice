package java.org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
}
