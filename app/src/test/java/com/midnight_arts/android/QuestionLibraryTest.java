package com.midnight_arts.android.quiztimeapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kailey on 7/11/2017.
 *
 */
public class QuestionLibraryTest {
    @Test
    public void getQuestion() throws Exception {

        System.out.print("getQuestion Test Case #1 - ");
        int input = 0;
        String output;
        String expected = "Which shape has no sides?";

        QuestionLibrary questionLibrary = new QuestionLibrary();
        output = questionLibrary.getQuestion(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");

        System.out.print("getQuestion Test Case #2 - ");
        input = 4;
        expected = "What are the three primary colors?";

        output = questionLibrary.getQuestion(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");
    }

    @Test
    public void getChoice1() throws Exception {

        System.out.print("getChoice1 Test Case #1 - ");
        int input = 0;
        String output;
        String expected = "Square";

        QuestionLibrary questionLibrary = new QuestionLibrary();
        output = questionLibrary.getChoice1(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");

        System.out.print("getChoice1 Test Case #2 - ");
        input = 6;
        expected = "Restart";

        output = questionLibrary.getChoice1(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");
    }

    @Test
    public void getChoice2() throws Exception {
        System.out.print("getChoice2 Test Case #1 - ");
        int input = 2;
        String output;
        String expected = "Delorium";

        QuestionLibrary questionLibrary = new QuestionLibrary();
        output = questionLibrary.getChoice2(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");

        System.out.print("getChoice2 Test Case #2 - ");
        input = 4;
        expected = "Purple, Orange, Green";

        output = questionLibrary.getChoice2(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");
    }

    @Test
    public void getChoice3() throws Exception {
        System.out.print("getChoice3 Test Case #1 - ");
        int input = 1;
        String output;
        String expected = "#000000";

        QuestionLibrary questionLibrary = new QuestionLibrary();
        output = questionLibrary.getChoice3(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");

        System.out.print("getChoice3 Test Case #2 - ");
        input = 3;
        expected = "5";

        output = questionLibrary.getChoice3(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");
    }

    @Test
    public void getCorrectAnswer() throws Exception {
        System.out.print("getCorrectAnswer Test Case #1 - ");
        int input = 0;
        String output;
        String expected = "Circle";

        QuestionLibrary questionLibrary = new QuestionLibrary();
        output = questionLibrary.getCorrectAnswer(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");

        System.out.print("getCorrectAnswer Test Case #2 - ");
        input = 1;
        expected = "#ffffff";

        output = questionLibrary.getCorrectAnswer(input);

        assertEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");
    }

    @Test
    public void returnArrayTest() throws Exception {
        System.out.print("returnArrayTest Test Case #1 - ");
        int input = 0;
        String[] output;
        String[] expected = {"Square", "Circle", "Triangle"};

        QuestionLibrary questionLibrary = new QuestionLibrary();
        output = questionLibrary.returnArrayTest(input);

        assertArrayEquals(expected, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");

        System.out.print("returnArrayTest Test Case #2 - ");
        input = 4;
        String[] expected2 = {"Red, Yellow, Blue", "Purple, Orange, Green", "Magenta, Aquamarine, Yellow"};

        output = questionLibrary.returnArrayTest(input);

        assertArrayEquals(expected2, output);
        System.out.print("expected: " + expected + " output: " + output + "\n");
    }

}