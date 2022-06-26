package com.example.animationsample

import android.animation.ObjectAnimator
import android.graphics.Path
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.animationsample.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var firstClick: Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = (displayMetrics.widthPixels / 2).toFloat()
        Toast.makeText(requireContext(), "Width:${width}", Toast.LENGTH_SHORT).show()

        val calPositionWidthWise = (displayMetrics.widthPixels / 6).toFloat()

        var animatorTwo = ObjectAnimator()
        var animatorThree = ObjectAnimator()
        var animatorFour = ObjectAnimator()
        var animatorFive = ObjectAnimator()
        var animatorSix = ObjectAnimator()

        binding.buttonSecond.setOnClickListener {
            if (firstClick) {
                firstClick = false
                val pathTwo = Path().apply {
                    moveTo(calPositionWidthWise, 0f)
                    lineTo(width, 0f)
                }
                animatorTwo = ObjectAnimator.ofFloat(binding.llTwo, View.X, View.Y, pathTwo).apply {
                    duration = 1000
                    start()
                }

                val pathThree = Path().apply {
                    moveTo((calPositionWidthWise * 2), 0f)
                    lineTo(0f, (calPositionWidthWise))
                }
                animatorThree = ObjectAnimator.ofFloat(binding.llThree, View.X, View.Y, pathThree).apply {
                    duration = 1000
                    start()
                }

                val pathFour = Path().apply {
                    moveTo((calPositionWidthWise * 3), 0f)
                    lineTo(width, (calPositionWidthWise))
                }
                animatorFour = ObjectAnimator.ofFloat(binding.llFour, View.X, View.Y, pathFour).apply {
                    duration = 1000
                    start()
                }

                val pathFive = Path().apply {
                    moveTo((calPositionWidthWise * 4), 0f)
                    lineTo(0f, (calPositionWidthWise * 2))
                }
                animatorFive = ObjectAnimator.ofFloat(binding.llFive, View.X, View.Y, pathFive).apply {
                    duration = 1000
                    start()
                }

                val pathSix = Path().apply {
                    moveTo((calPositionWidthWise * 5), 0f)
                    lineTo(width, (calPositionWidthWise * 2))
                }
                animatorSix = ObjectAnimator.ofFloat(binding.llSix, View.X, View.Y, pathSix).apply {
                    duration = 1000
                    start()
                }

                binding.txtOne.visibility = View.VISIBLE
                binding.txtTwo.visibility = View.VISIBLE
                binding.txtThree.visibility = View.VISIBLE
                binding.txtFour.visibility = View.VISIBLE
                binding.txtFive.visibility = View.VISIBLE
                binding.txtSix.visibility = View.VISIBLE
            } else {
                firstClick = true
                animatorTwo.reverse()
                animatorThree.reverse()
                animatorFour.reverse()
                animatorFive.reverse()
                animatorSix.reverse()

                binding.txtOne.visibility = View.GONE
                binding.txtTwo.visibility = View.GONE
                binding.txtThree.visibility = View.GONE
                binding.txtFour.visibility = View.GONE
                binding.txtFive.visibility = View.GONE
                binding.txtSix.visibility = View.GONE
            }
        }

        /*binding.buttonSecond.setOnClickListener {
            if (firstClick) {
                firstClick = false
                val path = Path().apply {
                    moveTo(0f, calPositionWidthWise)
                }
                val path4 = Path().apply {
                    moveTo(0f, calPositionWidthWise * 2)
                }
                animatorTwo = ObjectAnimator.ofFloat(binding.llTwo, View.X, View.Y, path).apply {
                    duration = 1000
                    start()
                }
                animatorFour = ObjectAnimator.ofFloat(binding.llFour, View.X, View.Y, path4).apply {
                    duration = 2000
                    start()
                }
            } else {
                firstClick = true
                animatorTwo.reverse()
                animatorFour.reverse()
            }
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}