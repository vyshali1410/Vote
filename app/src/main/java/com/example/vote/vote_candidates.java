package com.example.vote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class vote_candidates extends AppCompatActivity {
    TextView cand1 ;
    TextView cand2 ;
    TextView cand3 ;
    String vote1_choice;
    String vote2_choice;
    String vote3_choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_candidates);
        cand1 = findViewById(R.id.candidate_1);
        cand2 = findViewById(R.id.candidate_2);
        cand3 = findViewById(R.id.candidate_3);

        Bundle bundle=getIntent().getExtras();
        vote1_choice = bundle.getString("votes1");
        vote2_choice = bundle.getString("votes2");
        vote3_choice = bundle.getString("votes3");

        cand1.setText(vote1_choice);
        cand2.setText(vote2_choice);
        cand3.setText(vote3_choice);
    }



    }
