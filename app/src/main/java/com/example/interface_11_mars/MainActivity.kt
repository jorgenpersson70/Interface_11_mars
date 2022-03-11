package com.example.interface_11_mars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

interface Myblueprint{

    var sometext : String
    var somenumber : Int

    fun dosstuff()

    fun domore(){
        Log.i("MIN", "DOMORE")
    }
}

interface RecipeFrag {
    fun dummy(){

    }

    fun doingBack() : Boolean


}

class MainActivity : AppCompatActivity(), Myblueprint, RecipeFrag {

    override var sometext: String = ""

    var thestartfrag = BlankFragment()
    /*
    override var sometext: String
        get() = TODO("Not yet implemented")
        set(value) {}*/


    override var somenumber: Int = 7
/*    override var somenumber: Int
        get() = TODO("Not yet implemented")
        set(value) {}*/

    override fun dosstuff() {
        TODO("Not yet implemented")
    }

    override fun domore() {
        super.domore()
        Log.i("MIN", "DOMORE OVERRIDE")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        domore()

        findViewById<Button>(R.id.goReadmoreButton).setOnClickListener {

            val intent = Intent(this, second::class.java)

            intent.putExtra("fruit", "Banan")

            startActivity(intent)

        }

        findViewById<Button>(R.id.fragBtn).setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.myContainer, third()).commit()
        }

        findViewById<Button>(R.id.fragBtn2).setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.myContainer, thestartfrag).commit()
  //          supportFragmentManager.beginTransaction().add(R.id.myContainer, thestartfrag).commit()
        }

    }

    override fun onBackPressed() {
     //   super.onBackPressed()
  // vi plockar bort grundbeteendet      super.onBackPressed()
      /*  var testa = second as RecipeFrag

        testa.doingBack()*/
        Log.i("MIN", supportFragmentManager.fragments.size.toString())

        var lastfrag = supportFragmentManager.fragments.last() as RecipeFrag

        if (lastfrag.doingBack() == true){
            super.onBackPressed()
        }





    }

    override fun doingBack(): Boolean {
        Log.i("MIN", "BACK")
        return true
    }


}