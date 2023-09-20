package customexception;

public class BookHandlingException extends RuntimeException

 {
    private static final long serialVersionUID = 1L;

    public BookHandlingException(String message) 

{
        super(message);
  
  }
}
