package com.example.android.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String Q_4_RIGHT_ANSWER;
    Double QUESTION_COUNT = 6.0;
    boolean answer_q_1, answer_q_2, answer_q_3, answer_q_4, answer_q_5, answer_q_6;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submit(View view) {
        boolean[] allAnswers = new boolean[6];
        q_1_answer(view);
        q_2_answer(view);
        q_3_answer(view);
        q_4_answer(view);
        q_5_answer(view);
        q_6_answer(view);
        int countTrue = 0;
        allAnswers[0] = answer_q_1;
        allAnswers[1] = answer_q_2;
        allAnswers[2] = answer_q_3;
        allAnswers[3] = answer_q_4;
        allAnswers[4] = answer_q_5;
        allAnswers[5] = answer_q_6;
        System.out.println(Arrays.toString(allAnswers));
        for (boolean oneAnswer : allAnswers){
            if (oneAnswer) countTrue++;
        }
        showResult(countTrue);
    }

    /**
     * Shows a pop-up message with a score
     */
    private void showResult(int countTrue) {
        StringBuilder result = new StringBuilder("Your score is ");
        result.append(countTrue/QUESTION_COUNT * 100);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }


    private void q_1_answer(View view) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_1_rg);
        int selectedId = rg.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        answer_q_1 = radioButton.getId() == R.id.radiobutton_q_1_answer_3;
        System.out.println(answer_q_1);
    }

    private void q_2_answer(View view) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_2_rg);
        int selectedId = rg.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        answer_q_2 = radioButton.getId() == R.id.radiobutton_q_2_answer_2;
    }

    private void q_3_answer(View view) {
        CheckBox q_3_checkbox_1 = (CheckBox) findViewById(R.id.checkbox_q_3_answer_1);
        CheckBox q_3_checkbox_2 = (CheckBox) findViewById(R.id.checkbox_q_3_answer_2);
        CheckBox q_3_checkbox_4 = (CheckBox) findViewById(R.id.checkbox_q_3_answer_4);
        answer_q_3 = q_3_checkbox_1.isChecked() && q_3_checkbox_2.isChecked() && q_3_checkbox_4.isChecked();
    }

    private void q_4_answer(View view) {
        EditText q_4_answer = (EditText) findViewById(R.id.edit_text_q4);
        String q_4_text = q_4_answer.getText().toString().trim().toLowerCase();
        answer_q_4 = q_4_text.equals(Q_4_RIGHT_ANSWER);
    }

    private void q_5_answer(View view) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_5_rg);
        int selectedId = rg.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        answer_q_5 = radioButton.getId() == R.id.radiobutton_q_5_answer_3;
    }

    private void q_6_answer(View view) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_6_rg);
        int selectedId = rg.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        answer_q_6 = radioButton.getId() == R.id.radiobutton_q_6_answer_3;
    }

}