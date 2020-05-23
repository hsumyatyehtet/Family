package dev.hmyh.family

import android.app.Application
import dev.hmyh.family.data.models.impl.ContactModelImpl
import dev.hmyh.family.dummy.getContactList
import dev.hmyh.family.persistance.FamilyDatabase

class FamilyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        ContactModelImpl.init(applicationContext)
        deleteAllContacts()
        prePopulateContacts()
    }

    private fun deleteAllContacts() {
        FamilyDatabase.getInstance(applicationContext)
            .getContactInfoDao()
            .deleteAllContacts()
    }

    private fun prePopulateContacts() {
        FamilyDatabase.getInstance(applicationContext)
            .getContactInfoDao()
            .insertContactInfo(getContactList())
    }
}