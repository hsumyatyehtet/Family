package dev.hmyh.family.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.hmyh.family.R
import dev.hmyh.family.data.vos.ContactVO
import dev.hmyh.family.delegate.ContactListDelegate
import dev.hmyh.family.holder.ContactListViewHolder

class ContactListAdapter(private val contactListListDelegate: ContactListDelegate)
    : BaseRecyclerAdapter<ContactListViewHolder, ContactVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_contact,parent,false)
        return ContactListViewHolder(itemView,contactListListDelegate)
    }

}