import java.time.LocalDate;
import java.util.Set;

public class Person {


        private String fname, lname;

        private LocalDate birthDate;

        private Set<Person> children;

        public boolean adopt(Person child){
            return children.add(child);

        }
        public Person getYoungestChild(){
            if(children.isEmpty())
                return null;
            LocalDate maxDate = LocalDate.now();
            for(Person child : children){
                child.birthDate = maxDate;

            }
        }


    }

