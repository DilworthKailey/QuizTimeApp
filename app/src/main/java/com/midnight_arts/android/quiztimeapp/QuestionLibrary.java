package com.midnight_arts.android.quiztimeapp;

/**
 * Created by Kailey on 7/1/2017.
 */

public class QuestionLibrary {

    private String temp = Weather.temper;

    private String mQuestions [] = {

            "Which shape has no sides?",
            "What is the hex color code for White?",
            "Which is a real protein?",
            "How many Queen Elizabeths of England have there been?",
            "What are the three primary colors?",
            "What is the current temperature in Richfield, Utah?",
            "Congratulations! You finished with a highscore! Restart Quiz, or Quit?"

    };

    private String mChoices [] [] = {
            {"Square", "Circle", "Triangle"},
            {"#ffffff", "#123456", "#000000"},
            {"Metroidium", "Delorium", "Pikachurin"},
            {"1", "2", "5"},
            {"Red, Yellow, Blue", "Purple, Orange, Green", "Magenta, Aquamarine, Yellow"},
            {"-100.0", "200.0", temp},
            {"Restart", "", ""}
    };

    private String mCorrectAnswers [] = {"Circle", "#ffffff", "Pikachurin", "2", "Red, Yellow, Blue", temp, "Restart"};

    public int length = mQuestions.length;

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a] [0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a] [1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a] [2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
    public String[] returnArrayTest(int a) {
        String[] answer = mChoices[a];
        return answer;
    }
}
