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

public class Main {
    public static void main(String[] args) {

        // Instantiate an Object using the DaysOfWeek enum
        DaysOfWeek myWeekDay = DaysOfWeek.SATURDAY;
        // Check its progress within the week
        System.out.println(myWeekDay.progressWithinWeek());
        System.out.println("\n");

        // Instantiate a few person objects, ...
        Person my1stPerson = new Person("P-0001", "Anne", DaysOfWeek.SATURDAY);
        Person my2ndPerson = new Person("P-0002", "Diana", DaysOfWeek.SUNDAY);
        Person my3rdPerson = new Person("P-0003", "josh", DaysOfWeek.FRIDAY);
        // ... put them into a Map, ...
        Map<String, Person> personsToBeAdded = new HashMap<>();
        personsToBeAdded.put(my1stPerson.id(), my1stPerson);
        personsToBeAdded.put(my2ndPerson.id(), my2ndPerson);
        personsToBeAdded.put(my3rdPerson.id(), my3rdPerson);
        //  and hand it over to our PersonRepo
        PersonRepository myPersonRepo = new PersonRepository(personsToBeAdded);


        /*
            Now, query for a specific person within the PersonRepo
            BUT: Consider, that the return type will be an optional!
         */
        Optional<Person> optionalPerson = myPersonRepo.getPersonById("P-0001");

        System.out.println("*** Your Query Results: ***");

        // ... Therefor, check if the Optional that was returned is even populated:
        if (optionalPerson.isPresent()) {
            // if so, print some of his / her credentials:
            Person populatedPersonObject = optionalPerson.get();
            System.out.println("The name of the person you searched is:  " + populatedPersonObject.name());
            System.out.println("His/her favorite day of the week is:     " + populatedPersonObject.favoriteDay());
        } else {
            // otherwise state that such a person couldn't be found
            System.out.println("Person nicht vorhanden");
        }


    }
}
