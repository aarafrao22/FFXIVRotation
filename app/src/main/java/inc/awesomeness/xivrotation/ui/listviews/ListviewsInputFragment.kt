package inc.awesomeness.xivrotation.ui.listviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import inc.awesomeness.xivrotation.R
import inc.awesomeness.xivrotation.R.navigation
import inc.awesomeness.xivrotation.StringModel
import inc.awesomeness.xivrotation.Utils
import inc.awesomeness.xivrotation.databinding.FragmentListviewsInputBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListviewsInputFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var _binding: FragmentListviewsInputBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListviewsInputBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val homeViewModel =
            activity?.let { ViewModelProvider(it).get(ListviewsViewModel::class.java) }

        val btnSave: Button = binding.btnSave

        btnSave.setOnClickListener {
            if (binding.edItemName.text != null) {

                Utils.status = 2
                val text = binding.edItemName.text.toString()
                homeViewModel!!.addMovie(StringModel(text))

                root.findNavController().navigateUp()
                Toast.makeText(context, "ItemAdded", Toast.LENGTH_SHORT).show()

//                root.findNavController().
//                navigate(R.id.action_listviewsInputFragment_to_nav_listviews)

            } else {
                Toast.makeText(context, "Please Add Something First", Toast.LENGTH_SHORT).show()
            }
        }

        return root

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListviewsInputFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}