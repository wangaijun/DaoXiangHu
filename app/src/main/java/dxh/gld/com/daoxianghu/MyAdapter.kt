package dxh.gld.com.daoxianghu

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(private val list: MutableList<Data>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val root = inflater.inflate(R.layout.item, viewGroup, false)
        return MyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        val title = "${position + 1} ${data.title}"
        if (isKey(data)){
           holder.tvTitle.text = Html.fromHtml("<font color='red'>$title</font>")
        }
        else{
            holder.tvTitle.text = title
        }

        holder.tvContent.text = data.content
    }

    private fun isKey(data: Data): Boolean {
        return data.title.contains("起步") ||
                data.title.contains("左转弯") ||
                data.title.contains("掉头") ||
                data.title.contains("右转弯") ||
                data.title.contains("靠边停车")
    }

}

class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    val tvContent = itemView.findViewById<TextView>(R.id.tvContent)
}