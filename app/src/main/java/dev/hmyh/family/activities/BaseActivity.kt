package dev.hmyh.family.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dev.hmyh.family.mvp.presenters.AbstractBasePresenter
import dev.hmyh.family.mvp.views.BaseView

abstract class BaseActivity: AppCompatActivity(),BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    inline fun <reified T: AbstractBasePresenter<W>,reified W: BaseView> getPresenter(): T{
        val presenter = ViewModelProviders.of(this).get(T::class.java)
        if (this is W)presenter.initPresenter(this)
        return presenter
    }
}