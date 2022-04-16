package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class myAdapter(options: FirebaseRecyclerOptions<model>) : FirebaseRecyclerAdapter<model, myAdapter.myViewHolder>(options) {

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listName : TextView = itemView.findViewById(R.id.listName)
        val listEmail : TextView = itemView.findViewById(R.id.listEmail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
            var view : View = LayoutInflater.from(parent.context).inflate(R.layout.user_item_list,parent,false)
            return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int, model: model) {
    holder.listName.text = model.name
        holder.listEmail.text = model.email
      }
}