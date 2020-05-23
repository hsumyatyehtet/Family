package dev.hmyh.family.data.models

import android.content.Context
import dev.hmyh.family.persistance.FamilyDatabase

abstract class BaseAppModel : BaseModel() {

    protected lateinit var mDatabase: FamilyDatabase

    override fun init(context: Context) {
        initDatabase(context)
    }

    private fun initDatabase(context: Context){
        mDatabase= FamilyDatabase.getInstance(context)
    }
}