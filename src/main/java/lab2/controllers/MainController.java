package lab2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping({"", "/"})
    public ResponseEntity<Object> saveCategory() {
        return ResponseEntity.status(HttpStatus.OK).body("Successful");
    }
}
