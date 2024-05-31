package commands;

import commands.Command;
import generators.IdGenerator;
import managers.CollectionManager;
import models.Address;
import models.Coordinates;
import models.Organization;
import models.OrganizationType;
import network.Request;
import network.Response;
import network.Server;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExecuteScript extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = -1085042037559644578L;
    private static HashMap<String, Command> commandList;
    public ExecuteScript(HashMap<String, Command> commandList) {
        super("execute_script", true);
        this.commandList = commandList;
    }
    @Override
    public Response execute(Request request) {
        String path = request.getArgs()[1];
        return executeScript(path);
    }
    private Response executeScript(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
            BufferedReader r = new BufferedReader(new InputStreamReader(bf));
            while (true) {
                try {
                    String line = r.readLine().trim();
                    Server.serverLogger.info(line);
                    if (!line.isEmpty()) {
                        String[] tokens = line.split(" ");
                        Command command = commandList.get(tokens[0]);
                        if (command != null) {
                            if (tokens[0].equals("execute_script") && tokens.length > 1) {
                                String nestedScriptPath = tokens[1];
                                if (nestedScriptPath == filePath){
                                    stringBuilder.append("Recursion!" + '\n');
                                }
                                executeScript(nestedScriptPath);
                            } else if (tokens[0].equals("add")) {
                                addOrganization(tokens);
                                stringBuilder.append("Organization added" + '\n');
                            } else {
                                String[] data = {tokens[0]};
                                Request request = new Request(data);
                                stringBuilder.append(command.execute(request).getResult() + '\n');
                            }
                        } else {
                            System.out.println("Такой команды не существует: " + tokens[0]);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
            return new Response(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return new Response(stringBuilder.toString());
    }
    private void addOrganization(String[] tokens) {
        // Check if there are enough arguments to create an organization
        if (tokens.length >= 8) {
            // Extract data for creating a new organization from the script arguments
            String name = tokens[1];
            String fullName = tokens[2];
            long id = IdGenerator.generateID();
            String street = tokens[3];
            String zipCode = tokens[4];
            Address address = new Address(street, zipCode);
            Long coordinateX = Long.parseLong(tokens[5]);
            Double coordinateY = Double.parseDouble(tokens[6]);
            Coordinates coordinates = new Coordinates(coordinateX, coordinateY);
            Integer annualTurnover = Integer.parseInt(tokens[6]);
            int orgType = Integer.parseInt(tokens[7]);
            OrganizationType type = switch (orgType) {
                case 1 -> OrganizationType.COMMERCIAL;
                case 2 -> OrganizationType.GOVERNMENT;
                case 3 -> OrganizationType.TRUST;
                case 4 -> OrganizationType.PRIVATE_LIMITED_COMPANY;
                default -> throw new IllegalStateException("Unexpected value: " + orgType);
            };
            Organization organization = new Organization(id, name, coordinates, annualTurnover, fullName, type, address);
            CollectionManager.add(organization);
            System.out.printf("Организация %s добавлена в коллекцию. Размер коллекции: %d%n", organization.getName(), CollectionManager.getCollection().size());
        } else {
            System.out.println("Недостаточно аргументов для создания организации.");
        }
    }
}
