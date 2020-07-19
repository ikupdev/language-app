package ru.kuper.restswag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Api(value = "language resources", description = "crud operations")
public class LanguageController {

    private LanguageRepo languageRepo;

    @GetMapping
    @ApiOperation(value = "show all languages", response = Iterable.class)
    public Iterable<Language> getAllLanguages() {
        return languageRepo.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "show language by id", response = Language.class)
    public Language getLanguageById(@PathVariable("id") Long id) {
        return languageRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create language", response = Language.class)
    public Language createLanguage(@Valid @RequestBody Language language) {
//        return languageRepo.save(new Language().setName(language.getName()).setAuthor(language.getAuthor()));
         return languageRepo.save(language);
    }

    @PostMapping("/language")
    ResponseEntity<String> addUser(@Valid @RequestBody Language language) {
        // persisting the user
        return ResponseEntity.ok("Language is valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName,errorMessage);
        });
        return errors;
    }

}
