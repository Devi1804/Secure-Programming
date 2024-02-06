package com.secureProgramming.assignment.Repository;

import com.secureProgramming.assignment.Model.PhoneBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBookModel,Integer> {

    @Query(value = "select p from PhoneBookModel p where p.name = ?1")
    public List<PhoneBookModel> findAllByName(String name);

    @Query(value = "select p from PhoneBookModel p where p.number = ?1")
    public List<PhoneBookModel> findAllByNumber(String number);

    @Query(value = "select max(p.id) from PhoneBookModel p")
    public Integer findMaxId();

}
