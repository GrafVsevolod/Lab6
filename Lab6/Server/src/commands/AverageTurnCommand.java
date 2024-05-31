package commands;

import managers.CollectionManager;
import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;

public class AverageTurnCommand extends Command implements Serializable {
    private double averageTurnCount;
    @Serial
    private final static long serialVersionUID = 2822928L;
    public AverageTurnCommand() {
        super("averageTurn", false);
    }

    @Override
    public Response execute(Request request) {
            CollectionManager.getCollection()
                    .stream()
                    .forEach(x -> {
                averageTurnCount += x.getAnnualTurnover();
            });
            return new Response(String.valueOf(averageTurnCount));
        }
    }
