package de.github.joshu4l;

//TODO:
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

//TODO:
/*
    BONUSAUFGABE:

    - Erweitere den Record Person um ein Enum Gender (Männlich, Weiblich, Divers).

    - Schreibe eine Methode im PersonRepository, die die Anzahl der Personen nach Geschlecht zählt
      und die Ergebnisse ausgibt.

    - Füge eine Methode im PersonRepository hinzu, die eine Person anhand ihres Namens sucht und zurückgibt.
      Die Methode soll ein Optional zurückgeben.

    - Schreibe eine Methode im PersonRepository, die alle Personen anhand ihres Lieblings-Wochentags sucht
      und zurückgibt. Die Methode solle Liste zurückgeben.
 */

import java.util.*;

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


    public Optional<Person> getPersonByName(String name) {

        // Iterate over the whole Map by using the .entrySet()
        for (Map.Entry<String, Person> entry : persons.entrySet()) {

            // use the Value (in this case the person object) of each KVP, ...
            Person person = entry.getValue();
            if (person.name().equals(name)) {return Optional.ofNullable(person);}

        } return Optional.empty();
    }


    public Map<Gender, Integer> countPersonsByGender (){

        // Create a Hashmap to be filled by the loop down below
        Map<Gender, Integer> genderCountResult = new HashMap<>();

        // Prepare a counter variable for each Gender
        int femaleCount = 0;
        int maleCount = 0;
        int diverseCount = 0;

        // Iterate over the whole Map by using the .entrySet()
        for (Map.Entry<String, Person> entry : persons.entrySet()) {

            // use the Value (in this case the person object) of each KVP, ...
            Person person = entry.getValue();

            // check the respective gender of the person and increment the corresponding counter variable
            if (person.gender().equals(Gender.FEMALE)) {femaleCount += 1;}
            else if (person.gender().equals(Gender.MALE)) {maleCount += 1;}
            else {diverseCount +=1;}
        }

        genderCountResult.put(Gender.FEMALE, femaleCount);
        genderCountResult.put(Gender.MALE, maleCount);
        genderCountResult.put(Gender.DIVERSE, diverseCount);
        return genderCountResult;
    }


    // GETTER AND SETTER
    public Map<String, Person> getPersons() {
        return persons;
    }
    public void setPersons(Map<String, Person> persons) {
        this.persons = persons;
    }
}

