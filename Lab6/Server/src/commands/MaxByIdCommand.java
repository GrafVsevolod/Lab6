package commands;

import managers.CollectionManager;
import models.Organization;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;

public class MaxByIdCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 28470213L;
    public MaxByIdCommand() {
        super("maxById", false);
    }

    @Override
    public Response execute(Request request){
        int maxId = Integer.MIN_VALUE;
        Organization output = null;
        for(Organization organization : CollectionManager.getCollection()){
            if(organization.getId() > maxId){
                maxId = (int) organization.getId();
                output = organization;
            }
        }
        return new Response("Element in collection with max id: "+ output);
    }
}
