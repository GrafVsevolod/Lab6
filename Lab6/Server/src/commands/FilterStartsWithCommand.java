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

public class FilterStartsWithCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 28229348302L;
    public FilterStartsWithCommand() {
        super("filterStartsWith", true);
    }
    @Override
    public Response execute(Request request) {
        // Get the collection of organizations
        Organization[] link = CollectionManager.getCollection().toArray(new Organization[0]);

        String[] args = request.getArgs();
        // Check if the command is entered correctly
        if (args.length != 2) {
            return new Response("Incorrect command, try one more time");
        }
        // Iterate through organizations and display those whose full names start with the specified substring
        List list = Arrays.stream(link).filter(organization -> organization.getName().startsWith(args[1])).toList();

        // Display appropriate messages based on the filtering result
        if (list.isEmpty()) {
            return new Response("Collection does not contain matching elements");
        }
        return new Response("All suitable values: " + list);
    }
}
