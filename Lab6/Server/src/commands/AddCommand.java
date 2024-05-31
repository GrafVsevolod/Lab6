package commands;

import managers.CollectionManager;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;

public class AddCommand extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = -2198189148456433600L;
    public AddCommand() {
        super("add", false);
    }
    @Override
    public Response execute(Request request){
        return CollectionManager.add(request.getOrganization());
    }
}
