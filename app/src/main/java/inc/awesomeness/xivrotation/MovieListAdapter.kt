package inc.awesomeness.xivrotation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter constructor(
    diffCallback: DiffUtil.ItemCallback<StringModel?>,
    var movieClickInterface: MovieClickInterface
) :
    ListAdapter<StringModel?, MovieListAdapter.MovieViewHolder?>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: StringModel? = getItem(position)
        holder.bind(movie)
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView
        fun bind(movie: StringModel?) {
            nameTextView.setText(movie?.name)
        }



        init {
            nameTextView = itemView.findViewById(R.id.nameTextview)

//            deleteButton.setOnClickListener { movieClickInterface.onDelete(adapterPosition) }
        }
    }

    interface MovieClickInterface {
        fun onDelete(position: Int)
    }
}
