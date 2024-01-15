package ada.school.reservaFincas.exception;

import ada.school.reservaFincas.lasting.EMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BreweryTourException extends Throwable {

    private final HttpStatus status;
    private final String message;

    public BreweryTourException(EMessage eMessage) {
        this.status = eMessage.getStatus();
        this.message = eMessage.getMessage();
    }
}
