package commands;

import managers.CollectionManager;
import models.Organization;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UpdateCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 2840380217L;

    public UpdateCommand() {
        super("update", true);
    }

    @Override
    public Response execute(Request request) {
        // Get the collection of organizations
        Organization[] link = CollectionManager.getCollection().toArray(new Organization[0]);

        String[] args = request.getArgs();
        // Check if the command is entered correctly
        if (args.length != 2) {
            return new Response("Incorrect command, try one more time");
        } else {
            try {
                long mark = Long.parseLong(args[1]);
                List list = Arrays.stream(link).filter(organization -> organization.getId() == mark).map(organization -> request.getOrganization()).toList();
                if (list.isEmpty()) {
                    return new Response("Collection does not contain an element with the given id");
                } else {
                    LinkedList<Organization> decue = new LinkedList<>(list);
                    CollectionManager.setCollection(decue);
                    return new Response("Element with id: " + mark + " updated successfully");
                }
            } catch (NumberFormatException e) {
                return new Response("Incorrect id");
            }
        }
    }
}
