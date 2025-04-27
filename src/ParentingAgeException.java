public class ParentingAgeException extends  Exception{
    public ParentingAgeException(String fname, String lname) {
        super(String.format("Person %s %s age gap is too low",fname, lname));
    }
}
