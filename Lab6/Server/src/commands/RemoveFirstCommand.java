package commands;

import managers.CollectionManager;
import models.Organization;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class RemoveFirstCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 48201818413920L;
    public RemoveFirstCommand() {
        super("removeFirst", false);
    }

    @Override
    public Response execute(Request request) {
        LinkedList<Organization> link = CollectionManager.getCollection();
        if (link.isEmpty()){
            return new Response("Collection is empty(no first element)");
        }
        link.removeFirst();
        return new Response("First element removed");
    }
}
