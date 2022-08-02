package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultLabel = findViewById(R.id.resultLabel);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences prefs = getSharedPreferences("quizApp", MODE_PRIVATE);
        int totalScore = prefs.getInt("totalScore", 0);

        totalScore += score;

        resultLabel.setText(getString(R.string.result_score, score));
        totalScoreLabel.setText(getString(R.string.result_total_score, totalScore));

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("totalScore", totalScore);
        editor.apply();


    }

    public void returnTop(View view) {
        startActivity(new Intent(ResultActivity.this, MainActivity.class));
    }}