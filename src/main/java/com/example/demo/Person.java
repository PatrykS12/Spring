package com.example.demo;

public class Person {

    private String firstName;
    private String familyName;

    // Konstruktor
    public Person() {
    }

    // Konstruktor z parametrami
    public Person(String firstName, String familyName) {
        this.firstName = firstName;
        this.familyName = familyName;
    }

    // getter dla firstName
    public String getFirstName() {
        return firstName;
    }

    // setter dla firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // getter dla familyName
    public String getFamilyName() {
        return familyName;
    }

    // setter dla familyName
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

}
