package com.example.myapplication1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var button: Button? = null
    private var res: TextView? = null
    private var sub: TextView? = null

    private var Name: EditText? = null
    private var Height: EditText? = null
    private var Weight: EditText? = null
    private var Age: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        res = findViewById(R.id.Result)
        sub = findViewById(R.id.sub)
        Name = findViewById(R.id.sName)
        Height = findViewById(R.id.sHeight)
        Weight = findViewById(R.id.sWeight)
        Age = findViewById(R.id.sAge)

        button = findViewById(R.id.button1)


        button?.setOnClickListener {
            val name1: String = Name?.text.toString()
            val height1: String = Height?.text.toString()
            val weight1: String = Weight?.text.toString()
            val age1: String = Age?.text.toString()
            if(((name1!="" && height1!="" && weight1!="" && age1!=""))
                && (checkHeight(height1.toInt())!=0)
                && (checkWeight(weight1.toDouble())!=0)
                && (checkAge(age1.toInt())!=0)){
                val value = ((weight1.toDouble()*10) + (height1.toInt()*6.25) - (age1.toInt()*5))
                res?.text = "$value"
                sub?.text = "$name1, смотрите, что у нас получилось:"
            } else {
                res?.text = "Данные введены некорректно"
                sub?.text = "Что-то пошло не так..."
            }
        }
    }

    fun checkHeight(h: Int): Int{
        if(h in 1..249){
            return 1
        }
        return 0
    }

    fun checkWeight(w:Double): Int{
        if(w>0 && w<250){
            return 1
        }
        return 0
    }

    fun checkAge(a:Int): Int{
        if(a in 1..149){
            return 1
        }
        return 0
    }
}