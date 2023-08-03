package me.kishankumar.test

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import me.kishankumar.test.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FourthFragment : Fragment() {

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
        binding.root.setBackgroundColor(Color.RED)
        binding.textviewSecond.apply {
            text = "welcome to Screen"
            textSize = 28F
        }
        sharedViewModel.updateData(4)

        binding.buttonSecond.visibility = View.GONE

    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}