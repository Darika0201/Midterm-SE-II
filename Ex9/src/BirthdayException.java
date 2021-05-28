public class BirthdayException extends Exception{
    public BirthdayException(){
        super("Invalid date of Birth, age at lease 15 years old");
    }
}
