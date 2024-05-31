package generators;

import java.util.LinkedList;
import java.util.Random;

public class IdGenerator {
    public static LinkedList<Integer> idList = new LinkedList<>();
    static int max = 1000000;
    static int min = 100;
    public IdGenerator(){
        idList = new LinkedList<>();
    }
    public static int generateID(){
        int id = (int) Math.floor(Math.random()*(max - min + 1)+ min);
        idList.add(id);
        return id;
    }
    public static boolean idIsUnique(int id){
        if(idList.contains(id)){
            return false;
        }
        else{
            return true;
        }
    }
    public static void add(int id){
        idList.add(id);
    }
    public static void remove(int id){
        idList.remove(id);
    }
}
