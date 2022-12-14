package inc.awesomeness.xivrotation.ui.listviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import inc.awesomeness.xivrotation.StringModel


class ListviewsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Listviews Fragment"
    }
//

    private var mutableLiveData: MutableLiveData<MutableList<StringModel>?>? = null

    fun getMovieList(): LiveData<MutableList<StringModel>?>? {
        if (mutableLiveData == null) {
            mutableLiveData = MutableLiveData()
            initMovieList()
        }
        return mutableLiveData
    }

    private fun initMovieList() {
        val movieList: MutableList<StringModel> = ArrayList()
        movieList.add(StringModel("Item 1"))
        movieList.add(StringModel("Item 2"))
        movieList.add(StringModel("Item 3"))
        mutableLiveData!!.value = movieList
    }

    fun deleteMovie(position: Int) {
        if (mutableLiveData!!.value != null) {
            val movieList: MutableList<StringModel> = ArrayList(mutableLiveData!!.value!!)
            movieList.removeAt(position)
            mutableLiveData!!.value = movieList
        }
    }

    fun addMovie(movie: StringModel) {
        if (mutableLiveData!!.value != null) {
            val movieList: MutableList<StringModel> = ArrayList(mutableLiveData!!.value!!)
            movieList.add(movie)
            mutableLiveData!!.value = movieList
        }
    }

    val text: LiveData<String> = _text

}