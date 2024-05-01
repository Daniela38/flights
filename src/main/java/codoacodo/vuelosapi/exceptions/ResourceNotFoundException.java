package codoacodo.vuelosapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFoundException extends IllegalArgumentException {
    private  String resourceName;
    private String fieldName;
    private Long value;

    public ResourceNotFoundException(String resourceName, String fieldName, Long value) {
        super(String.format("%s not found with: %s, '%s'"));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }
}
