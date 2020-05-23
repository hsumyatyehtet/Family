package dev.hmyh.family.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import dev.hmyh.family.data.models.impl.ContactModelImpl
import dev.hmyh.family.data.vos.ContactVO
import dev.hmyh.family.mvp.presenters.AbstractBasePresenter
import dev.hmyh.family.mvp.presenters.MainPresenter
import dev.hmyh.family.mvp.views.MainView

class MainPresenterImpl: AbstractBasePresenter<MainView>(),MainPresenter {

    private val mContactModel = ContactModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mContactModel.getAllContactInfo()
            .observe(owner, Observer {
                mView.showAllContactInfo(it)
            })
    }

    override fun onTapContact(contact: ContactVO) {
        mView.navigateToContactDetail(contactId = contact.id)
    }

}