package inc.awesomeness.xivrotation.ui.instances

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstancesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is instances Fragment"
    }
    val text: LiveData<String> = _text
}