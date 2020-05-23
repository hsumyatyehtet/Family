package dev.hmyh.family.data.models.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import dev.hmyh.family.data.models.BaseAppModel
import dev.hmyh.family.data.models.ContactModel
import dev.hmyh.family.data.vos.ContactVO

object ContactModelImpl: ContactModel,BaseAppModel() {


    override fun getAllContactInfo(): LiveData<List<ContactVO>> {
        return Transformations.distinctUntilChanged(
            mDatabase.getContactInfoDao().getAllContactInfo()
        )
    }

    override fun getContactById(contactId: Int): LiveData<ContactVO> {
        return Transformations.distinctUntilChanged(
            mDatabase.getContactInfoDao().getContactInfoById(contactId)
        )
    }

}