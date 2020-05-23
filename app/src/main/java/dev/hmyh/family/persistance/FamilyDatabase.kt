package dev.hmyh.family.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.hmyh.family.data.vos.ContactVO
import dev.hmyh.family.persistance.daos.ContactDao
import dev.hmyh.family.utils.FAMILY_DB

@Database(entities = [ContactVO::class], version = 2, exportSchema = false)
abstract class FamilyDatabase : RoomDatabase() {

    abstract fun getContactInfoDao(): ContactDao

    companion object {
        private var instance: FamilyDatabase? = null

        fun getInstance(context: Context): FamilyDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }


        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, FamilyDatabase::class.java, FAMILY_DB)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }
}