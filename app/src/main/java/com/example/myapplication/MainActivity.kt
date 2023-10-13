package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.CRUD.CRUD


class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var sound : MediaPlayer
        val button=findViewById<Button>(R.id.button)
        val entry = findViewById<EditText>(R.id.entry)
        var text =findViewById<TextView>(R.id.greet)
        var names=findViewById<Button>(R.id.names)
        names.setOnClickListener({
            startActivity(Intent(this,Recyclerview::class.java))
        })
        var s=""
        lateinit var name:String
        val bmi=findViewById<Button>(R.id.bmi)
        bmi.setOnClickListener({
            startActivity(Intent(this,BMI::class.java))
        })


        var coroutine=findViewById<Button>(R.id.coroutine)
        coroutine.setOnClickListener(
            {
                startActivity(Intent(this,CoroutineDemo::class.java))
            }
        )

        lateinit var viewmodel:ViewModelDemo
        var str=""
        viewmodel=ViewModelProvider(this).get(ViewModelDemo::class.java)

        viewmodel.cnt.observe(this,{
            text.text=it.toString()
            str=it.toString()+"gaurav"


        })

        Log.i("checkkbt",str)

        var btncount:Button=findViewById(R.id.btncount)
        btncount.setOnClickListener({
            viewmodel.updtccnt()
            text.text=str+"ravi"
            Log.i("checkkbt",str)
//            text.text=viewmodel.count.toString()

        })






        button.setOnClickListener(View.OnClickListener {

            s=entry.text.toString()
            if (s==""){
                Toast.makeText(this@MainActivity,"Please enter a name",Toast.LENGTH_SHORT).show()
            }
            else{
            text.text="Hello "+s
            entry.text.clear()}
        })

        var Video = findViewById<Button>(R.id.Video)
        Video.setOnClickListener({


            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "video/*" // Filter for video files
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            startForResult.launch(intent)



        })

        text.setOnClickListener({
            val anim =AnimationUtils.loadAnimation(this,R.drawable.effect)
            text.startAnimation(anim)

            val inten=Intent(this@MainActivity,VisibleInvisibleButton::class.java)
            inten.putExtra("name",s)



            startActivity(inten)

        })

        val play = findViewById<Button>(R.id.play)

        play.setOnClickListener({
            startActivity(Intent(this@MainActivity,music::class.java))
        })


        var crud : Button = findViewById(R.id.crud)
        crud.setOnClickListener({
            startActivity(Intent(this, CRUD::class.java))
        })

    }

    override fun onResume() {
        super.onResume()
        Log.i("mytag","MainActivity: on resume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("mytag","MainActivity: on restart")

    }

    override fun onStart() {
        super.onStart()
        Log.i("mytag","MainActivity: on start")
    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","MainActivity: on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag","MainActivity: on destroy")
    }







    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { res: ActivityResult ->
            if (res.resultCode == Activity.RESULT_OK) {
                val data: Intent? = res.data
                data?.data?.let { uri ->

                    // Set the selected video file's URI to the VideoView
                    var inte=Intent(this@MainActivity,VideoActivity::class.java)
                    inte.putExtra("uri",uri)
                    startActivity(inte)
                }
            }
        }
}