package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.core.view.marginTop

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CRUD.Students
import kotlinx.coroutines.NonDisposableHandle.parent


class StudentsRVAdapter(private val clickllistner:(Students) -> Unit) :RecyclerView.Adapter<StuVH>() {

    private var arrr =ArrayList<Students>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StuVH {
        var inflater = LayoutInflater.from(parent.context)
        var vie = inflater.inflate(R.layout.crud_item,parent,false)
        return StuVH(vie)
    }

    override fun onBindViewHolder(holder: StuVH, position: Int) {
        holder.bind(arrr[position],clickllistner)
    }

    override fun getItemCount(): Int {
        return arrr.size
    }
    fun serArr(arr : List<Students>){
        arrr.clear()
        arrr.addAll(arr)
    }

}
class StuVH(private var view : View):RecyclerView.ViewHolder(view){
    fun bind(students: Students,clicklistner:(Students)->Unit){
        val name = view.findViewById<TextView>(R.id.tvname)
        val email = view.findViewById<TextView>(R.id.tvemail)
        name.text=students.name
        email.text=students.email
        view.setOnClickListener {

            clicklistner(students)
        }

    }


}