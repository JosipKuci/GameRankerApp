package com.example.gameranker.data
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
class UserRanksViewModel:ViewModel() {
    private val db = Firebase.firestore
    val rankingsData=mutableStateListOf<userGames>()
    init {
        fetchDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("userrankings")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val usergames = data.toObject(userGames::class.java)
                    if (usergames != null) {
                        usergames.id = data.id
                        rankingsData.add(usergames)
                    }
                }
            }


    }
    fun fetchData()
    {
        rankingsData.removeAll(rankingsData)
        fetchDatabaseData()
    }
    fun updateList(usergames:userGames) {
        db.collection("userrankings")
            .document(usergames.id)
            .set(usergames)
    }
    fun addList(usergames:userGames)
    {
        db.collection("userrankings")
            .add(usergames)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding list", e)
            }
    }
}
