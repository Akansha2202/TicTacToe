package com.example.tictactoe2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //val textView=findViewById<TextView>(R.id.winner)


        btnReset.setOnClickListener {

            btn1.setBackgroundColor(Color.parseColor("#FFFFFF"))
            btn2.setBackgroundColor(Color.parseColor("#FFFFFF"))
            btn3.setBackgroundColor(Color.parseColor("#FFFFFF"))
            btn4.setBackgroundColor(Color.parseColor("#FFFFFF"))
            btn5.setBackgroundColor(Color.parseColor("#FFFFFF"))
            btn6.setBackgroundColor(Color.parseColor("#FFFFFF"))
            btn7.setBackgroundColor(Color.parseColor("#FFFFFF"))
            btn8.setBackgroundColor(Color.parseColor("#FFFFFF"))
            btn9.setBackgroundColor(Color.parseColor("#FFFFFF"))

            btn1.text=""
            btn2.text=""
            btn3.text=""
            btn4.text=""
            btn5.text=""
            btn6.text=""
            btn7.text=""
            btn8.text=""
            btn9.text=""

            player1.clear()
            player2.clear()

            activePlayer=1
            btn1.isEnabled=true
            btn2.isEnabled=true
            btn3.isEnabled=true
            btn4.isEnabled=true
            btn5.isEnabled=true
            btn6.isEnabled=true
            btn7.isEnabled=true
            btn8.isEnabled=true
            btn9.isEnabled=true



        }

    }

    fun buClick(view: View){

        val buselected=view as Button
        var cellID=0
        when(buselected.id){

            R.id.btn1 -> cellID=1;
            R.id.btn2 -> cellID=2;
            R.id.btn3 -> cellID=3;
            R.id.btn4 -> cellID=4;
            R.id.btn5 -> cellID=5;
            R.id.btn6 -> cellID=6;
            R.id.btn7 -> cellID=7;
            R.id.btn8 -> cellID=8;
            R.id.btn9 -> cellID=9;

        }

        //Toast.makeText(this,"CELL ID:"+cellID,Toast.LENGTH_SHORT).show()
        playGame(cellID,buselected)
    }

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()

    var activePlayer=1

    private fun playGame(cellID: Int, buselected: Button) {

        if(activePlayer == 1){
            buselected.text="X"
            buselected.setBackgroundColor(Color.parseColor("#CDFFBF"))
            player1.add(cellID)
            activePlayer=2
            var n: Int
            n=player1.size
            for (i in player1){
                Log.d("TAG is",i.toString())
            }
        }
        else{
            buselected.text="0"
            buselected.setBackgroundColor(Color.parseColor("#CC0000"))
            player2.add(cellID)
            activePlayer=1
        }

        buselected.isEnabled=false
        checkWinner()
    }

    private fun checkWinner() {
        var winner=-1


        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }

        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }


        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }



        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        //diagonal
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        if(winner!=-1){
            if(winner==1){
                Toast.makeText(this,"player 1 win the game",Toast.LENGTH_LONG).show()

            }
            else{
                Toast.makeText(this,"player 2 win the game",Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun AutoPlay() {
        val emptyCells=ArrayList<Int>()
        for (cellID in 1..9){
            if(!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIndex]

        var buSelected:Button
        when(cellID){
            1->buSelected=btn1
            2-> buSelected=btn2
            3-> buSelected=btn3
            4-> buSelected=btn4
            5-> buSelected=btn5
            6-> buSelected=btn6
            7-> buSelected=btn7
            8-> buSelected=btn8
            9-> buSelected=btn9
            else -> buSelected = btn1

        }

        playGame(cellID,buSelected)

    }

}
