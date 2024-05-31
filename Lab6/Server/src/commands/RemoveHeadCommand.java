package commands;

import managers.CollectionManager;
import models.Organization;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;

public class RemoveHeadCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 2802183401L;
    public RemoveHeadCommand() {
        super("removeHead", false);
    }

    @Override
    public Response execute(Request request) {
        LinkedList<Organization> link = CollectionManager.getCollection();
        if (link.isEmpty()){
            return new Response("Collection is empty(no first element)");
        }
        Organization elem = link.get(0);
        link.removeFirst();
        CollectionManager.setCollection(link);
        return new Response("First: "+ elem +" element removed");
    }
}
