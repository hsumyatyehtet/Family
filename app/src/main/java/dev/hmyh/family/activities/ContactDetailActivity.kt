package dev.hmyh.family.activities

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import dev.hmyh.family.R
import dev.hmyh.family.data.vos.ContactVO
import dev.hmyh.family.mvp.presenters.ContactDetailPresenter
import dev.hmyh.family.mvp.presenters.impl.ContactDetailPresenterImpl
import dev.hmyh.family.mvp.views.ContactDetailView
import kotlinx.android.synthetic.main.activity_contact_detail.*
import kotlinx.android.synthetic.main.view_holder_contact.*

class ContactDetailActivity : BaseActivity(),ContactDetailView {

    companion object {

        private const val EXTRA_CONTACT_ID = "dev.hmyh.family.activities.extra_contact_id"

        fun newIntent(context: Context, contactId: Int): Intent {
            val intent = Intent(context, ContactDetailActivity::class.java)
            intent.putExtra(EXTRA_CONTACT_ID, contactId)
            return intent
        }
    }

    private lateinit var mPresenter: ContactDetailPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_contact_detail)

        setUpPresenter()

        val contactId = intent.getIntExtra(EXTRA_CONTACT_ID, 0)
        mPresenter.onContactDetailUiReady(this,contactId)

        setUpListener()
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<ContactDetailPresenterImpl,ContactDetailView>()
    }

    override fun displayContactInfoDetail(contactInfo: ContactVO) {
        Glide.with(this)
            .load(contactInfo.contactPhoto)
            .circleCrop()
            .into(ivProfile)
        tvDetailName.text = contactInfo.contactName
        tvDetailPhone.text = contactInfo.contactPhoneNo
        tvDetailAddress.text = contactInfo.contactAddress

        rlPhoneNumber.setOnClickListener {

            val number = contactInfo.contactPhoneNo.trim()
            val intentDial = Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+Uri.encode(number)))
            startActivity(intentDial)

        }
    }

    private fun setUpListener() {
        ivBackArrow.setOnClickListener {
            mPresenter.onTapBackArrow()
        }
    }

    override fun navigateToMainActivity() {
        finish()
    }
}