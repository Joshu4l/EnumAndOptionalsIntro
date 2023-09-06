package de.github.joshu4l;

/*
    Erstellt ein neues Projekt in IntelliJ und implementiert die folgenden Schritte.

    Schritt 1: Erstelle ein Enum DaysOfWeek mit den Wochentagen (Montag bis Sonntag).
    Schritt 2: Schreibe eine Methode, die den übergebenen Wochentag als String zurückgibt, wenn er
               ein Werktag (Montag bis Freitag) ist, andernfalls gib 'Wochenende' zurück.
    Schritt 3: Erstelle ein Record 'Person' mit den Eigenschaften 'id', 'name' und 'favoriteDay',
               wobei 'favoriteDay' vom Typ DaysOfWeek ist.
    Schritt 4: Erstelle eine Klasse PersonRepository mit einer Liste/Map von Personen.
    Schritt 5: Schreibe eine Methode in der Klasse PersonRepository, die eine Person anhand ihrer Id
               aus der Liste/Map sucht und zurückgibt. Die Methode soll ein Optional zurückgeben.
    Schritt 6: überprüft in euerer Main-Methode, ob es die Person gibt. Wenn es sie gibt,
               dann gib den Namen und den Lieblings-Wochentag auf der Konsole aus.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonRepository {

    private Map<String, Person> persons = new HashMap<>();

    // CONSTRUCTORS
    public PersonRepository(){
        // Default Constructor
    }
    public PersonRepository(Map<String, Person> persons){
        // Custom Constructor
        this.persons = persons;
    }


    // CUSTOM METHODS
    public Optional<Person> getPersonById(String id) {
        if (persons.containsKey(id)) {
            return Optional.ofNullable(persons.get(id));
        } else {
            return Optional.empty();
        }
    }


    // GETTER AND SETTER
    public Map<String, Person> getPersons() {
        return persons;
    }
    public void setPersons(Map<String, Person> persons) {
        this.persons = persons;
    }
}
