package dev.hmyh.family.holder

import android.view.View
import dev.hmyh.family.data.vos.ContactVO
import dev.hmyh.family.delegate.ContactListDelegate
import kotlinx.android.synthetic.main.view_holder_contact.view.*

class ContactListViewHolder(itemView: View, val contactListDelegate: ContactListDelegate)
    : BaseViewHolder<ContactVO>(itemView) {

    init {
        setUpContactDetailActivity()
    }

    private fun setUpContactDetailActivity() {
        itemView.setOnClickListener {
            mData?.let {
                contactListDelegate.onTapContact(it)
            }
        }
    }

    override fun bindData(data: ContactVO) {
        mData = data
        itemView.tvName.text = data.contactName
        itemView.tvAddress.text = data.contactAddress
        itemView.tvPhone.text = data.contactPhoneNo

        itemView.ivContact.setImageResource(data.contactPhoto)
    }

}