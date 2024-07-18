package com.example.awakemeneh.ui.history

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.awakemeneh.R
import com.example.awakemeneh.databinding.ActivityHistoryAwakeBinding
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class HistoryAwake : AppCompatActivity() {

    private lateinit var lineGraphView: GraphView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHistoryAwakeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize lineGraphView
        lineGraphView = binding.idGraphView

        // Set click listener for back icon
        val backIcon = binding.root.findViewById<ImageView>(R.id.backhis)
        backIcon.setOnClickListener {
            // Finish the current activity and go back to the previous one
            finish()
        }

        val series = LineGraphSeries(
            arrayOf(
                // Adding data points with days of the week as x-values
                DataPoint(1.0, 2.0), // Monday
                DataPoint(2.0, 1.0), // Tuesday
                DataPoint(3.0, 3.0), // Wednesday
                DataPoint(4.0, 2.0), // Thursday
                DataPoint(5.0, 4.0), // Friday
                DataPoint(6.0, 3.0), // Friday
                DataPoint(7.0, 4.0)  // Sunday
            )
        )

        // Set custom labels for x-axis and y-axis
        val staticLabelsFormatter = StaticLabelsFormatter(lineGraphView)
        staticLabelsFormatter.setHorizontalLabels(arrayOf("Mon", "Tue", "Wed", "Thurs", "Fri", "Sat", "Sun"))
        staticLabelsFormatter.setVerticalLabels(arrayOf("0","1", "2", "3", "4"))
        lineGraphView.gridLabelRenderer.labelFormatter = staticLabelsFormatter

        // Set the viewport to show the range of days
        lineGraphView.viewport.isXAxisBoundsManual = true
        lineGraphView.viewport.setMinX(1.0)
        lineGraphView.viewport.setMaxX(7.0)

        // Enable scrolling and scaling
        lineGraphView.viewport.isScrollable = true
        lineGraphView.viewport.isScalable = true
        lineGraphView.viewport.setScalableY(true)
        lineGraphView.viewport.setScrollableY(true)

        // Set the color for the series
        series.color = R.color.purple_200

        // Add the series to the graph view
        lineGraphView.addSeries(series)
    }
}
