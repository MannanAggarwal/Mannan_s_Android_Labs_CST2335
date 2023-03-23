package algonquin.cst2335.agga0031;

import  androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button callButton = findViewById(R.id.call);
        TextView topText = findViewById(R.id.topText);
        Button picture = findViewById(R.id.picture);
        ImageView profilePicture = findViewById(R.id.profilePicture);
        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");

        topText.setText("Welcome back " + emailAddress);

        File file = new File( getFilesDir() , "Picture.png");

        if(file.exists())
        {
            Bitmap theImage = BitmapFactory.decodeFile(file.getAbsolutePath());
            profilePicture.setImageBitmap(theImage);
        }



        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText number = findViewById(R.id.editTextPhone2);
                String phoneNumber = number.getText().toString();
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(call);
            }
        });


        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraResult.launch(cameraIntent);
            }


            ActivityResultLauncher <Intent> cameraResult = registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK) {
                                Intent data = result.getData();
                                Bitmap thumbnail = data.getParcelableExtra("data");
                                profilePicture.setImageBitmap(thumbnail);
                            }
                        }
                    });
        });

        EditText editTextPhone = findViewById(R.id.editTextPhone2);
        SharedPreferences prefs = getSharedPreferences("MyPhoneData", Context.MODE_PRIVATE);
        String phoneNumber = prefs.getString("PhoneNumber", "");
        editTextPhone.setText(phoneNumber);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EditText phoneNumber = (EditText) findViewById(R.id.editTextPhone2);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPhoneData", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString("PhoneNumber" , phoneNumber.getText().toString());
        ed.apply();
    }

}