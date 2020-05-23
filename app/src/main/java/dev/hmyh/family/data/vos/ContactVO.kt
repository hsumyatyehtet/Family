package dev.hmyh.family.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_info")
class ContactVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    var id: Int = 0

    @ColumnInfo(name = "contact_name")
    var contactName: String = ""

    @ColumnInfo(name = "contact_phone_no")
    var contactPhoneNo: String = ""

    @ColumnInfo(name = "contact_address")
    var contactAddress: String = ""

    @ColumnInfo(name = "contact_photo")
    var contactPhoto: Int = 0
}