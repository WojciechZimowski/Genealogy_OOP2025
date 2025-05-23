import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

    //    List<Person> people = Person.fromCsv("family.csv");
        //people.get(0).toUML()
//        System.out.println("END OF PROGRAM");
        List<Person> people = new ArrayList<>();
        Person parent = new Person("Alojzy", "Czeremcha", LocalDate.of(1903,12,7),LocalDate.of(2000,7,12));
        Person child1 = new Person("Grażyna", "Duda", LocalDate.of(1951,4,7), LocalDate.of(2002,7,12));
        Person child2 = new Person("Ksawery", "Czeremcha", LocalDate.of(1955,8,12) ,LocalDate.of(2001,7,12));
        Person child3 = new Person("Brajan", "Czeremcha", LocalDate.of(1959,2,18));
        Person child4 = new Person("Dżesika", "Mercedes", LocalDate.of(2000,7,11));
        people.add(parent);
        people.add(child1);
        people.add(child2);
        people.add(child3);
        people.add(child4);
     child1.setFather(parent);
        parent.adopt(child1);
        parent.adopt(child2);
        parent.adopt(child3);
        parent.adopt(child4);
        //System.out.println("ufjjdjjdjdd");
        //zadanie 5 programowanie funkcyjne PD
        //System.out.println("\n Zadanie 5 Latami urodzenia do najmłodszego\n");
        List<Person> sortPeopleByBirthYear = Person.sortPeopleByBirthYear(people);
        for(Person p : sortPeopleByBirthYear){
           //System.out.println(p.getFname()+ " "+p.getLname()+ " "+ p.getBirthDate().getYear());
        }
       // System.out.println("\n Zadanie 6 Latami życia w dół\n");
        //zadanie 6 programowanie funkcyjne Pd
        List<Person> getSortedDeceased = Person.getSortedDeceased(people);
        for(Person p : getSortedDeceased){
            if(p.getDeathDate()!=null) {
                long lifespan = Period.between(p.getBirthDate(), p.getDeathDate()).getYears();
                //System.out.println(p.getFname() + " " + p.getLname() + " " + lifespan + "lat");

            }
        }
        //zadnie 3 programowanie Generyczne
        CustomList<Person> iterableList = new CustomList<>();
        iterableList.add(parent);
        iterableList.add(child1);
        iterableList.add(child2);
        iterableList.add(child3);
        iterableList.add(child4);
        for(Person p : iterableList){
            //System.out.println(p.getFname()+" "+ p.getLname());
        }
        //Zadanie 4 PD programowanie generyczne
        List<Object> random = List.of(new Person("Jan"," Ian", LocalDate.of(2000,2,2)),
                43,
                24);
        List<Object> persons = CustomList.returnPointedClass(random, Person.class);

        for(Object obj: persons){
            System.out.println(obj);
        }

        };


}