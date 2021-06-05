public class InvalidIDException extends Exception
{
    private String msg;

    public InvalidIDException()
    {
        msg = null;
    }

    public InvalidIDException(String message)
    {
        msg = message;
    }
    
    @Override
    public String getMessage() {
        return msg;
    }
}
