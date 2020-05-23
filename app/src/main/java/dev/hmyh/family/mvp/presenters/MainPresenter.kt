package dev.hmyh.family.mvp.presenters

import dev.hmyh.family.delegate.ContactListDelegate
import dev.hmyh.family.mvp.views.MainView

interface MainPresenter: BasePresenter<MainView>,ContactListDelegate {

}