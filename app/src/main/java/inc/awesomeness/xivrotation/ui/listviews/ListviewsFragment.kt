package inc.awesomeness.xivrotation.ui.listviews

import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import inc.awesomeness.xivrotation.MovieListAdapter
import inc.awesomeness.xivrotation.RVAdapter
import inc.awesomeness.xivrotation.StringModel
import inc.awesomeness.xivrotation.Utils
import inc.awesomeness.xivrotation.databinding.FragmentHomeBinding
import inc.awesomeness.xivrotation.databinding.FragmentListviewsBinding

class ListviewsFragment : Fragment(), MovieListAdapter.MovieClickInterface {

    private var _binding: FragmentListviewsBinding? = null
    private val binding get() = _binding!!
    var items: MutableList<StringModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this).get(ListviewsViewModel::class.java)
        Utils.status = 1
        _binding = FragmentListviewsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var recyclerView: RecyclerView = binding.recyclerView

        var adapter = MovieListAdapter(StringModel.itemCallback, this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        homeViewModel.getMovieList()!!
            .observe(viewLifecycleOwner) { t ->
                adapter.submitList(t as List<StringModel?>?)
            }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDelete(position: Int) {

    }
}