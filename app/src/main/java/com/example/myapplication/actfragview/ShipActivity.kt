package com.example.myapplication.actfragview

import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.location.Location
import android.location.LocationListener
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityShipBinding
import com.example.myapplication.model.Ship
import com.example.myapplication.model.ShipList
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.properties.Delegates

var shipLat by Delegates.notNull<Double>()
var shipLong by Delegates.notNull<Double>()

class ShipActivity : AppCompatActivity(), LocationListener {
    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityShipBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_ship)
        val argum = intent.getStringExtra("argum")!!.toInt()
        val thisShip: Ship = ShipList.data(argum)
        shipLat = thisShip.lat
        shipLong = thisShip.long
        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.setImageResource(thisShip.img)
        binding.ship = thisShip
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionCode
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 0.001f, this)
    }

    override fun onLocationChanged(location: Location) {
        val dist: TextView = findViewById(R.id.type62)
        dist.text = shipDistance(shipLat, shipLong, location.latitude, location.longitude).toString()
    }

    private fun shipDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Int {
        val lat1r = lat1 * Math.PI / 180
        val lat2r = lat2 * Math.PI / 180
        val lon1r = lon1 * Math.PI / 180
        val lon2r = lon2 * Math.PI / 180
        val cos1 = cos(lat1r)
        val cos2 = cos(lat2r)
        val sin1 = sin(lat1r)
        val sin2 = sin(lat2r)
        val delta = lon2r - lon1r
        val cosd = cos(delta)
        val sind = sin(delta)
        val x = sin1 * sin2 + cos1 * cos2 * cosd
        val y = sqrt((cos2 * sind).pow(2.0) + (cos1 * sin2 - sin1 * cos2 * cosd).pow(2.0))
        val ad = atan2(y, x)
        return (ad * 6372795).toInt()
    }
}