package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if(phonebook.containsKey(name)){
            phonebook.get(name).add(phoneNumber);
        }
        else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phonebook.put(name,phoneNumbers);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        if(phonebook.containsKey(name)){
            phonebook.get(name).addAll(List.of(phoneNumbers));
        }
        else {
            List<String> phoneNumbs = new ArrayList<>(List.of(phoneNumbers));
            phonebook.put(name,phoneNumbs);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }
    public Boolean hasEntry(String name, String number) {
        return phonebook.containsKey(name)  && phonebook.get(name).contains(number);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String,List<String>> person: phonebook.entrySet()
             ) {
            if(person.getValue().contains(phoneNumber)) return person.getKey();
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
