package dev.hmyh.family.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import dev.hmyh.family.mvp.views.ContactDetailView

interface ContactDetailPresenter: BasePresenter<ContactDetailView> {
    fun onContactDetailUiReady(lifecycleOwner: LifecycleOwner,contactId: Int)
    fun onTapBackArrow()
}