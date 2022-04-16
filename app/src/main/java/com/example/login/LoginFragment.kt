package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.login.databinding.FragmentCurrUserBinding
import com.example.login.databinding.FragmentLoginBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class LoginFragment : Fragment() {
    private var binding : FragmentLoginBinding? = null
    private var database : DatabaseReference?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding?.btnSubmit?.setOnClickListener {
            val name : String = binding?.signupName?.text.toString()
            val email:String = binding?.signupEmail?.text.toString()
            val password:String = binding?.signupPassword?.text.toString()

            view?.findNavController()?.navigate(R.id.action_loginFragment_to_currUserFragment)

            database = FirebaseDatabase.getInstance().getReference("users")
            val user =User(name, email, password)
            database!!.child(name).setValue(user).addOnSuccessListener {

                view?.findNavController()?.navigate(R.id.action_loginFragment_to_currUserFragment)
//                binding?.signupName?.text?.clear()
//                binding?.signupEmail?.text?.clear()
//                binding?.signupConfirmPassword?.text?.clear()
//                binding?.signupPassword?.text?.clear()
            }.addOnFailureListener {
                Toast.makeText(context,"FAILED",Toast.LENGTH_SHORT).show()
            }

        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
        }





