package dev.hmyh.family.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.hmyh.family.data.vos.ContactVO

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContactInfo(contactInfo: List<ContactVO>)

    @Query("SELECT * FROM contact_info")
    fun getAllContactInfo(): LiveData<List<ContactVO>>

    @Query("SELECT * FROM contact_info WHERE contact_id = :id")
    fun getContactInfoById(id: Int): LiveData<ContactVO>

    @Query("DELETE FROM contact_info")
    fun deleteAllContacts()
}