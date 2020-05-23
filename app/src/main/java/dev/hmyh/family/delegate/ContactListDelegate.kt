package dev.hmyh.family.delegate

import dev.hmyh.family.data.vos.ContactVO

interface ContactListDelegate {

    fun onTapContact(contact: ContactVO)
}