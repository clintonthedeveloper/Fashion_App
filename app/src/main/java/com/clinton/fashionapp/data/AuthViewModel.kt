package com.clinton.fashionapp.data

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.clinton.fashionapp.Screen
import com.clinton.fashionapp.ui.theme.ROUTE_LOGIN
import com.clinton.fashionapp.ui.theme.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User


class AuthViewModel( var navController: NavHostController,var context:Context) {

    var mAuth: FirebaseAuth

    init {
        mAuth = FirebaseAuth.getInstance()
    }

    @SuppressLint("RestrictedApi")
    fun singup(name: String, email: String, pass: String, confrmpass: String) {

        if (name.isBlank() || email.isBlank() || pass.isBlank() || confrmpass.isBlank()) {

            Toast.makeText(context, "Please input all fields", Toast.LENGTH_LONG).show()
        } else if (pass != confrmpass) {
            Toast.makeText(context, "password do not match", Toast.LENGTH_LONG).show()

        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {

                if(it.isSuccessful) {
                    val userData = com.clinton.fashionapp.model.User(
                        name,
                        email,
                        pass,
                        confrmpass,
                        mAuth.currentUser!!.uid
                    )
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userData).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)
                        }
                    }
                }else{
                    navController.navigate(ROUTE_REGISTER)
                }

            } }

    }
    fun login(email: String,pass: String){


        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {

            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Logged in",Toast.LENGTH_LONG).show()
                navController.navigate(Screen.Product.route)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}