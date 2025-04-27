public class AmbiguousPersonException extends Exception{
    public AmbiguousPersonException(String fname, String lname) {
        super(String.format("Person %s %s has appeared 2 or more times",fname, lname));
    }
}
