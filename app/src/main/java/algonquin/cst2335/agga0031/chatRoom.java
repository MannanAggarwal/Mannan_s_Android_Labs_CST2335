package algonquin.cst2335.agga0031;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import algonquin.cst2335.agga0031.data.chatRoomViewModel;
import algonquin.cst2335.agga0031.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.agga0031.databinding.SentMessageBinding;

public class chatRoom extends AppCompatActivity {

    ActivityChatRoomBinding binding;

    ArrayList<String> messages = new ArrayList<>();
    private RecyclerView.Adapter myAdapter;
    chatRoomViewModel chatModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatRoomBinding.inflate( getLayoutInflater() );
        setContentView(binding.getRoot());

        chatModel = new ViewModelProvider(this).get(chatRoomViewModel.class);
        messages = chatModel.messages.getValue();
        if(messages == null) {
            chatModel.messages.postValue( messages = new ArrayList<String>());
        }

        binding.sendButton.setOnClickListener(click -> {
            messages.add(binding.textInput.getText().toString());
            myAdapter.notifyItemInserted(messages.size()-1);
            //clears the previous text
            binding.textInput.setText("");
        });

        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleView.setAdapter(myAdapter = new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                SentMessageBinding binding = SentMessageBinding.inflate(getLayoutInflater());
                return new MyRowHolder(binding.getRoot());


            }

            public int getItemViewType(int position){
                return 0;
            }


            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position){
                String obj = messages.get(position);
                holder.messageText.setText(obj);
                holder.timeText.setText("");

            }

            @Override
            public int getItemCount() {
                return messages.size();
            }
        });

    }

    class MyRowHolder extends RecyclerView.ViewHolder {

        TextView messageText;
        TextView timeText;
        public MyRowHolder(@NonNull View itemView) {
            super(itemView);

            messageText = itemView.findViewById(R.id.message);
            timeText = itemView.findViewById(R.id.time);
        }}

    }


