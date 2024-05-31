package Exceptions;

public class ReplayIdException extends Exception{
    public ReplayIdException(Integer id){
        super("ID " + id + "is already used");
    }
}
