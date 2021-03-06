package com.example.vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    TextView tv;
    EditText textname,textid;
    Button vote;
    int choose = 0;
    int[] votes = {0,1,2,3} ;
    int votes1;
    int votes2;
    int votes3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textname = (EditText) findViewById(R.id.text_name);
        textid = (EditText) findViewById(R.id.text_id);
        vote = findViewById(R.id.vote_button);
        tb = findViewById(R.id.toggleButton);
        tv = findViewById(R.id.textView5);
        String[] candidates = {"choose candidate", "candidate1", "candidate2", "candidate3"};


        //Dropdown
        Spinner mySpinner = findViewById(R.id.cand_num);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, candidates);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String s1 = String.valueOf(candidates[position]);
                if (position == 0) {
                    return;
                } else if (position == 1) {
                    votes1 = votes1 + 1;
                } else if (position == 2) {
                    votes2 = votes2 + 1;
                } else {
                    votes3 = votes3 + 1;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //toggle
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (tb.isChecked()) {
                    tv.setText("I do not Accept terms and regulations");
                } else {
                    tv.setText("I do Accept terms and regulations");
                }
            }
        });

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkdata();
                Intent i = new Intent(MainActivity.this, vote_candidates.class);
                Bundle bundle = new Bundle();
                bundle.putInt("votes1", votes1);
                bundle.putInt("votes2", votes2);
                bundle.putInt("votes3", votes3);
                i.putExtras(bundle);
                startActivity(i);

            }

            boolean isName(EditText text) {
                CharSequence textname = text.getText().toString();
                return (!TextUtils.isEmpty(textname));
            }

            boolean isEmpty(EditText text) {
                CharSequence str = text.getText().toString();
                return TextUtils.isEmpty(str);
            }

            private void checkdata() {
                if (isEmpty(textname)) {
                    textname.setError("Please enter name");
                }

                if (isEmpty(textid)) {
                    textid.setError("Please enter ID ");
                }
            }


        });

    }

}