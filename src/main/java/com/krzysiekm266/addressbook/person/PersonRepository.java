package com.krzysiekm266.addressbook.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person,Long>{
    
}
