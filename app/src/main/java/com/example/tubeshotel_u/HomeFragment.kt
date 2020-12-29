package com.example.tubeshotel_u.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tubeshotel_u.HotelMenu1
import com.example.tubeshotel_u.Hotelmenu2
import com.example.tubeshotel_u.R
import kotlinx.android.synthetic.main.fragment_home2.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fjayakartaHotelHome.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, HotelMenu1::class.java))
                finish()
            }
        }
        fjayakartaHoteljkt.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, Hotelmenu2::class.java))
                finish()
            }
        }

        }

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    }
