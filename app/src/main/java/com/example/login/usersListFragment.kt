package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase




class usersListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var recView:RecyclerView?= null
    private var adapter : myAdapter?=null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_users_list, container, false)
        recView = view.findViewById(R.id.recview)
        recView?.layoutManager = LinearLayoutManager(context)
        val options = FirebaseRecyclerOptions.Builder<model>().setQuery(FirebaseDatabase.getInstance().getReference("users"),model::class.java)
            .setLifecycleOwner(this).build()
        adapter = myAdapter(options = options)
        recView?.adapter = adapter
        return view
    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter?.stopListening()
    }
    }
