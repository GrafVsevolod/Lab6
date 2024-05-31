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

public class ShowCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 24720173148202L;
    public ShowCommand() {
        super("show", false);
    }

    @Override
    public Response execute(Request request) {
        LinkedList<Organization> list = CollectionManager.getCollection();

        if (list.isEmpty()) {
            return new Response("Collection is empty");
        }
        Organization[] org = list.toArray(new Organization[0]);
        Arrays.sort(org);
        List<Organization> Finallist = Arrays.stream(org).sorted().toList();
        return new Response("All values: " + Finallist);
    }
}
