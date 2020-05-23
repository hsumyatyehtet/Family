package dev.hmyh.family.mvp.presenters

import androidx.lifecycle.ViewModel
import dev.hmyh.family.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>: BasePresenter<T>, ViewModel() {

    protected lateinit var mView: T

    override fun initPresenter(view: T) {
        mView=view
    }
}