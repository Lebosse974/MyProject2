package com.example.myproject2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.connection)
        val test = findViewById<Button>(R.id.test)
        val mail = findViewById<EditText>(R.id.ETmail)
        val mdp = findViewById<EditText>(R.id.ETmdp)
        val creercompte = findViewById<Button>(R.id.nvcompte)
        val deco = findViewById<Button>(R.id.deco)
        val supprimer = findViewById<Button>(R.id.supp)
        val refresh = findViewById<Button>(R.id.refresh)
        auth = Firebase.auth



    //------------------------------  Ptit boutton test pour pas se co -----------------------------
        test.setOnClickListener{
            val fintent = Intent(this,pendu::class.java)
            startActivity(fintent)
        }


    //----------------------------------------------------------------------------------------------
    // ------------------------------ BTN CONNECTION -----------------------------------------------

        btn.setOnClickListener{

            val email = mail.text.toString()
            val password = mdp.text.toString()

            if ( mdp.text.length < 6){

                Toast.makeText(baseContext, " veuillez entrer 6 caractère minimum",
                    Toast.LENGTH_SHORT).show()
            }

            else {

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                baseContext, " connection réussie  ",
                                Toast.LENGTH_SHORT
                            ).show()

                            val fintent = Intent(this, pendu::class.java)
                            startActivity(fintent)

                        } else {
                            Toast.makeText(
                                baseContext, " oua plane un place chef ",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    //----------------------------------------------------------------------------------------------
    //  -------------------------------- BTN CREE COMPTE -------------------------------------------


        creercompte.setOnClickListener{

            val email = mail.text.toString()
            val password = mdp.text.toString()

                     if ( mdp.text.length < 6){

                        Toast.makeText(baseContext, " veuillez entrer 6 caractère minimum",
                            Toast.LENGTH_SHORT).show()
                    }

                    else {

                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {

                                    Toast.makeText(baseContext, " Compte crée  ",
                                        Toast.LENGTH_SHORT).show()

                                }

                                else{
                                    Toast.makeText(baseContext, " oua plane un place chef ",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                    }
        }
    //----------------------------------------------------------------------------------------------
    //-------------------------------- BTN DECONNECTION --------------------------------------------


        deco.setOnClickListener {
            auth.signOut()
            Toast.makeText(baseContext, " Deconnection ",
                Toast.LENGTH_SHORT).show()
        }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- BTN REFRESH -------------------------------------------------


        refresh.setOnClickListener {
            Toast.makeText(baseContext, " page actualiser ",
                Toast.LENGTH_SHORT).show()
            val refreshintent = Intent(this,MainActivity::class.java)
            startActivity(refreshintent)
        }

    //----------------------------------------------------------------------------------------------
    //----------------------------------- BTN SUPPRIMER --------------------------------------------

        supprimer.setOnClickListener {

            val user = Firebase.auth.currentUser!!

            user.delete()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(baseContext, " compte supprimer  ",
                            Toast.LENGTH_SHORT).show()



                    }
                }
        }
    }
}