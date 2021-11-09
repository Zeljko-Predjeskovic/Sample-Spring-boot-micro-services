package spg.pre.microservices.musicmanager.domain.Exceptions;

public class ServiceException extends RuntimeException{

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception innerException){
        super(message, innerException);
    }
}
