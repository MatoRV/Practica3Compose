package com.example.practica3_matoramosvictor.screens.reserva

import android.content.ContentValues
import com.example.practica3_matoramosvictor.modelo.DataReserva
import com.google.firebase.firestore.FirebaseFirestore
import android.util.Log

class ReservaFirestore {

    fun subirReserva(reserva: DataReserva) {
        val db = FirebaseFirestore.getInstance()
        db.collection("reservas")
            .add(reserva)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG,"Reserva añadida : ${documentReference.id}")
            }
            .addOnFailureListener {error ->
                Log.d(ContentValues.TAG,"Error al reservar : $error")
            }
    }
}