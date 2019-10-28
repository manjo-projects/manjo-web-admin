package org.papaja.adminfly.module.psy.tests.mmpi2.answer;


import java.util.Map;
import java.util.TreeMap;

public class Answers {

    private Map<Integer, Answer> answers = new TreeMap<>();

    public void add(Answer answer, Integer... questions) {
        for (Integer question : questions) {
            answers.put(question, answer);
        }
    }

    public Answer getAnswer(Integer question) {
        return answers.get(question);
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public boolean isCorrect(Integer question, Answer answer) {
        return getAnswer(question).equals(answer);
    }

}
