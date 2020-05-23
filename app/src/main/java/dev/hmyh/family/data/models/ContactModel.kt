package dev.hmyh.family.data.models

import androidx.lifecycle.LiveData
import dev.hmyh.family.data.vos.ContactVO

interface ContactModel {

    fun getAllContactInfo(): LiveData<List<ContactVO>>
    fun getContactById(contactId: Int): LiveData<ContactVO>
}