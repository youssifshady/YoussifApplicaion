package com.example.youssifapplicaion.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.youssifapplicaion.fragment.ShowdiwanFragment.PoemName1
import com.example.youssifapplicaion.activity.DrawbleMainActivity.*
import com.example.youssifapplicaion.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import com.r0adkll.slidr.model.SlidrInterface


class CustomizingpoemsFragmet : Fragment() {

    lateinit var  floatingActionButton : FloatingActionButton

    var poemname1: EditText? = null
    var poembody1: EditText? = null

//    var PomeName1: String? = null

    private var slidrInterface: SlidrInterface? = null

    var database: FirebaseDatabase? = null
    var databaseReference1: DatabaseReference? = null

    var tstnotification: TextView? = null

    var TAG = "OptionsofthepoetonthePoemKotlin"

    var savebtn: Button? = null
    var updatebtn: Button? = null
    var deletebtn: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_optionsofthe_poet_onthe_poem_k, container, false)

        floatingActionButton = view.findViewById(R.id.exit_to_showdiwan)

        savebtn = view.findViewById(R.id.savetofirebasek)
        updatebtn = view.findViewById(R.id.updatedataofirebasek)
        deletebtn = view.findViewById(R.id.deletedataofirebasek)
        savebtn!!.setOnClickListener { savetofirebasek() }
        updatebtn!!.setOnClickListener { updatedataofirebasek() }
        deletebtn!!.setOnClickListener { deletedataofirebasek() }

        floatingActionButton!!.setOnClickListener{
            val showdiwanFragment = ShowdiwanFragment()
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_optionsofpetonthe_poemK, showdiwanFragment).commit()
        }

        poemname1 = view.findViewById(R.id.nameof_poem)
        poembody1 = view.findViewById(R.id.number_edit_text)
        database = FirebaseDatabase.getInstance()
//        PomeName1 = intent.getStringExtra("poemName")

        if (diwan == 11) {
            databaseReference1 = database!!.getReference().child("?????????????? ??????????")

        } else if (diwan == 22) {
            databaseReference1 = database!!.getReference().child("?????????????? ????????????")

        }


        if (PoemName1 != null) {
            databaseReference1!!.child(PoemName1).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot1: DataSnapshot) {

                    val poemname = dataSnapshot1.child("poemname").value.toString()
                    val poembody = dataSnapshot1.child("poembody").value.toString()
                    poemname1!!.setText(poemname)
                    poembody1!!.setText(poembody)

                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })

        } else if (PoemName1 == null) {
            Toast.makeText(GLOBALCONTEXT, "?????????? ?????????? ??????????..", Toast.LENGTH_SHORT).show()
        }


        return view
    }

    fun savetofirebasek() {
        if (Networkconnection == 0) {
            Toast.makeText(GLOBALCONTEXT, "???????? ???? ???????????? ??????????????????", Toast.LENGTH_SHORT).show()
        } else if (Networkconnection == 1) {
            val poemname = poemname1!!.text.toString().trim { it <= ' ' }
            val poembody = poembody1!!.text.toString().trim { it <= ' ' }
            if (PoemName1 == null) {
                if (TextUtils.isEmpty(poemname) || TextUtils.isEmpty(poembody)) {
                    Toast.makeText(GLOBALCONTEXT, "?????? ???????? ?????????? ???????? ???????????????? ???????? ??????????????", Toast.LENGTH_SHORT).show()
                } else {
                    databaseReference1!!.child(poemname).child("poemname").setValue(poemname)
                    databaseReference1!!.child(poemname).child("poembody").setValue(poembody)
//                    val intent = Intent(GLOBALCONTEXT, Showdiwan::class.java)
//                    intent.putExtra("AllowToShowAddButt", 1)
//                    intent.putExtra("Allowshowpoetpass", 1)
//                    startActivity(intent)
                    val showdiwanFragment = ShowdiwanFragment()
                    val transaction = fragmentManager!!.beginTransaction()
                    transaction.replace(R.id.fragment_optionsofpetonthe_poemK, showdiwanFragment).commit()
                    Toast.makeText(GLOBALCONTEXT, "?????? ???????? ?????????????? ??????????...", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(GLOBALCONTEXT, "???????????????? ???????????? ????????????", Toast.LENGTH_SHORT).show()
            }


        }
    }

    fun deletedataofirebasek() {
        if (Networkconnection == 0) {
            Toast.makeText(GLOBALCONTEXT, "???????? ???? ???????????? ??????????????????", Toast.LENGTH_SHORT).show()
        } else if (Networkconnection == 1) {
            if (PoemName1 != null) {

                databaseReference1!!.child(PoemName1).child("poemname").setValue(null)
                databaseReference1!!.child(PoemName1).child("poembody").setValue(null)
                Toast.makeText(GLOBALCONTEXT, "?????? ???????? ?????????????? ??????????...", Toast.LENGTH_SHORT).show()
                val showdiwanFragment = ShowdiwanFragment()
                val transaction = fragmentManager!!.beginTransaction()
                transaction.replace(R.id.fragment_optionsofpetonthe_poemK, showdiwanFragment).commit()

            } else {
                Toast.makeText(GLOBALCONTEXT, "???? ???????? ???????????? ???????? ??????????", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updatedataofirebasek() {
        if (Networkconnection == 0) {
            Toast.makeText(GLOBALCONTEXT, "???????? ???? ???????????? ??????????????????", Toast.LENGTH_SHORT).show()
        } else if (Networkconnection == 1) {
            val poemname = poemname1!!.text.toString().trim { it <= ' ' }
            val poembody = poembody1!!.text.toString().trim { it <= ' ' }
            if (PoemName1 != null) {
                if (TextUtils.isEmpty(poemname) || TextUtils.isEmpty(poembody)) {
                    Toast.makeText(GLOBALCONTEXT, "?????? ???????? ?????????? ???????? ???????????????? ???????? ??????????????", Toast.LENGTH_SHORT).show()
                } else {
                    databaseReference1!!.child("poemname").setValue(null)
                    databaseReference1!!.child("poembody").setValue(null)
                    databaseReference1!!.child(poemname).child("poemname").setValue(poemname)
                    databaseReference1!!.child(poemname).child("poembody").setValue(poembody)

                    Toast.makeText(GLOBALCONTEXT, "?????? ???????? ?????????????? ??????????...", Toast.LENGTH_SHORT).show()
                    val showdiwanFragment = ShowdiwanFragment()
                    val transaction = fragmentManager!!.beginTransaction()
                    transaction.replace(R.id.fragment_optionsofpetonthe_poemK, showdiwanFragment).commit()


                }
            } else {
                Toast.makeText(GLOBALCONTEXT, "???? ???????? ???????????? ???????? ??????????????", Toast.LENGTH_SHORT).show()
            }
        }


    }


/*
//                databaseReference1!!.child(PomeName1!!).setValue(null)
//                val builder2 = AlertDialog.Builder(GLOBALCONTEXT)
//
//                builder2.setMessage("???? ?????? ?????????? ?????? ???????? ???????????? ???? ????????????????")
//                builder2.setPositiveButton("??????") { dialog, which ->
//                    databaseReference1!!.child("poemname").setValue(null)
//                    databaseReference1!!.child("poembody").setValue(null)
//                    Toast.makeText(GLOBALCONTEXT, "?????? ???????? ?????????????? ??????????...", Toast.LENGTH_SHORT).show()
//                    val showdiwanFragment = ShowdiwanFragment()
//                    val transaction = fragmentManager!!.beginTransaction()
//                    transaction.replace(R.id.fragment_optionsofpetonthe_poemK, showdiwanFragment).commit()
//                    AllowToShowButton = 1
//                    intshowpoetpass = 1
//                }
////                builder2.setNegativeButton("????") { dialog, which -> }
//                val alertDialog = builder2.create()
//                alertDialog.show()




                val builder = AlertDialog.Builder(GLOBALCONTEXT)
                builder.setTitle("?????? ??????????????")
                builder.setMessage("???? ?????? ?????????? ?????? ???????? ???????????? ???? ????????????????")
                builder.setPositiveButton("??????") { dialog, which ->

                    dialog.dismiss()
                }
                builder.setNegativeButton("????") { dialog, which ->

                    dialog.dismiss()
                }
                val alert = builder.create()
                alert.show()
*/

}