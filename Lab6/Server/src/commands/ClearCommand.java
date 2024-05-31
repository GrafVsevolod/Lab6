package commands;

import managers.CollectionManager;
import models.Organization;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;

public class ClearCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 2822489202L;

    public ClearCommand() {
        super("clear", false);
    }

    @Override
    public Response execute(Request request) {
        // Clear the collection of organizations
        LinkedList<Organization> list = CollectionManager.getCollection();
        list.clear();
        return new Response("Collection was cleared");
    }
}
