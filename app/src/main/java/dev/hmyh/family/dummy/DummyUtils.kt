package dev.hmyh.family.dummy

import dev.hmyh.family.R
import dev.hmyh.family.data.vos.ContactVO

fun getContactList(): List<ContactVO>{

//    return listOf(
//        ContactVO(1,"Htay Aung","09254726192","Phyu",R.mipmap.htay_aung),
//        ContactVO(2,"Hsu Myat Ye Htet","09254726191","Yangon", R.drawable.hmyh_pp),
//        ContactVO(3,"Aung Kyaw Hein","09222333444","Yangon",R.mipmap.akh)
//    )

    val contactOne = ContactVO()
    contactOne.contactName = "Htay Aung"
    contactOne.contactAddress = "Phyu"
    contactOne.contactPhoneNo= "09254726192"
    contactOne.contactPhoto = R.mipmap.htay_aung

    val contactHmyh = ContactVO()
    contactHmyh.contactName = "Hsu Myat Ye Htet"
    contactHmyh.contactAddress = "Yangon"
    contactHmyh.contactPhoneNo= "09254726191"
    contactHmyh.contactPhoto = R.drawable.hmyh_pp

    val contactAKH = ContactVO()
    contactAKH.contactName = "Aung Kyaw Hein"
    contactAKH.contactAddress = "Yangon"
    contactAKH.contactPhoneNo= "09427821488"
    contactAKH.contactPhoto = R.mipmap.akh

    return arrayListOf(contactOne,contactHmyh,contactAKH)
}

