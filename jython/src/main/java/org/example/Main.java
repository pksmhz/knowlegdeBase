package org.example;

import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Using Java cmd line arguments:");
        for (String s: args) {
            System.out.println(s);
        }

        System.out.println("\nInitializing Jython...");

        try (InputStream in = Main.class.getClassLoader().getResourceAsStream("scripts/jsonFormatter.py")) {
            if (in != null) {
                try (PythonInterpreter pyInterp = new PythonInterpreter()) {
                    pyInterp.set("arg1", new PyString(args[0]));
                    pyInterp.set("arg2", new PyString(args[1]));
                    pyInterp.exec(
                            "import sys\n"
                                    +"sys.argv = ['', arg1, arg2]");
                    pyInterp.execfile(in);
                    System.out.println("\nDone!\n");
                    System.out.println("Changes saved to file: " + args[1]);

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}