package com.example.nityaarora.tictactoe

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var selection=0

    var savePlace= arrayOf<Int>(2,2,2,2,2,2,2,2,2)

    var winner= intArrayOf(0,1,2,3,4,5,6,7,8,0,3,6,1,4,7,2,5,8,0,4,8,2,4,6)

    var won=false

    fun restart(){
        selection=0
        savePlace= arrayOf(2,2,2,2,2,2,2,2,2)
        won=false

        var yo=findViewById<ImageView>(R.id.image1)
        yo.setImageResource(0)
        yo=findViewById(R.id.image2)
        yo.setImageResource(0)
        yo=findViewById(R.id.image3)
        yo.setImageResource(0)
        yo=findViewById(R.id.image4)
        yo.setImageResource(0)
        yo=findViewById(R.id.image5)
        yo.setImageResource(0)
        yo=findViewById(R.id.image6)
        yo.setImageResource(0)
        yo=findViewById(R.id.image7)
        yo.setImageResource(0)
        yo=findViewById(R.id.image8)
        yo.setImageResource(0)
        yo=findViewById(R.id.image9)
        yo.setImageResource(0)
    }

    fun reset(view: View){
        restart()
    }

    fun alertThing(message:String){

        var builder=AlertDialog.Builder(this)
        builder.setTitle(message)
        builder.setMessage("Play Again?")
        builder.setPositiveButton("Yes",object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                restart()
            }
        })
        builder.setNegativeButton("No",object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {

            }
        })
        var alert=builder.create()
        alert.show()
    }

    fun chooseImage(img:ImageView)
    {
        if(won==false) {

            var t = img.getTag().toString().toInt()
            if (savePlace[t - 1] == 2) {
                if (selection == 0) {
                    img.setImageResource(R.drawable.red)
                    savePlace[t - 1] = selection
                    selection = 1
                } else {
                    img.setImageResource(R.drawable.yellow)
                    savePlace[t - 1] = selection
                    selection = 0
                }
            }
            for (i in 0..winner.size - 1 step 3) {
                var arr = arrayOf(winner[i], winner[i + 1], winner[i + 2])

                if (savePlace[arr[0]] == savePlace[arr[1]] && savePlace[arr[1]] == savePlace[arr[2]] && savePlace[arr[1]] != 2) {
                    Log.i("winner", "congrats" + selection.toString())
                    won = true

                    alertThing("Player "+selection.toString()+" won. Hurray!")
                    break
                }
            }
            var c:Int=0
            for (i in 0..savePlace.size-1)
            {
                if(savePlace[i]!=2)
                    c++
                if(c==savePlace.size && won==false)
                   alertThing("Oops it's a draw!")
            }
        }

    }

    fun showImage(view:View)
    {
        when(view.id){
            R.id.image1->chooseImage(findViewById<ImageView>(R.id.image1))
            R.id.image2->chooseImage(findViewById<ImageView>(R.id.image2))
            R.id.image3->chooseImage(findViewById<ImageView>(R.id.image3))
            R.id.image4->chooseImage(findViewById<ImageView>(R.id.image4))
            R.id.image5->chooseImage(findViewById<ImageView>(R.id.image5))
            R.id.image6->chooseImage(findViewById<ImageView>(R.id.image6))
            R.id.image7->chooseImage(findViewById<ImageView>(R.id.image7))
            R.id.image8->chooseImage(findViewById<ImageView>(R.id.image8))
            R.id.image9->chooseImage(findViewById<ImageView>(R.id.image9))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
