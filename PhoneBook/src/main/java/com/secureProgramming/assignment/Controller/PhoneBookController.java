package com.secureProgramming.assignment.Controller;

import com.secureProgramming.assignment.Model.PhoneBookModel;
import com.secureProgramming.assignment.Service.PhoneBookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PhoneBook")
public class PhoneBookController {

    private final PhoneBookService phoneBookService;

    @Autowired
    public PhoneBookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @Operation(description = "Get the phonebook list")
    @GetMapping(path = "/list")
    public List<PhoneBookModel> list() {
        return phoneBookService.getAll();
    }

    @Operation(description = "Add a phone number and name")
    @PostMapping(path = "/add")
    public ResponseEntity<Void> add(@RequestBody PhoneBookModel phoneBookModel) {
        try {
            phoneBookService.validateAndPersist(phoneBookModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(description = "Delete an entry by name")
    @DeleteMapping(path = "/deleteByName/{name}")
    public ResponseEntity<Void> deleteByName(@PathVariable String name) {
        try {
            phoneBookService.deleteByName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(description = "Delete an entry by number")
    @DeleteMapping(path = "/deleteByNumber/{number}")
    public ResponseEntity<Void> deleteByNumber(@PathVariable String number) {
        try {
            phoneBookService.deleteByNumber(number);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(description = "Get audit logs")
    @GetMapping(path = "/list/audit")
    public ResponseEntity<?> getAuditLogs() {
        return phoneBookService.getAuditLogs();
    }
}
