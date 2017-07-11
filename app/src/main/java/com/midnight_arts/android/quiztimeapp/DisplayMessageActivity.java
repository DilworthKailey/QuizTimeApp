package com.midnight_arts.android.quiztimeapp;

import android.content.Intent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DisplayMessageActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    private static final String TAG = "DisplayMessageActivity";

    DatabaseHelper mDatabaseHelper;

    private String name;
    private String setScore;
    private String dateTime;

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        mDatabaseHelper = new DatabaseHelper(this);

        Date date = new Date();
        dateTime = sdf.format(date);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        name = message;

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Welcome, " + message + "!");

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (mQuestionNumber == mQuestionLibrary.length){
                    if (mButtonChoice1.getText() == mAnswer){
                        mQuestionNumber = 0;
                        updateQuestion();
                    }else {
                        Toast.makeText(DisplayMessageActivity.this, "Please choose Restart or Quit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (mButtonChoice1.getText() == mAnswer){
                        mScore += 1;
                        updateScore(mScore);
                        updateQuestion();
                        Toast.makeText(DisplayMessageActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(DisplayMessageActivity.this, "incorrect", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }

            }

        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (mQuestionNumber == mQuestionLibrary.length){
                    if (mButtonChoice2.getText() == mAnswer){

                    }else {
                        Toast.makeText(DisplayMessageActivity.this, "Please choose Restart or Quit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (mButtonChoice2.getText() == mAnswer) {
                        mScore += 1;
                        updateScore(mScore);
                        updateQuestion();
                        Toast.makeText(DisplayMessageActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DisplayMessageActivity.this, "incorrect", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            }

        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (mQuestionNumber == mQuestionLibrary.length){
                    if (mButtonChoice3.getText() == mAnswer){

                    }else {
                        Toast.makeText(DisplayMessageActivity.this, "Please choose Restart or Quit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (mButtonChoice3.getText() == mAnswer) {
                        mScore += 1;
                        updateScore(mScore);
                        updateQuestion();
                        Toast.makeText(DisplayMessageActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DisplayMessageActivity.this, "incorrect", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            }

        });
    }
    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        if (mQuestionNumber == 0){
            mScore = 0;
            updateScore(mScore);
        }
        mQuestionNumber ++;
        if (mQuestionNumber == mQuestionLibrary.length){
            setScore = dateTime + "\n " + name + ": " + mScore;
            AddData(setScore);
        }

    }

    private void updateScore(int point) {
        mScoreView.setText(": " + mScore);
    }

    public void quitApp(View view) {
        finish();
    }
    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    }

