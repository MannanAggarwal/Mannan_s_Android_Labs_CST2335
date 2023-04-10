package algonquin.cst2335.agga0031.data;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import algonquin.cst2335.agga0031.ChatMessage;

public class chatRoomViewModel extends ViewModel {
    //public MutableLiveData<ArrayList<String>> messages = new MutableLiveData< >();
    public MutableLiveData<ArrayList<ChatMessage>> messages = new MutableLiveData<>();
    public MutableLiveData<ChatMessage> selectedMessage = new MutableLiveData< >();
}
