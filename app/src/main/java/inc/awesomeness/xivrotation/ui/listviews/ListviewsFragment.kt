package inc.awesomeness.xivrotation.ui.listviews

import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import inc.awesomeness.xivrotation.*
import inc.awesomeness.xivrotation.databinding.FragmentListviewsBinding

class ListviewsFragment : Fragment(), MovieListAdapter.MovieClickInterface {
    var list = mutableListOf<Int>();
    private var _binding: FragmentListviewsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            activity?.let { ViewModelProvider(it).get(ListviewsViewModel::class.java) }
        Utils.status = 1

        _binding = FragmentListviewsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.recyclerView
        val btnFab: FloatingActionButton = binding.btnFab
        val btnDelete: Button = binding.btnDelete

        val adapter = MovieListAdapter(StringModel.itemCallback, this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        btnFab.setOnClickListener {
            root.findNavController().navigate(R.id.action_nav_listviews_to_listviewsInputFragment)
        }

        btnDelete.setOnClickListener {
            if (list.size > 0) {
                list.sortDescending()
                Log.d(TAG, "list: " + list)
//                val size:Int =list.size-1
                for (item in list) {
                    homeViewModel?.deleteMovie(item)
                }
//                for (i in list.size - 1 downTo 0) {
//                    homeViewModel?.deleteMovie(i)
//                }

            } else {
                Toast.makeText(context, "Select Something first", Toast.LENGTH_SHORT).show()
            }
            list = mutableListOf<Int>()
        }
        homeViewModel!!.getMovieList()!!
            .observe(viewLifecycleOwner) { t ->
                adapter.submitList(t as List<StringModel?>?)
                Log.d(TAG, "updatedList: ${t?.size} ")
            }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(position: Int) {
        if (!list.contains(position)) {
            list.add(position)
        }else{
            Toast.makeText(context, "Item is already in the list", Toast.LENGTH_SHORT).show()
        }
    }


}