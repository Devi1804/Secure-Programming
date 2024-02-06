package com.secureProgramming.assignment.Service;

import com.secureProgramming.assignment.Model.LogsModel;
import com.secureProgramming.assignment.Model.PhoneBookModel;
import com.secureProgramming.assignment.Repository.LoggingRepository;
import com.secureProgramming.assignment.Repository.PhoneBookRepository;
import com.secureProgramming.assignment.InputValidators.ValidateName;
import com.secureProgramming.assignment.InputValidators.ValidateNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PhoneBookService {

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @Autowired
    private LoggingRepository loggingRepository;

    public List<PhoneBookModel> getAll(){
        List<PhoneBookModel> list = phoneBookRepository.findAll();
        persistLogs("SYSTEM","GET");

        return list;
    }
    public ResponseEntity deleteByNumber(String number){
        if(ValidateNumber.isValidNumber(number)){
            List<PhoneBookModel> entries = phoneBookRepository.findAllByNumber(number);
            if(entries.size()>0){
                phoneBookRepository.deleteAll(entries);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Number Not Found!");
            }
            persistLogs(number,"DELETE");
            return ResponseEntity.ok(String.format("Records Deleted Successfully!"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone number is not Valid!");
        }
    }

    public ResponseEntity deleteByName(String name){
        if(ValidateName.isValidName(name)){
            List<PhoneBookModel> entries = phoneBookRepository.findAllByName(name);
            if(entries.size()>0){
                phoneBookRepository.deleteAll(entries);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Number with given name Not Found!");
            }
            persistLogs(name,"DELETE");
            return ResponseEntity.ok(String.format("Records Deleted Successfully!"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provided name is not Valid!");
        }
    }

    public ResponseEntity validateAndPersist(PhoneBookModel entry) throws Exception {

        boolean validName = false;
        boolean validNumber = false;

        if((entry.getName()==null) || (entry.getNumber()==null)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Either name or number is null!");
        }

        validName = ValidateName.isValidName(entry.getName());
        validNumber = ValidateNumber.isValidNumber(entry.getNumber());

        if(validName && validNumber){
            if(!check(entry.getNumber())){
                entry.setId(null==phoneBookRepository.findMaxId() ? 1 : phoneBookRepository.findMaxId()+1);
                PhoneBookModel data = phoneBookRepository.save(entry);
                persistLogs(entry.getName(),"ADD");

                return ResponseEntity.ok(data);
            } else {
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data already exists!!");
            }
        } else {
            if(!validNumber){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Number provided!");
            }
            if(!validName){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Name provided!");
            }
        }

        throw new Exception("Invalid Data!");
    }

    public ResponseEntity getAuditLogs(){
        return ResponseEntity.ok(loggingRepository.getAllLogs());
    }
    private boolean check(String number){
        List<PhoneBookModel> entry = phoneBookRepository.findAllByNumber(number);
        return !entry.isEmpty();
    }

    private LogsModel persistLogs(String op, String name){
        LogsModel log = new LogsModel();

        log.setId((null == loggingRepository.findMaxId() ? 1 : loggingRepository.findMaxId()+1));
        log.setName(name);
        log.setOp(op);
        log.setTimestamp(Instant.now());
        return loggingRepository.save(log);
    }

}
