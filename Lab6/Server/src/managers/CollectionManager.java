package managers;

import Exceptions.NoElementException;
import Exceptions.ReplayIdException;
import Exceptions.WrongArgumentException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import generators.IdGenerator;
import models.Organization;
import network.Request;
import network.Response;
import system.XMLSerializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.LinkedList;
@XStreamAlias("collectionManager")
public class CollectionManager {
    @XStreamImplicit(itemFieldName = "organization")
    public static LinkedList<Organization> list = new LinkedList<>();
    public static LocalDate date;

    static{
        list = new LinkedList<>();
        date = LocalDate.now();
    }

    public CollectionManager(){
        list = new LinkedList<>();
        date = LocalDate.now();
    }
    public static LocalDate InitDate(){
        return date;
    }

    public static Response add(Organization organization) {
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(organization);
        IdGenerator.add(organization.getId());
        return new Response("Organization added successfully");
    }

    public static void remove(Organization organization) throws NoElementException {
        if(list == null || (!list.contains(organization))){
            throw new NoElementException("list not contains element");
        }
        else{
            IdGenerator.remove(organization.getId());
            list.remove(organization);
        }
    }

    public static Response save(String[] args) {
        // Get the path to the XML file
        String path = args[1];
        // Create an XStream instance with a DOM driver
        XMLSerializer stream = new XMLSerializer();

        // Convert the collection to XML format
        String xml = stream.serialize(list);

        try {
            // Write the XML data to the specified file
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path));
            byte[] bytes = xml.getBytes();
            output.write(bytes);
            output.close();
            System.out.println("JHDBHJXDHBJ");
            return new Response("Collection saved");
        } catch (Exception e) {
            return new Response("Error occured while saving");
        }
    }

    public static void setCollection(LinkedList<Organization> li){
        list = li;
    }

    public static void clear(){
        list.clear();
    }

    public static LinkedList<Organization> getCollection(){
        return list;
    }
}
