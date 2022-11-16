package inc.awesomeness.xivrotation

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
class RVAdapter(){}
//class RVAdapter(
//    diffCallback: DiffUtil.ItemCallback<StringModel?>,
//    val item: MutableList<StringModel>?
//) : ListAdapter<StringModel, RVAdapter.ViewHolder>(diffCallback) {
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        var txtName: TextView = itemView.findViewById<TextView>(R.id.txtItem)
//        fun setData(
//            feature: String?
//        ) {
//            this.txtName.text = feature.toString()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
//        val view: View = layoutInflater.inflate(R.layout.recycler_view, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.setData(item!![position].name)
//    }
//
//    override fun getItemCount(): Int {
//        return item!!.size
//    }
//}