package com.example.napptilusandroidchallenge.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface OompaLoompaDao {

    @Query("select * from databaseoompaloompa")
    fun getOompaLoompas(): LiveData<List<DataBaseOompaLoompa>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(oompaLoompas: List<DataBaseOompaLoompa>)

}

@Database(entities = [DataBaseOompaLoompa::class], version = 1)
abstract class OompaLoompaDatabase: RoomDatabase() {
    abstract val oompaLoompaDao: OompaLoompaDao
}

private lateinit var INSTANCE: OompaLoompaDatabase

fun getDataBase(context: Context): OompaLoompaDatabase {
    synchronized(OompaLoompaDatabase::class.java) {
        if(!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                    OompaLoompaDatabase::class.java,
            "oompaloompas").build()
        }
    }
    return INSTANCE
}