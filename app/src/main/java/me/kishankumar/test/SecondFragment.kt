package me.kishankumar.test

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import me.kishankumar.test.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val reqHeight = requireContext().resources.displayMetrics.heightPixels * 0.25
        binding.root.layoutParams.height = reqHeight.toInt()
        binding.root.setBackgroundColor(Color.GREEN)
        binding.textviewSecond.text = "This is Second frag"
        sharedViewModel.updateData(2)

        binding.buttonSecond.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.add(R.id.container, ThirdFragment())
            transaction.addToBackStack(this.tag)
            transaction.commit()

            /*val thirdFragment = ThirdFragment()
            thirdFragment.show(requireActivity().supportFragmentManager, thirdFragment.tag)*/
        }

        sharedViewModel.getSharedData().observe(this, Observer { value ->
            Log.d("chealth", "onViewCreated: second $value")

            when (value) {
                //1->binding.root.layoutParams.height = reqHeight.toInt()
                2 -> binding.root.layoutParams.height = reqHeight.toInt()
                3 -> binding.root.layoutParams.height = 2 * reqHeight.toInt()
                4 -> binding.root.layoutParams.height = 3 * reqHeight.toInt()
                else -> binding.root.layoutParams.height = reqHeight.toInt()
            }

        })

    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}