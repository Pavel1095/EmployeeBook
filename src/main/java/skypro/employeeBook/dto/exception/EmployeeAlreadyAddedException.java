package skypro.employeeBook.dto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Такой сотрудник уже существует.")
public class EmployeeAlreadyAddedException extends RuntimeException{
}