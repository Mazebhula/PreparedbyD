package org.denzhe;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(Arrays.toString(new QuestionFormatter(new GenerateQuestions(ReadFile.readFile()).getQuestions()).getQuestions()));
    }
}