package errors;

public class AlreadyExistingMemberException extends Exception {
    public AlreadyExistingMemberException(String message) {
        super(message);
    }
}
