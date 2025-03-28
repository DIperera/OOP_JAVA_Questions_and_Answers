package labtestquestions;

// Custom exception for phone numbers with invalid length
public class InvalidPhoneNumberDigits extends Exception {
    public InvalidPhoneNumberDigits(String message) {
        super(message);
    }
}
