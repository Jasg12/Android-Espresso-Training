package com.example.android.register

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResult

import register.databinding.FragmentRegistrationBinding
import register.R


class RegistrationFragment : Fragment(R.layout.fragment_registration),
    AdapterView.OnItemSelectedListener {

    private var binding: FragmentRegistrationBinding? = null //The instance of our binding class is
    // scoped to the lifecycle of our fragment (between onCreateView and onDestroyView)
    lateinit var name:String
    lateinit var email:String
    lateinit var phone:String
    lateinit var itemSelected:String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view) //Binds already inflated view to the
        // instance of binding class

        binding!!.submitButton.setOnClickListener() {

            name = binding!!.editTextName.text.toString()
            email = binding!!.editTextEmail.text.toString()
            phone = binding!!.editTextPhoneNumber.text.toString()

            //Prints toast if any filed does not pass successful validation
           if (!Utils.nameValidator(name))
               Toast.makeText(context, R.string.invalid_name_message, Toast.LENGTH_SHORT).show()

           else if (!Utils.emailValidator(email))
               Toast.makeText(requireContext(), R.string.invalid_email_message, Toast.LENGTH_SHORT).show()

          /* else if (!Utils.phoneNumberValidator(phone))
               Toast.makeText(requireContext(), R.string.invalid_phone_message, Toast.LENGTH_SHORT).show()*/

           else
               parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<ProfileFragment>(R.id.fragment_container_view)
                    addToBackStack(null)
                }

            //Bundles data in a key-value pair via Fragment Manager to ProfileFragment
            setFragmentResult(getString(R.string.name_key), bundleOf(getString(R.string.bundle_key) to name))
            setFragmentResult(getString(R.string.gender_key), bundleOf(getString(R.string.bundle_key) to itemSelected))
            setFragmentResult(getString(R.string.email_key), bundleOf(getString(R.string.bundle_key) to email))
            setFragmentResult(getString(R.string.phone_key), bundleOf(getString(R.string.bundle_key) to phone))
        }

        val spinner: Spinner = binding!!.spinnerGender

        ArrayAdapter.createFromResource( // Creates an ArrayAdapter using the string array and a
                // default spinner layout
                requireContext(),
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        ).also { adapter -> // Specifies the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter // Applies the adapter to the spinner
        }

        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
       itemSelected = parent.getItemAtPosition(pos) as String
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
         itemSelected = getString(R.string.Nil)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}