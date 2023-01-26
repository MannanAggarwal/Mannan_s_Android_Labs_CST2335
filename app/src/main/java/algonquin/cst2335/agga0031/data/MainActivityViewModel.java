package algonquin.cst2335.agga0031.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel{

    public MutableLiveData<String> editTextContents = new MutableLiveData<>();
    public MutableLiveData<Boolean> isSelected = new MutableLiveData<>();
    public MutableLiveData<String> iButton = new MutableLiveData<>();
}
