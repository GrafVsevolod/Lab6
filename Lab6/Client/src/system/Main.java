package system;

import exceptions.WrongArgumentException;
import network.Program;

public class Main {
    public static void main(String[] args) throws InterruptedException, WrongArgumentException {
        Program program = new Program();
        program.execute();
    }
}

