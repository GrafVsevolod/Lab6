package commands;

import managers.CollectionManager;
import models.Organization;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;

public class RemoveCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 28438290171L;
    public RemoveCommand() {
        super("remove", true);
    }

    @Override
    public Response execute(Request request) {
        LinkedList<Organization> link = CollectionManager.getCollection();
        String[] args = request.getArgs();
        if (args.length != 2) {
            return new Response("Incorrect command, try one more time");
        } else {
            try {
                long mark = Long.parseLong(args[1]);
                var success = link.removeIf(organization -> organization.getId()==mark);
                CollectionManager.setCollection(link);
                if (!success) {
                    return new Response("Collection does not contain an element with the given id");
                } else {
                    CollectionManager.setCollection(link);
                    return new Response("Element with id: " + mark + " deleted");
                }
            } catch (NumberFormatException e) {
                return new Response("Incorrect id value");
            }
        }
    }
}
