package org.denzhe;

import java.util.Arrays;

public class GenerateQuestions {
    String questions;
    public GenerateQuestions(String jobAsString){
        StringBuilder query = new StringBuilder();
        query.append("give me 10 possible interview questions for this post,").append(jobAsString);


        questions = new Caller(query.toString()).getGeneratedText().strip();

    }
    public String getQuestions(){
        return questions;
    }
}
