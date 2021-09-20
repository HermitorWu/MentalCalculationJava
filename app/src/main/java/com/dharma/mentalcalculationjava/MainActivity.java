package com.dharma.mentalcalculationjava;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int numberOfQuestions;
    int serialNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerNumberOfQuestions = (Spinner) findViewById(R.id.idSpinnerNumberOfQuestions);
        Spinner spinnerCapacity = (Spinner) findViewById(R.id.idSpinnerCapacity);
        Spinner spinnerHowManyDigits = (Spinner) findViewById(R.id.idSpinnerHowManyDigits);

        // 題數。
        ArrayAdapter<CharSequence> adapterNumberOfQuestions =
                ArrayAdapter.createFromResource(this,
                        R.array.arrayNumberOfQuestions,
                        android.R.layout.simple_spinner_item);

        // 幾個數字相加。
        ArrayAdapter<CharSequence> adapterCapacity =
                ArrayAdapter.createFromResource(this,
                        R.array.arrayCapacity,
                        android.R.layout.simple_spinner_item);

        // 使用幾位數。
        ArrayAdapter<CharSequence> adapterHowManyDigits =
                ArrayAdapter.createFromResource(this,
                        R.array.arrayHowManyDigits,
                        android.R.layout.simple_spinner_item);

        // 題數。
        adapterNumberOfQuestions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumberOfQuestions.setAdapter(adapterNumberOfQuestions);
        spinnerNumberOfQuestions.setSelection(2, false);
        spinnerNumberOfQuestions.setOnItemSelectedListener(spnOnItemSelectedNumberOfQuestions);

        TextView textNumberOfQuestions = (TextView) findViewById(R.id.idHello);
        textNumberOfQuestions.setText("選項:" + spinnerNumberOfQuestions.getSelectedItem().toString());

        // 幾個數字相加。
        adapterCapacity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCapacity.setAdapter(adapterCapacity);
        spinnerCapacity.setSelection(2, false);
        spinnerCapacity.setOnItemSelectedListener(spnOnItemSelectedCapacity);

        textNumberOfQuestions = (TextView) findViewById(R.id.idHello);
        textNumberOfQuestions.setText("選項:" + spinnerCapacity.getSelectedItem().toString());

        // 使用幾位數。
        adapterHowManyDigits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHowManyDigits.setAdapter(adapterHowManyDigits);
        spinnerHowManyDigits.setSelection(2, false);
        spinnerHowManyDigits.setOnItemSelectedListener(spnOnItemSelectedHowManyDigits);

        textNumberOfQuestions = (TextView) findViewById(R.id.idHello);
        textNumberOfQuestions.setText("選項:" + spinnerHowManyDigits.getSelectedItem().toString());

        // 下面試題目和答案的顯示區。


        Boolean initial = true;
        final Boolean[] nowIsQuestion = {true};
        Boolean nowIsAns = true;

        int[] num = new int[2];

        Random random = new Random();

        num[0] = random.nextInt(10);
        num[1] = random.nextInt(10);

        TextView textViewQuestionAns = (TextView) findViewById(R.id.idTextViewQuestionAns);

        Button buttonAnsNext = (Button) findViewById(R.id.idButtonAnsNext);

        // 按下按鈕，會切換出題目和看答案。
        buttonAnsNext.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nowIsQuestion[0]) {
                    textViewQuestionAns.setText("第" + serialNumber + "題： " + Integer.toString((num[0])) + " + " + Integer.toString(num[1]) + " = ? ");

                    buttonAnsNext.setText("看答案");

                    nowIsQuestion[0] = false;
                } else {
                    textViewQuestionAns.setText("第" + serialNumber + "題： " + Integer.toString((num[0])) + "+" + Integer.toString(num[1]) + "=" + Integer.toString(num[0] + num[1]));

                    buttonAnsNext.setText("下一題");

                    nowIsQuestion[0] = true;

                    num[0] = random.nextInt(10);
                    num[1] = random.nextInt(10);

                    serialNumber++;
                }
            }
        });
    }

    // 下面在onCreate括號外面。

    // 題數。
    private final AdapterView.OnItemSelectedListener spnOnItemSelectedNumberOfQuestions
            = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            String sPos = String.valueOf(pos);
            String sInfo = parent.getItemAtPosition(pos).toString();
            //String sInfo=parent.getSelectedItem().toString();
//            textNumberOfQuestions.setText("選項" + sPos + ":" + sInfo);

            numberOfQuestions = pos * 10;
        }

        public void onNothingSelected(AdapterView<?> parent) {
            //
        }
    };

    // 幾個數字相加。
    private final AdapterView.OnItemSelectedListener spnOnItemSelectedCapacity
            = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            String sPos = String.valueOf(pos);
            String sInfo = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView<?> parent) {
            //
        }
    };

    // 使用幾位數。
    private final AdapterView.OnItemSelectedListener spnOnItemSelectedHowManyDigits
            = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            String sPos = String.valueOf(pos);
            String sInfo = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView<?> parent) {
            //
        }
    };
}