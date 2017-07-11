package com.midnight_arts.android.quiztimeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static TextView place;
    static TextView temp;

    public static final String EXTRA_MESSAGE = "com.example.quiztimeapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        place = (TextView)findViewById(R.id.place);
        temp = (TextView)findViewById(R.id.temp);

        Weather getData = new Weather();
        getData.execute("http://api.openweathermap.org/data/2.5/weather?lat=38.772467&lon=-112.084094&appid=d506bc3df492b5dc232a0c0a9748bf12");


        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("Here is the weather for the current set coordinates:");

    }

    public void sendMessage(View view) {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        if (message.length() != 0){
            startActivity(intent);
        } else {
            toastMessage("The text field cannot be left empty.");
        }

    }

    public void viewScores(View view) {

        Intent intent = new Intent(this, HighScoresActivity.class);
        startActivity(intent);

    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
