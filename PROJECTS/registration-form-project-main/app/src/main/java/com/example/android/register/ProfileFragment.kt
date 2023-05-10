package com.example.android.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import register.databinding.FragmentProfileBinding
import register.R



 class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null  //The instance of our binding class is
    // scoped to the lifecycle of our fragment (between onCreateView and onDestroyView)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view) //Binds already inflated view to the instance
        // of binding class

        //Restores saved state in case of configuration changes or fragment lifecycle destruction
        binding!!.profileName.text = savedInstanceState?.getString(getString(R.string.saved_instance_name_key)) ?: getString(R.string.Nil)
        binding!!.profileEmail.text = savedInstanceState?.getString(getString(R.string.saved_instance_email_key)) ?: getString(R.string.Nil)
        binding!!.profilePhone.text = savedInstanceState?.getString(getString(R.string.saved_instance_phone_key)) ?: getString(R.string.Nil)
        binding!!.profileGender.text = savedInstanceState?.getString(getString(R.string.saved_instance_gender_key)) ?: getString(R.string.Nil)

        //Retrieves data sent from Registration
        //fragment via fragment manager using a bundle with a specific key
        setFragmentResultListener(getString(R.string.name_key)) { _, bundle ->
            binding!!.profileName.text = bundle.getString(getString(R.string.bundle_key))
        }
        setFragmentResultListener(getString(R.string.gender_key)) { _, bundle ->
            binding!!.profileGender.text = bundle.getString(getString(R.string.bundle_key))
        }
        setFragmentResultListener(getString(R.string.email_key)) { _, bundle ->
            binding!!.profileEmail.text = bundle.getString(getString(R.string.bundle_key))
        }
        setFragmentResultListener(getString(R.string.phone_key)) { _, bundle ->
            binding!!.profilePhone.text = bundle.getString(getString(R.string.bundle_key))

        }

    }

    override fun onDestroyView() { //Since fragments outlive their views, it is important to clean
        //up any references to the binding class instance here
        super.onDestroyView()
        binding = null

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(getString(R.string.saved_instance_name_key), binding!!.profileName.text.toString())
        outState.putString(getString(R.string.saved_instance_email_key), binding!!.profileEmail.text.toString())
        outState.putString(getString(R.string.saved_instance_phone_key), binding!!.profilePhone.text.toString())
        outState.putString(getString(R.string.saved_instance_gender_key), binding!!.profileGender.text.toString())

    }

}
