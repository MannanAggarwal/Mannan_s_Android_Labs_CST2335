package algonquin.cst2335.agga0031;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.agga0031.data.MainActivityViewModel;
import algonquin.cst2335.agga0031.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        binding = ActivityMainBinding.inflate( getLayoutInflater() ); //this will the layout.

        //binding.textview.setText(viewModel.editTextContents);

        setContentView(binding.getRoot()); //this load stuff on the screen.
        /*
        TextView mytext = findViewById(R.id.textview);
        Button btn = findViewById(R.id.mybutton);
        EditText myedit = findViewById(R.id.edittext);
        String editString = myedit.getText().toString();
        */

       // mytext.setText( "Your edit text has: " + editString);

        binding.mybutton.setOnClickListener( v -> {
            viewModel.editTextContents.postValue(binding.edittext.getText().toString());

            //viewModel.editTextContents = ("Your String has: "+ binding.edittext.getText().toString());

            //binding.textview.setText(viewModel.editTextContents);

        });

        viewModel.editTextContents.observe(this, s -> {
            binding.textview.setText("Your String has: "+ binding.edittext.getText().toString());
        });


        viewModel.isSelected.observe( this , selected->{
            binding.checkBox.setChecked(selected);
            binding.radioButton.setChecked(selected);
            binding.switch1.setChecked(selected);
            Context context = getApplicationContext();
            CharSequence text = "The value is now: " + binding.checkBox.isChecked();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        });

        binding.checkBox.setOnCheckedChangeListener((checkBox , isChecked) -> {
            viewModel.isSelected.postValue(isChecked);
        });

        binding.radioButton.setOnCheckedChangeListener((radioButton , isChecked) -> {
            viewModel.isSelected.postValue(isChecked);
        });

        binding.switch1.setOnCheckedChangeListener((switch1 , isChecked) -> {
            viewModel.isSelected.postValue(isChecked);
        });


        binding.imageButton.setOnClickListener(click -> {
            viewModel.iButton.postValue(binding.imageButton.getHeight() + "*" + binding.imageButton.getWidth());
        });

        viewModel.iButton.observe(this, c -> {
            Context context = getApplicationContext();
            CharSequence text = "The value is now: " + binding.imageButton.getHeight() + "*" + binding.imageButton.getWidth();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        });
    }
}