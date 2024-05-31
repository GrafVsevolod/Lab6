package generators;

import exceptions.WrongArgumentException;
import models.*;

import java.util.Scanner;

public class OrganizationInput {
    public static Organization createOrganization(int id) throws WrongArgumentException {
        System.out.println("Application is running!");

        Address postalAddress;

        Coordinates coordinates;

        String a;
        String b;

        String c;
        String d;

        Scanner scanner = new Scanner(System.in);

        Organization organization;
        if(id == 0){
            organization = new Organization();
        }
        else{
            organization = new Organization(id);
        }

        while(true){
            try{
                System.out.println("Input name: ");
                String input = scanner.nextLine();
                Validator.notNull(input, "NAME");
                organization.setName(input);
                break;
            }
            catch(WrongArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try{
                System.out.println("Coordinate X is: ");
                String input = scanner.nextLine();
                Validator.notNull(input, "X");
                a = input;
                break;
            }
            catch (WrongArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try{
                System.out.println("Coordinate Y is: ");
                String input = scanner.nextLine();
                Validator.coordinateIsGood(input, "Y");
                b = input;
                break;
            }catch(WrongArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        coordinates = new Coordinates(Long.valueOf(a),Double.valueOf(b));
        organization.setCoordinates(coordinates);


        while(true){
            try{
                System.out.println("Input turnOver: ");
                String input = scanner.nextLine();
                Validator.numIsGood(input);
                organization.setAnnualTurnover(Long.valueOf(input));
                break;
            }catch(WrongArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try{
                System.out.println("Input fullName: ");
                String input = scanner.nextLine();
                Validator.notNull(input, "fullName");
                organization.setFullName(input);
                break;
            }catch(WrongArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try{
                System.out.println("Input OrganizationType: ");
                String input = scanner.nextLine();
                Validator.typeIsGood(input);
                organization.setType(OrganizationType.valueOf(input));
                break;
            }catch(WrongArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try{
                System.out.println("Input street adress: ");
                String input = scanner.nextLine();
                Validator.notNull(input, "Street");
                c = input;
                break;
            }catch(WrongArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try{
                System.out.println("Input zipCode Adress: ");
                String input = scanner.nextLine();
                Validator.zipCodeIsGood(input);
                d = input;
                break;
            }catch(WrongArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        postalAddress = new Address(c, d);
        organization.setPostalAddress(postalAddress);

        System.out.println("An instance has been added to the collection");
        return organization;
    }
}
