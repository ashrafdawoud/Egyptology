package com.indrul.egyptology.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.indrul.egyptology.R
import com.jama.carouselview.CarouselView
import com.jama.carouselview.enums.IndicatorAnimationType
import com.jama.carouselview.enums.OffsetType
import java.util.logging.Handler
import kotlin.math.log

class KingsActivity : AppCompatActivity() {
    private val movies  = arrayListOf(R.drawable.kings,
            R.drawable.gods, R.drawable.places)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kings)
        ///////////////////////////////////
        val window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = this.resources.getColor(R.color.top_color)
        window.navigationBarColor = this.resources.getColor(R.color.bottom_color)
        ///////////////////
        coursorview()
        coursorview2()

    }
    fun coursorview() {
        val carouselView = findViewById<CarouselView>(R.id.carouselView)
        carouselView.apply {
            autoPlay = false
            size = movies.size
            resource = R.layout.start_carousel_trending_item
            scaleOnScroll = true
            spacing = 0
            hideIndicator(true)
            setCarouselViewListener { view, position ->
                val imageView = view.findViewById<ImageView>(R.id.imageView)
                val text=view.findViewById<TextView>(R.id.text);
                text.setText("King")
                imageView.setImageDrawable(resources.getDrawable(movies[position]))
                imageView.setOnClickListener { Log.e("asasad",position.toString()) }

            }
            show()
            postDelayed(Runnable { currentItem = 1 },100)


        }

    }
    fun coursorview2() {
        val namelist= arrayListOf("Predynastic period","Early Dynastic ","Old Kingdom","First Intermediate ","Middle Kingdom","Second Intermediate ","New Kingdom","Third Intermediate ","Late Period","Hellenistic ")
        val discription= arrayListOf("spans the period from the earliest human settlement to the beginning of the Early Dynastic Period","The Early Dynastic Period of Egypt stretches from around 3150 to 2686 BC.","the point of Egypt which succeeded the Early Dynastic Egypt and precedes the troubled First Intermediate Period"
        ,"a period of disarray and chaos between the end of the Old Kingdom and the advent of the Middle Kingdom.","period from the end of the First Intermediate Period to the beginning of the Second Intermediate Period"
        ," period of disarray between the end of the Middle Kingdom, and the start of the New Kingdom.","period covering the Eighteenth, Nineteenth, and Twentieth dynasty of Egypt",
        " the end of the New Kingdom after the collapse of the Egyptian empire","includes periods of rule by native Egyptians and Persians.","The Macedonian Greeks under Alexander the Great ushered in the Hellenistic period with his conquest of Persia and Egypt")
        val date= arrayListOf("6000 to 3100 BC","3150 to 2890 BC","2686 to 2181 BC.","2181 to 2060 BC","2060 to 1802 BC","1802 to 1550 BC"
        ,"1550 to 1077 BC","1077 to 664 BC","664 to 332 BC"," 332 to 309 BC:")
        val carouselView = findViewById<CarouselView>(R.id.carouselView2)
        carouselView.apply {
            autoPlay = false
            size = namelist.size
            resource = R.layout.carsoul_item
            //scaleOnScroll = true
            spacing = 40
            hideIndicator(true)
            setCarouselViewListener { view, position ->
            val header=view.findViewById<TextView>(R.id.text1)
            val body=view.findViewById<TextView>(R.id.text2)
             val pc=view.findViewById<TextView>(R.id.text3)
                header.setText(namelist.get(position))
                body.setText(discription.get(position))
                pc.setText(date.get(position))



            }
            show()
            postDelayed(Runnable { currentItem = 1 },100)
        }

    }

    fun back(view: View) {
        finish()
        overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
    }
}