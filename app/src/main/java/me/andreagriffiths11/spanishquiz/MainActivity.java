package me.andreagriffiths11.spanishquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String finalMessage = " ";
    int correctAnswersNumber = 0;
    String isQuestion1Correct = " ";
    String isQuestion2Correct = " ";
    String isQuestion3Correct = " ";
    String isQuestion4Correct = " ";
    String isQuestion5Correct = " ";
    String correct = "Correcto!";
    String incorrect = "Incorrecto!";
    String noAnswer = "Sin respuesta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {

        /**
         *  Verification of first question, will determine if answer is correct/incorrect, or is there no answer.
         */

        RadioButton radioButton11 = (RadioButton) findViewById(R.id.a11);
        RadioButton radioButton12 = (RadioButton) findViewById(R.id.a12);
        RadioButton radioButton13 = (RadioButton) findViewById(R.id.a13);
        if (radioButton12.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion1Correct = correct;
        } else if (radioButton11.isChecked() || radioButton13.isChecked()) {
            isQuestion1Correct = incorrect;
        } else {
            isQuestion1Correct = noAnswer;
        }

        /**
         *  Verification of second question, will determine if answer is correct/incorrect, or is there no answer.
         */

        RadioButton radioButton21 = (RadioButton) findViewById(R.id.a21);
        RadioButton radioButton22 = (RadioButton) findViewById(R.id.a22);
        RadioButton radioButton23 = (RadioButton) findViewById(R.id.a23);
        if (radioButton22.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion2Correct = correct;
        } else if (radioButton21.isChecked() || radioButton23.isChecked()) {
            isQuestion2Correct = incorrect;
        } else {
            isQuestion2Correct = noAnswer;
        }

        /**
         *  Verification of third question, will determine if answer is correct/incorrect, or is there no answer.
         */

        RadioButton radioButton31 = (RadioButton) findViewById(R.id.a31);
        RadioButton radioButton32 = (RadioButton) findViewById(R.id.a32);
        RadioButton radioButton33 = (RadioButton) findViewById(R.id.a33);
        if (radioButton32.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion3Correct = correct;
        } else if (radioButton31.isChecked() || radioButton33.isChecked()) {
            isQuestion3Correct = incorrect;
        } else {
            isQuestion3Correct = noAnswer;
        }

        /**
         *  Verification of fourth question, will determine all applicable correct answers or is there are no answer.
         *  there are two correct answers R.id.41 and 43, I realized I needed to add one more correct answer :)
         */
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.a41);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.a42);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.a43);

        if (checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion4Correct = correct;
        } else if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) {
            isQuestion4Correct = noAnswer;
        } else {
            isQuestion4Correct = incorrect;
        }

        /**
         *  Verification of fifth question, will determine if answer is correct/incorrect, or is there no answer.
         */

        EditText editText = (EditText) findViewById(R.id.editText1);
        if (editText.getText().toString().equals("Feliz")) {
            correctAnswersNumber += 1;
            isQuestion5Correct = correct;
        } else if (editText.getText().toString().isEmpty()) {
            isQuestion5Correct = noAnswer;
        } else {
            isQuestion5Correct = incorrect;
        }

        setMessage();
        displayMessage();
        reset();
    }

    /**
     * This method set the final message evaluation grade result
     */

    public void setMessage() {
        finalMessage += "Correct answers: " + correctAnswersNumber + "/5";
        if (correctAnswersNumber == 0) {
            finalMessage += "\nF";
        } else if (correctAnswersNumber == 1) {
          finalMessage += "\nYour grade is: D";
        } else if (correctAnswersNumber == 2) {
          finalMessage += "\nYour grade is: C";
        } else if (correctAnswersNumber == 3) {
            finalMessage += "\nYour grade is: C Plus";
        } else if (correctAnswersNumber == 4) {
            finalMessage += "\nYour grade is: B";
        } else if (correctAnswersNumber == 5) {
            finalMessage += "\nFelicidades tu grado es: A Experto";
        }
        finalMessage += "\n\nYour answers:";
        finalMessage += "\n1)" + isQuestion1Correct;
        finalMessage += "\n2)" + isQuestion2Correct;
        finalMessage += "\n3)" + isQuestion3Correct;
        finalMessage += "\n4)" + isQuestion4Correct;
        finalMessage += "\n5)" + isQuestion5Correct;
        finalMessage += "\n\nGracias por tu participacion";
    }

    /**
     * Displays the number of correct answers on the screen in a toast message.
     */

    public void displayMessage() {
        Toast.makeText(this, finalMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * Value reset
     */

    public void reset() {
        finalMessage = " ";
        correctAnswersNumber = 0;
        isQuestion1Correct = " ";
        isQuestion2Correct = " ";
        isQuestion3Correct = " ";
        isQuestion4Correct = " ";
        isQuestion5Correct = " ";
    }

}
