package org.denzhe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static String readFile() throws FileNotFoundException{
    return new File("src/main/java/org/denzhe/jobpost.txt").toString();
    }
}


