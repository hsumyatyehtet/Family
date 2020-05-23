package dev.hmyh.family.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import dev.hmyh.family.data.models.impl.ContactModelImpl
import dev.hmyh.family.mvp.presenters.AbstractBasePresenter
import dev.hmyh.family.mvp.presenters.ContactDetailPresenter
import dev.hmyh.family.mvp.views.ContactDetailView

class ContactDetailPresenterImpl: AbstractBasePresenter<ContactDetailView>(), ContactDetailPresenter {

    private val mContactModel = ContactModelImpl

    override fun onContactDetailUiReady(lifecycleOwner: LifecycleOwner, contactId: Int) {
       mContactModel.getContactById(contactId)
           .observe(lifecycleOwner, Observer {
               it?.let {data ->
                   mView.displayContactInfoDetail(data)
               }
           })
    }

    override fun onTapBackArrow() {
        mView.navigateToMainActivity()
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }
}