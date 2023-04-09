package algonquin.cst2335.agga0031;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatMessage {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long id;

    @ColumnInfo(name="Message")
    public String message;

    @ColumnInfo(name="TimeSent")
    private String timeSent ;

    @ColumnInfo(name="SendOrReceive")
    public boolean isSentButton;



    // public MutableLiveData<ArrayList<ChatMessage>> messageList = new MutableLiveData<ArrayList<ChatMessage>>();

    public ChatMessage() {
    }

    public ChatMessage(String m, String t, boolean sent) {
        message = m;
        timeSent = t;
        isSentButton = sent;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public boolean isSentButton() {
        return isSentButton;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public void setSentButton(boolean sentButton) {
        isSentButton = sentButton;
    }}
