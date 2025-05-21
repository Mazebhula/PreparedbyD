package org.denzhe;

public class GenerateQuestions {
    public GenerateQuestions(String jobAsString){
        StringBuilder query = new StringBuilder();
        query.append("give me 10 questions for this post,").append(jobAsString)
                .append(" i am creating a website, write the questions inside a list and separate them with commas");

        String questions = new Caller(query.toString()).getGeneratedText().split("</think>")[1].strip();
        System.out.println(questions);

    }
}
