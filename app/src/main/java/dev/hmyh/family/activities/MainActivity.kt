package dev.hmyh.family.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.hmyh.family.R
import dev.hmyh.family.adapter.ContactListAdapter
import dev.hmyh.family.data.vos.ContactVO
import dev.hmyh.family.mvp.presenters.MainPresenter
import dev.hmyh.family.mvp.presenters.impl.MainPresenterImpl
import dev.hmyh.family.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView {

    private lateinit var mContactListAdapter: ContactListAdapter
    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpRecyclerView()

        mPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<MainPresenterImpl,MainView>()
    }

    private fun setUpRecyclerView() {

        mContactListAdapter = ContactListAdapter(mPresenter)

        with(rvContact){
            layoutManager = LinearLayoutManager(
                context,RecyclerView.VERTICAL,false
            )
            adapter = mContactListAdapter
        }

       // mContactListAdapter.setNewData(getContactList())
    }

    override fun showAllContactInfo(contactList: List<ContactVO>) {
        mContactListAdapter.setNewData(contactList)
    }

    override fun navigateToContactDetail(contactId: Int) {
        startActivity(ContactDetailActivity.newIntent(this,contactId))
    }

}
