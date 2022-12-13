package com.ama.attempt.base

import androidx.navigation.fragment.findNavController
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ama.attempt.frags.Fragment1

@Database (entities = [Item::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object{
        fun getDb(context: Fragment1): MainDb{
            return Room.databaseBuilder(
                context.requireContext(),
                MainDb::class.java,
                "test.db"
            ).build()
        }
    }
}
