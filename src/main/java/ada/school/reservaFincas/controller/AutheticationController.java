package ada.school.reservaFincas.controller;
import ada.school.reservaFincas.exception.BreweryTourException;
import ada.school.reservaFincas.service.AuthenticationService;
import ada.school.reservaFincas.user.AuthenticationDto;
import ada.school.reservaFincas.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public record AutheticationController(
        AuthenticationService authenticationService

) {

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) throws BreweryTourException {
        String token = authenticationService.register(userDto);
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationDto authenticationDto) throws BreweryTourException {
        String token = authenticationService.authenticate(authenticationDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}