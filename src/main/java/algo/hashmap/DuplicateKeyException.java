package algo.hashmap;

public class DuplicateKeyException extends RuntimeException{

    public DuplicateKeyException() {}

    public DuplicateKeyException(String message) {
        super(message);
    }
}