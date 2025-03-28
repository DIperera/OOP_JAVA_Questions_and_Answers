package labtestquestions;

// Custom exception for phone numbers not starting with '0'
public class InvalidPhoneNumberStart extends Exception {
    public InvalidPhoneNumberStart(String message) {
        super(message);
    }
}
