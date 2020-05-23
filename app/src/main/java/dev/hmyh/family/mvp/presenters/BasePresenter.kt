package dev.hmyh.family.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import dev.hmyh.family.mvp.views.BaseView

interface BasePresenter<V: BaseView> {

    fun onUIReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}