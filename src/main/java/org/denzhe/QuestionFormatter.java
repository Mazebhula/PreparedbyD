package org.denzhe;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionFormatter {
    String[] questions;
    public QuestionFormatter(String input) {
        this.questions = parseQuestions(input);
    }

    private String[] parseQuestions(String input) {
        List<String> questionList = new ArrayList<>();
        // Regex to match numbered questions (e.g., "1. **Job Title...**: Question text")
        Pattern pattern = Pattern.compile("\\d+\\.\\s*\\*\\*[^\\*]+\\*\\*:\\s*([^\\n]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String question = matcher.group(1).trim();
            questionList.add(question);
        }

        // Ensure exactly 10 questions are extracted; pad or truncate if necessary
        String[] result = new String[10];
        for (int i = 0; i < 10; i++) {
            result[i] = i < questionList.size() ? questionList.get(i) : "";
        }
        return result;
    }

    public String[] getQuestions() {
        return questions;
    }

    // Optional: Method to print questions for verification
    public void printQuestions() {
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
        }
    }
}
