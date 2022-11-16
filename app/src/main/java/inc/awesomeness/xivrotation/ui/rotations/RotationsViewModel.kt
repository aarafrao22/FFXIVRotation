package inc.awesomeness.xivrotation.ui.rotations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RotationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is rotation Fragment"
    }
    val text: LiveData<String> = _text
}