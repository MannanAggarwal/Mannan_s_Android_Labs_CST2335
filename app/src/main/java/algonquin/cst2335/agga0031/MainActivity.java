package algonquin.cst2335.agga0031;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import algonquin.cst2335.agga0031.SecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginbutton=findViewById(R.id.button);
        EditText email = findViewById(R.id.password);
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String savedData = prefs.getString("VariableName", "");
        String emailAddress = prefs.getString("LoginName", "");
        email.setText(emailAddress);
        loginbutton.setOnClickListener( clk-> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("LoginName", email.getText().toString());
            editor.apply();
            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
            nextPage.putExtra("EmailAddress", email.getText().toString());
            startActivity(nextPage);
        });
        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );
        if(savedData.isEmpty()){
            Log.d("MyData", "no data");
        }
        else
            Log.d("MyData", "Data" + savedData);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("MainActivity", "In onResume()- The application is now responding to user input");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("MainActivity", "In onDestroy()- Any memory used by application is freed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("MainActivity", "In onStop()- The application is no longer visible.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("MainActivity", "In onStart()- The application is now visible on screen.");
    }
}