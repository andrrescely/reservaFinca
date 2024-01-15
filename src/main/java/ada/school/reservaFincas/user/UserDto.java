package ada.school.reservaFincas.user;

import ada.school.reservaFincas.lasting.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(
        Integer id,
        String name,
        String email,
        @JsonIgnore(value = false)//que el password no se muestre a la hora de consultar
        String password,
        ERole role,
        Boolean enable) {
}
