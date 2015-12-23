package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class User {
  @NotNull
  @NotEmpty
  @Email

  private String email;

  @NotNull
  @NotEmpty
  private String name;

  @Min(0)
  @Max(150)
  private int age;
}
