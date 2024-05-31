package managers;

import commands.*;
import network.Request;
import network.Response;

import java.util.HashMap;

public class CommandManager {
    private static HashMap<String, Command> commandList;

    public CommandManager(){
        commandList = new HashMap<>();
        commandList.put("help", new HelpCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("add", new AddCommand());
        commandList.put("update", new UpdateCommand());
        commandList.put("remove", new RemoveCommand());
        commandList.put("clear", new ClearCommand());
        commandList.put("removeFirst", new RemoveFirstCommand());
        commandList.put("removeHead", new RemoveHeadCommand());
        commandList.put("addMin", new AddIfMinCommand());
        commandList.put("averageTurn", new AverageTurnCommand());
        commandList.put("MaxById", new MaxByIdCommand());
        commandList.put("filterStarts", new FilterStartsWithCommand());
    }

    public static Response startExecuting(Request request)  throws Exception{
        Command command = commandList.get(request.getArgs()[0]);
        if(command == null){
            return new Response("No command with this name");
        }
        else{
            if (command.isHasArguments() && request.getArgs().length < 2){
                return new Response("No arguments for command: " + command.getName());
            }
            return command.execute(request);
        }
    }

    public static HashMap<String, Command> getCommandList(){
        return commandList;
    }
}
