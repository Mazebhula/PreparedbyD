package org.denzhe;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(new GenerateQuestions(ReadFile.readFile()));
    }
}