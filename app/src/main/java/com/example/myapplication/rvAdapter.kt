package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rvAdapter(val arr:List<String>) : RecyclerView.Adapter<myvh>( ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myvh {
        val inflater=LayoutInflater.from(parent.context)

        val listitem=inflater.inflate(R.layout.listitem,parent,false)
        return myvh(listitem)
    }

    override fun onBindViewHolder(holder: myvh, position: Int) {
        holder.tv1.text=arr.get(position)
        holder.tv2.text=" $position"
    }

    override fun getItemCount(): Int {
        return arr.size
    }
}
class myvh(var view: View):RecyclerView.ViewHolder(view){
    val tv1=view.findViewById<TextView>(R.id.tv1)
    val tv2=view.findViewById<TextView>(R.id.tv2)

}