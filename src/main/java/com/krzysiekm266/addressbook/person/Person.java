package com.krzysiekm266.addressbook.person;

import java.util.HashSet;
import java.util.Set;

import com.krzysiekm266.addressbook.phone.Phone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", columnDefinition = "TEXT")
    private  String firstName;

    @Column(name = "last_name",columnDefinition = "TEXT")
    private String lastName;

    @OneToMany(mappedBy = "person",orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Phone> phone  = new HashSet<>();
}
