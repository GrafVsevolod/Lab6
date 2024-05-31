package commands;

import managers.CollectionManager;
import models.Organization;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class AddIfMinCommand extends Command implements Serializable {
    @Serial
    private final static long serialVersionUID = 2822920L;

    public AddIfMinCommand() {
        super("addIfMin", true);
    }

    @Override
    public Response execute(Request request) {
        List<Organization> ourList = CollectionManager.getCollection().stream().toList();
        Organization minElem = ourList.stream().min(Organization::compareTo).get();

        Organization org = request.getOrganization();
        if (org.getAnnualTurnover() - minElem.getAnnualTurnover() < 0) {
            ourList.add(org);
            return new Response("The organization has been successfully added to the collection");
        }
        return new Response("The value of the annual turnover of the organization is not the maximum for the collection");
    }
}
