package managers;

import Exceptions.NoElementException;
import Exceptions.ReplayIdException;
import Exceptions.WrongArgumentException;
import generators.IdGenerator;
import models.OrganizationType;

public class Validator {
    public static void idIsOk(String arg) throws WrongArgumentException, ReplayIdException {
        int id;
        try{
            id = Integer.parseInt(arg);
        }
        catch(Exception e){
            throw new WrongArgumentException("ID");
        }
        if(!IdGenerator.idIsUnique(id)){
            throw new ReplayIdException(id);
        }
    }
    public static void notNull(String arg, String data) throws NoElementException {
        if(arg.isEmpty() || arg.trim().isEmpty()){
            throw new NoElementException(data);
        }
    }
    public static void coordinateIsGood(String arg, String data) throws WrongArgumentException{
        try{
            int coord = Integer.parseInt(arg);
            if(coord > 904 || (String.valueOf(coord).isEmpty())){
                throw new WrongArgumentException(data);
            }
        } catch(Exception e){
            throw new WrongArgumentException(data);
        }
    }

    public static void zipCodeIsGood(String arg) throws WrongArgumentException{
        try{
            if(arg.isEmpty()){
                throw new WrongArgumentException("zipCode");
            }
        } catch (Exception e){
            throw new WrongArgumentException("zipCode");
        }
    }

    public static void typeIsGood(String arg) throws WrongArgumentException{
        try{
            OrganizationType.valueOf(arg);
        }catch (Exception e){
            throw new WrongArgumentException("OrganizationType");
        }
    }

    public static void numIsGood(String arg) throws WrongArgumentException{
        try{
            int num = Integer.parseInt(arg);
            if(num <= 0){
                throw new WrongArgumentException("number");
            }
        }catch(Exception e){
            throw new WrongArgumentException("number");
        }
    }
}
