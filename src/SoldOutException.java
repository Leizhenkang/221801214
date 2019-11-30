public class SoldOutException extends Exception {
    private String message;
    public SoldOutException(String message){
        super(message);
        this.message=message;
    }
}
