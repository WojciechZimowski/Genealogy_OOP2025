import java.util.HashMap;
import java.util.Map;

public class Family {
    //Mapuje zamieniam jeden element w inny np. w ASCII mapujemy litery w liczby
    //w geografii np współrzędne geograficzne w miasto
    private Map<String,Person> people = new HashMap<>();
    //wariadyczna = ...
    public void add(Person... peopleToAdd){
        for(Person p : peopleToAdd){
            add(p);
        }
    }



    public void add(Person personToAdd){
        String newKey = personToAdd.getFname() + " " + personToAdd.getLname();
        if(people.containsKey(newKey))
            return;
        people.put(newKey, personToAdd);

    }
    public Person get(String key){
       return people.get(key);
    }
    //zad7 wariadyczna to trzy kropki
}
