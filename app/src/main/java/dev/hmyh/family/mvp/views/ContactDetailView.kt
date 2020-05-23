package dev.hmyh.family.mvp.views

import dev.hmyh.family.data.vos.ContactVO

interface ContactDetailView : BaseView{
    fun displayContactInfoDetail(contactInfo: ContactVO)
    fun navigateToMainActivity()
}