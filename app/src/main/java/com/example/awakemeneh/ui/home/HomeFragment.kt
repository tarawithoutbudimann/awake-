package com.example.awakemeneh.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.awakemeneh.R
import com.example.awakemeneh.databinding.FragmentHomeBinding
import com.example.awakemeneh.ui.adapter.CardAdapter
import com.example.awakemeneh.ui.adapter.SliderAdapter
import com.example.awakemeneh.ui.alertlevel.AlertLevel
import com.example.awakemeneh.ui.data.Card
import com.example.awakemeneh.ui.funfact.FaktaUnik
import com.example.awakemeneh.ui.history.HistoryAwake
import com.example.awakemeneh.ui.livecam.CameraLive
import com.example.awakemeneh.ui.restarea.RestAreaSearch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPager: ViewPager2
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var cardAdapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewPager = binding.viewPager

        val imageList = listOf(
            R.drawable.banner1,
            R.drawable.banner4,
            R.drawable.banner3,
            R.drawable.banner2
        )

        sliderAdapter = SliderAdapter(imageList)
        viewPager.adapter = sliderAdapter

        // Initialize RecyclerView
        recyclerView = binding.recyclerView3
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val cardList = listOf(
            Card(R.drawable.banner1, "Berita Terkini", "Tol Gelanggang UGM", "5.0 ★★★★★ (58 Reviews)", "2.5 km/40min", "Hospital"),
            Card(R.drawable.banner2, "Berita Terkini", "Jembatan Janti", "4.9 ★★★★★ (8 Reviews)", "2.5 km/40min", "Clinic"),
            Card(R.drawable.banner3, "Berita Terkini", "Universitas Gudang Mantu", "4.9 ★★★★★ (2 Reviews)", "2.5 km/40min", "Clinic")
            // Add more cards as needed
        )

        cardAdapter = CardAdapter(cardList)
        recyclerView.adapter = cardAdapter

        val restAreaIcon = binding.root.findViewById<ImageView>(R.id.restareaicon)
        restAreaIcon.setOnClickListener {
            // Perform action on click
            val intent = Intent(activity, RestAreaSearch::class.java)
            startActivity(intent)
        }
        // Set click listener for live camera
        val alertlebel = binding.root.findViewById<ImageView>(R.id.alertlebelicon)
        alertlebel.setOnClickListener {
            // Perform action on click
            val intent = Intent(activity, AlertLevel::class.java)
            startActivity(intent)
        }
        // Set click listener for history
        val histo = binding.root.findViewById<ImageView>(R.id.historyicon)
        histo.setOnClickListener {
            // Perform action on click
            val intent = Intent(activity, HistoryAwake::class.java)
            startActivity(intent)
        }
        // Set click listener for fakta unik
        val pakta = binding.root.findViewById<ImageView>(R.id.faktaunikicon)
        pakta.setOnClickListener {
            // Perform action on click
            val intent = Intent(activity, FaktaUnik::class.java)
            startActivity(intent)
        }
        // Set click listener for live camera
        val livecamicon = binding.root.findViewById<ImageView>(R.id.livecamicon)
        livecamicon.setOnClickListener {
            // Perform action on click
            val intent = Intent(activity, CameraLive::class.java)
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
