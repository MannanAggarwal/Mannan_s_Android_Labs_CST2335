package algonquin.cst2335.agga0031;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        binding.textview.setText(viewModel.editTextContents);

        setContentView(binding.getRoot()); //this load stuff on the screen.
        /*
        TextView mytext = findViewById(R.id.textview);
        Button btn = findViewById(R.id.mybutton);
        EditText myedit = findViewById(R.id.edittext);
        String editString = myedit.getText().toString();
        */

       // mytext.setText( "Your edit text has: " + editString);

        binding.mybutton.setOnClickListener( v -> {
            viewModel.editTextContents = ("Your String has: "+ binding.edittext.getText().toString());

            binding.textview.setText(viewModel.editTextContents);

        });
    }
}