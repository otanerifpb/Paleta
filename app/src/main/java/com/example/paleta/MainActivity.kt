package com.example.paleta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView

class MainActivity: AppCompatActivity() {
    private lateinit var tvRed: TextView
    private lateinit var tvGreen: TextView
    private lateinit var tvBlue: TextView
    private lateinit var tvResultado: TextView
    private lateinit var sbRed: SeekBar
    private lateinit var sbGreen: SeekBar
    private lateinit var sbBlue: SeekBar
    private lateinit var llResultado: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.sbBlue = findViewById(R.id.sbBlue)
        this.sbGreen = findViewById(R.id.sbGreen)
        this.sbRed = findViewById(R.id.sbRed)

        this.tvBlue = findViewById(R.id.tvBlue)
        this.tvGreen = findViewById(R.id.tvGreen)
        this.tvRed = findViewById(R.id.tvRed)
        this.tvResultado = findViewById(R.id.tvResultado)

        this.llResultado = findViewById(R.id.llResultado)

        this.llResultado.setBackgroundColor(criarCor())
        this.sbRed.setOnSeekBarChangeListener(MudarCor())
        this.sbGreen.setOnSeekBarChangeListener(MudarCor())
        this.sbBlue.setOnSeekBarChangeListener(MudarCor())

    }

    fun criarCor(): Int{
        val red = this@MainActivity.sbRed.progress
        val green = this@MainActivity.sbGreen.progress
        val blue = this@MainActivity.sbBlue.progress

       return Color.rgb(red, green, blue)
    }

    inner class MudarCor: OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            val red = this@MainActivity.sbRed.progress
            val green = this@MainActivity.sbGreen.progress
            val blue = this@MainActivity.sbBlue.progress

            this@MainActivity.tvRed.text = red.toString()
            this@MainActivity.tvGreen.text = green.toString()
            this@MainActivity.tvBlue.text = blue.toString()

            this@MainActivity.llResultado.setBackgroundColor(this@MainActivity.criarCor())
            //this@MainActivity.llResultado.setBackgroundColor(Color.rgb(red, green, blue))

            fun hexadec(): String{
                var hexa = "#"+Integer.toHexString(Color.rgb(red, green, blue)).substring(2).toUpperCase()
                return hexa
            }
            this@MainActivity.tvResultado.text = hexadec()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
//            TODO("Not yet implemented")
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
//            TODO("Not yet implemented")
        }

    }
}
