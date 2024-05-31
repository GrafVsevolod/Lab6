package commands;

import network.Request;
import network.Response;

import java.io.Serial;
import java.io.Serializable;

public class HelpCommand extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = -2198189148456433700L;

    public HelpCommand() {
        super("help", false);
    }

    @Override
    public Response execute(Request request) {
        return new Response("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "help - вывести справку по доступным командам\n" +
                "info - вывести информацию о коллекции\n" +
                "show - вывести все элементы коллекции в строковом представлении\n" +
                "add - добавить новый элемент в коллекцию\n" +
                "update id {element} - обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove id - удалить элемент из коллекции по его id\n" +
                "clear - очистить коллекцию\n" +
                "save - сохранить коллекцию в файл\n" +
                "execute_script file_name - считать и исполнить скрипт из указанного файла\n" +
                "exit - завершить программу\n" +
                "removeFirst - удалить первый элемент из коллекции\n" +
                "removeHead : вывести первый элемент коллекции и удалить его\n" +
                "addMin {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "averageTurn : вывести среднее значение поля annualTurnover для всех элементов коллекции\n" +
                "maxById : вывести любой объект из коллекции, значение поля id которого является максимальным\n");
    }
}
