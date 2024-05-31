package commands;

import managers.CollectionManager;
import models.Organization;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public class InfoCommand extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = -2198189148456433800L;
    public InfoCommand() {
        super("info", false);
    }

    @Override
    public Response execute(Request request) {
        LinkedList<Organization> collection = CollectionManager.getCollection();
        LocalDate date = CollectionManager.InitDate();
        return new Response(" Тип коллекции: "+ collection.getClass() + " Дата инициализации: "+ date + " Количество элементов: " + collection.size());
    }
}
