package ada.school.reservaFincas.service;
import ada.school.reservaFincas.exception.BreweryTourException;
import ada.school.reservaFincas.lasting.EMessage;
import ada.school.reservaFincas.user.AuthenticationDto;
import ada.school.reservaFincas.entity.User;
import ada.school.reservaFincas.user.UserDto;
import ada.school.reservaFincas.repo.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public record AuthenticationService(
        UserRepository userRepository,
        JwtService jwtService,
        PasswordEncoder passwordEncoder,

        AuthenticationManager authenticationManager
) {

    public String register(UserDto userDto) throws BreweryTourException {
        try {

            User user = User.builder()
                    .name(userDto.name())
                    .email(userDto.email())
                    .password(passwordEncoder.encode(userDto.password()))
                    .role(userDto.role())
                    .enable(true).build();
            userRepository.save(user);
            return jwtService.generateToken(user);
        } catch (DataIntegrityViolationException e) {
            throw new BreweryTourException(EMessage.USER_EXISTS);
        }
    }

    public String authenticate(AuthenticationDto authenticationDto) throws BreweryTourException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.email(),
                        authenticationDto.password()
                )
        );

        User user = userRepository.findUserByEmail(authenticationDto.email())
                .orElseThrow(() -> new BreweryTourException(EMessage.INVALID_CREDENTIALS));
        return jwtService.generateToken(user);
    }
}
