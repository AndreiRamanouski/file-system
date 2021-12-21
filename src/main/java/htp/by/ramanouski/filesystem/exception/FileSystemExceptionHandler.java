package htp.by.ramanouski.filesystem.exception;


import htp.by.ramanouski.filesystem.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FileSystemExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<MessageException> handleFileServiceException(ServiceException exception) {
        MessageException returnedValue = MessageException.builder()
                .message(exception.getMessage()).status(HttpStatus.NOT_FOUND.value())
                .timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(returnedValue, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<MessageException> handleFileServiceException(Exception exception) {
        MessageException returnedValue = MessageException.builder()
                .message(exception.getMessage()).status(HttpStatus.NOT_FOUND.value())
                .timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(returnedValue, HttpStatus.NOT_FOUND);
    }


}
