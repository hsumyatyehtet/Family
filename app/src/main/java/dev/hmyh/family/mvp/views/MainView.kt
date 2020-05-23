package dev.hmyh.family.mvp.views

import dev.hmyh.family.data.vos.ContactVO

interface MainView: BaseView {

    fun showAllContactInfo(contactList: List<ContactVO>)
    fun navigateToContactDetail(contactId: Int)
}