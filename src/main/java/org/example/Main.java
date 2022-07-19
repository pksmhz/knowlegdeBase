package org.example;

import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Initializing Jython...");

        try (InputStream in = Main.class.getClassLoader().getResourceAsStream("scripts/cmdLineTest.py")) {
            if (in != null) {
                try (PythonInterpreter pyInterp = new PythonInterpreter()) {
                    pyInterp.execfile(in);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}