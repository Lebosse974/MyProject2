package com.example.myproject2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class pendu : AppCompatActivity() {




    // ---------  INITIALISATION DU COMPTEUR ET DU MAX ERREUR ----------------------------------


    var nb = 0
    val maxErreur = 7


    // ------------------------------------------------------------------------------------------



    private lateinit var database : DatabaseReference
    //private lateinit var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendu)


        // -------- INITIALISATION DE L'IMG + LES LETTRE FAUX + LES LETTRE A TROUVER -------------


        val pendue = findViewById<ImageView>(R.id.pendu)
        val lettreFalse = findViewById<TextView>(R.id.lettreFalse)
        val lettreTrouver = findViewById<Button>(R.id.underscore)
        val lettreTrouver1 = findViewById<Button>(R.id.underscore1)
        val lettreTrouver2 = findViewById<Button>(R.id.underscore2)
        val lettreTrouver3 = findViewById<Button>(R.id.underscore3)
        val lettreTrouver4 = findViewById<Button>(R.id.underscore4)
        val lettreTrouver5 = findViewById<Button>(R.id.underscore5)


        // --------------------------------------------------------------------------------------





        val monIntent= Intent(this,MainActivity::class.java)


        // -----------------------   MON POP UP DEFEAT +REPLAY -------------------------------------


        val defaite = AlertDialog.Builder(this)
        defaite .setTitle(" OMG BOIII DEFEAT!!! WANNA REPLAY ?")
        defaite .setMessage("U SHOULD TRY THIS SRLY THIS TIME BOII! ")
        defaite .setPositiveButton(" REPLAY ") { dialog, which ->
            Toast.makeText(this,
                " quelle brave type :') ", Toast.LENGTH_SHORT).show()
            startActivity(monIntent)
        }
        defaite .setNegativeButton("HELL NO ") { dialog, which ->
            Toast.makeText(this,
                " ah bah si tu va rejouer !", Toast.LENGTH_SHORT).show()
            startActivity(monIntent)
        }

        // -----------------------------------------------------------------------------------------
        // -----------------------   MON POP UP VICTOIRE +REPLAY -----------------------------------


        val victoire1 = AlertDialog.Builder(this)
        victoire1.setTitle(" VICTORY!! WANNA REPLAY ?")
        victoire1.setMessage("U GOOD BOIII ! ")
        victoire1.setPositiveButton(" REPLAY ") { dialog, which ->
            Toast.makeText(this,
                " quelle brave type :') ", Toast.LENGTH_SHORT).show()
            startActivity(monIntent)
        }
        victoire1.setNegativeButton("HELL NO ") { dialog, which ->
            Toast.makeText(this,
                " ah bah si tu va rejouer !", Toast.LENGTH_SHORT).show()
            startActivity(monIntent)
        }


        // -----------------------------------------------------------------------------------------
        // ------------- FONCTION POUR METTRE LES LETTRE A TROUVER A "_" AU  DEBUT -----------------


        fun commencerlapartie (){
            lettreTrouver.text = "_"
            lettreTrouver1.text = "_"
            lettreTrouver2.text = "_"
            lettreTrouver3.text = "_"
            lettreTrouver4.text = "_"
            lettreTrouver5.text = "_"
            lettreFalse.text = " "


        }
        commencerlapartie()
        // -----------------------------------------------------------------------------------------
       //-----------------------  FONCTION CHANGE IMAGE POUR  CHAQUE ERREUR ------------------------

        fun changeImg (){
            if (nb==1){
                pendue.setImageResource(R.drawable.pendue1)
            }
            else if (nb==2){
                pendue.setImageResource(R.drawable.pendue2)

            }

            else if (nb==3){
                pendue.setImageResource(R.drawable.pendue3)

            }

            else if (nb==4){
                pendue.setImageResource(R.drawable.pendue4)

            }
            else if (nb==5){
                pendue.setImageResource(R.drawable.pendue5)

            }
            else if (nb==6){
                pendue.setImageResource(R.drawable.pendue55)

            }
            else if (nb==7){
                pendue.setImageResource(R.drawable.pendue6)

            }

        }

        // -----------------------------------------------------------------------------------------
        //------------------------  Fonction victoire & FIN DE PARTIE ( DEFAITE) -------------------

        fun victoire (){
            if  ( lettreTrouver.text  == "E" && lettreTrouver1.text == "M"
                && lettreTrouver2.text == "P" && lettreTrouver3.text == "I"
                && lettreTrouver4.text == "R" && lettreTrouver5.text == "E") {

                Toast.makeText(this,
                    " daaang gg ! ", Toast.LENGTH_SHORT).show()

                victoire1.show()
            }
        }

        fun fin(){
            if (nb==maxErreur){

                Toast.makeText(this,
                    " perdue! ", Toast.LENGTH_SHORT).show()

                defaite.show()
            }
        }

        // -----------------------------------------------------------------------------------------
        // ----- INITIALISATION DES BOUTTON + COMPTEUR CP ( NB ERREUR) -----------------------------

        val btna = findViewById<Button>(R.id.a)
        val btnb = findViewById<Button>(R.id.b)
        val btnc = findViewById<Button>(R.id.c)
        val btnd = findViewById<Button>(R.id.d)
        val btne = findViewById<Button>(R.id.e)
        val btnf = findViewById<Button>(R.id.f)
        val btng = findViewById<Button>(R.id.g)
        val btnh = findViewById<Button>(R.id.h)
        val btni = findViewById<Button>(R.id.i)
        val btnj = findViewById<Button>(R.id.j)
        val btnk = findViewById<Button>(R.id.k)
        val btnl = findViewById<Button>(R.id.l)
        val btnm = findViewById<Button>(R.id.m)
        val btnn = findViewById<Button>(R.id.n)
        val btno = findViewById<Button>(R.id.o)
        val btnp = findViewById<Button>(R.id.p)
        val btnq = findViewById<Button>(R.id.q)
        val btnr = findViewById<Button>(R.id.r)
        val btns = findViewById<Button>(R.id.s)
        val btnt = findViewById<Button>(R.id.t)
        val btnu = findViewById<Button>(R.id.u)
        val btnv = findViewById<Button>(R.id.v)
        val btnw = findViewById<Button>(R.id.w)
        val btnx = findViewById<Button>(R.id.x)
        val btny = findViewById<Button>(R.id.y)
        val btnz = findViewById<Button>(R.id.z)
        val cp = findViewById<TextView>(R.id.cp)

        // -----------------------------------------------------------------------------------------




        btna.setOnClickListener{
           //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"a\n "
            nb ++

            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnb.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"b\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnc.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"c\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnd.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"d\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btne.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"e\n"
            lettreTrouver.text = "E"
            lettreTrouver5.text = "E"
            changeImg()
            victoire ()
            fin()

        }

        btnf.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"f\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btng.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"g\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnh.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"h\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btni.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"i\n"
           lettreTrouver3.text = "I"
            changeImg()
            victoire ()
            fin()

        }

        btnj.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"j\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnk.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"k\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnl.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"l\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnm.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"m\n"
            lettreTrouver1.text = "M"
            changeImg()
            victoire ()
            fin()

        }

        btnn.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"n\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btno.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"o\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnp.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"p\n"
           lettreTrouver2.text = "P"
            changeImg()
            victoire ()
            fin()

        }

        btnq.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"q\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnr.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"r\n"
            lettreTrouver4.text = "R"
            changeImg()
            victoire ()
            fin()

        }

        btns.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"s\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnt.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"t\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnu.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"u\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnv.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"v\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnw.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"w\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btnx.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"x\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }

        btny.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"y\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()

        }


        btnz.setOnClickListener{
            //envoyer la valeur string a vers letterfalse et lettre trouver
            lettreFalse.text = lettreFalse.text.toString()+"z\n"
            nb ++
            cp.text = nb.toString()
            changeImg()
            victoire ()
            fin()
        }


    // Recuperer les donner du database


        val motatrouver : String

        database = Firebase.database("https://pendu-c72cc-default-rtdb.europe-west1.firebasedatabase.app/").reference
        val motATrouver = database.child("pendue")
        motATrouver.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(motatrouver: DataSnapshot) {
                for (lettreatrouver in motatrouver.children){
                    val value = motatrouver.getValue<String>()
                    val underscore = value.toString()

                }

            }
            override fun onCancelled( motatrouver: DatabaseError) {
                // Failed to read value
                //Toast.makeText(this,
            // " errror ", Toast.LENGTH_SHORT,).show()



            }
        })


    }
    }

// FAIRE UNE FONCTION QUI EMPECHE DE TAPER PLUSIEUR FOIS LA MEME LETTRE(toast message d'erreur)

// faire un scroll du layout principale lorsque le texte commence à depasse

// remplacer les underscore par les values realtime database

/* initialisser pour chaque bouton une variable identique qui prendra la valeur du numeros de bouton
et si identique a underscore alors function pour remplacer le textatrouver
 */
// remplacer sur les bouton gagnant la fonction qui change directement le text par la fonction nboutton


