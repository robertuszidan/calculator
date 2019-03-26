package com.example.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsatu.setOnClickListener { appendOnExpresstion ("1", true) }
        btndua.setOnClickListener { appendOnExpresstion ("2", true) }
        btntiga.setOnClickListener { appendOnExpresstion ("3", true) }
        btnempat.setOnClickListener { appendOnExpresstion ("4", true) }
        btnlima.setOnClickListener { appendOnExpresstion ("5", true) }
        btnenam.setOnClickListener { appendOnExpresstion ("6", true) }
        btntujuh.setOnClickListener { appendOnExpresstion ("7", true) }
        btndelapan.setOnClickListener { appendOnExpresstion ("8", true) }
        btnsembilan.setOnClickListener { appendOnExpresstion ("9", true) }
        btnnol.setOnClickListener { appendOnExpresstion ("0", true) }


        btntambah.setOnClickListener { appendOnExpresstion ("+", false) }
        btnkurang.setOnClickListener { appendOnExpresstion ("-", false) }
        btnkali.setOnClickListener { appendOnExpresstion ("*", false) }
        btnbagi.setOnClickListener { appendOnExpresstion ("/", false) }


        btnhapus.setOnClickListener{
            val string = proses.text.toString()
            if(string.isNotEmpty()){
                proses.text = string.substring(0, string.length-1)
            }
            hasil.text = ""
        }

        btnsamadengan.setOnClickListener{
            try{
                val expression = ExpressionBuilder(proses.text.toString()).build()
                val result = expression.evaluate()
                val longResult =result.toLong()
                if(result == longResult.toDouble())
                    hasil.text = longResult.toString()
                else
                    hasil.text = result.toString()

            } catch (e:Exception){
                Log.d("Exception", "message : " + e.message)
            }
        }
    }

    fun appendOnExpresstion(string: String,canClear: Boolean){

        if(hasil.text.isNotEmpty()){
            proses.text = ""
        }

        if(canClear){
            hasil.text = ""
            proses.append(string)
        } else {
            proses.append(hasil.text)
            proses.append(string)
            hasil.text = ""
        }
    }
}