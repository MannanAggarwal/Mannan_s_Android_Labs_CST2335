package algonquin.cst2335.agga0031;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/** This class contains onCreate and checkPasswordComplexity
 * functions to further display toast message.
 * @author Mannan Aggarwal
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This is to store the TextView details in tv object.
     */
    TextView tv = null;
    /**
     * This is to store the EditText text in et object.
     */
    EditText et = null;
    /**
     * This is to store the Button information in btn object.
     */
    Button btn = null;


    /**
     * This function holds the onClickListener which
     * further calls the checkPasswordComplexity function to
     * display the toast message.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * This is to store the TextView details in tv object.
         */
        TextView tv = findViewById(R.id.textView);
        /**
         * This is to store the EditText text in et object.
         */
        EditText et = findViewById(R.id.editText);
        /**
         * This is to store the Button information in btn object.
         */
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener( clk ->{
            String password = et.getText().toString();

            checkPasswordComplexity( password );
        });
    }

    /** This function will check the fulfilled requirements of the password.
     *
     * @param pw The string object that we are checking.
     * @return True/False based on the result of the conditions check.
     */
    boolean checkPasswordComplexity(String pw){

        tv = findViewById(R.id.textView);
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;

        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if(isSpecialCharacter(c)){
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            tv.setText("You shall not pass!");
            Toast.makeText(getApplicationContext(), "Upper case letter is missing", Toast.LENGTH_SHORT).show();// Say that they are missing an upper case letter;
            return false;
        } else if (!foundLowerCase) {
            tv.setText("You shall not pass!");
            Toast.makeText(getApplicationContext(), "Lower case letter is missing", Toast.LENGTH_SHORT).show(); // Say that they are missing a lower case letter;
            return false;
        } else if (!foundNumber) {
            tv.setText("You shall not pass!");
            Toast.makeText(getApplicationContext(), "Number is missing", Toast.LENGTH_SHORT).show(); // Say that they are missing a number;
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(getApplicationContext(), "Special character is missing", Toast.LENGTH_SHORT).show(); // Say that they are missing a character;
            tv.setText("You shall not pass!");
            return false;
        } else
            tv.setText("Your password meets the requirements.");
        return true; //only get here if they're all true

    }

    /**
     * This function is called within the checkPasswordComplexity function
     * to check the presence of a special character in the password.
     * @param c The character at the i'th iteration of the loop,
     * @return True/False based on the result of the conditions check.
     */
    boolean isSpecialCharacter(char c){
        switch (c) {
            case '#':
            case '?':
            case '*':
                return true;
            default:
                return false;
        }
    }

}