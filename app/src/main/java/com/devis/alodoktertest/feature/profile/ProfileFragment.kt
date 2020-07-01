package com.devis.alodoktertest.feature.profile

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.devis.alodoktertest.BuildConfig
import com.devis.alodoktertest.R
import com.devis.alodoktertest.core.base.BaseFragment
import com.devis.alodoktertest.core.helper.PrefHelper
import com.devis.alodoktertest.core.model.UserMdl
import com.devis.alodoktertest.core.utils.getScreenHeight
import com.devis.alodoktertest.core.utils.getScreenWidth
import kotlinx.android.synthetic.main.fragment_profile.*
import java.util.*

/**
 * Created by devis on 01/07/20
 */

class ProfileFragment : BaseFragment() {

    private lateinit var mAlertDialog: Dialog

    private var userData: UserMdl? = null

    override fun layout(): Int {
        return R.layout.fragment_profile
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAlertDialog = Dialog(mContext)
        userData = PrefHelper(mContext).getUserData()

        initView()
        initViewAction()
    }

    private fun initView() {
        val fullName = userData?.getName().toString()
        val initialName: String? = if (fullName.contains(" ")) {
            val split = fullName.split(" ").dropLastWhile {
                it.isEmpty()
            }.toTypedArray()
            split[0].toUpperCase(Locale.getDefault())[0].toString() + split[1].toUpperCase(Locale.getDefault())[0].toString()
        } else {
            fullName.toUpperCase(Locale.getDefault())[0].toString()
        }

        tv_user_name.text = fullName
        tv_user_email.text = userData?.getEmail()
        tv_user_birth.text = userData?.getDateOfBirth()
        tv_user_phone.text = userData?.getPhoneNumber()

        Glide.with(mContext)
            .load(BuildConfig.AVATAR_URL + initialName)
            .circleCrop()
            .into(iv_user_avatar)
    }

    private fun initViewAction() {
        tv_action_logout.setOnClickListener {
            showLogoutDialog()
        }
    }

    private fun showLogoutDialog() {
        mAlertDialog.setContentView(R.layout.dialog)
        val title = mAlertDialog.findViewById<TextView>(R.id.tv_dialog_title)
        val message = mAlertDialog.findViewById<TextView>(R.id.tv_dialog_message)
        val positiveBtn = mAlertDialog.findViewById<TextView>(R.id.tv_dialog_positive)
        val negativeBtn = mAlertDialog.findViewById<TextView>(R.id.tv_dialog_negative)

        title.text = mContext.resources.getString(R.string.title_confirm_logout)
        message.text = mContext.resources.getString(R.string.text_confirm_logout)
        negativeBtn.text = mContext.resources.getString(R.string.action_cancel)
        positiveBtn.text = mContext.resources.getString(R.string.action_logout)
        negativeBtn.setOnClickListener {
            mAlertDialog.dismiss()
        }
        positiveBtn.setOnClickListener {
            mAlertDialog.dismiss()
            PrefHelper(mContext).clear()
            val actionToLoginActivity = ProfileFragmentDirections.actionProfileToLogin()
            view?.findNavController()?.navigate(actionToLoginActivity)
            requireActivity().finishAffinity()
        }

        mAlertDialog.window!!.setLayout(
            (getScreenWidth(requireActivity()) * .75).toInt(),
            (getScreenHeight(requireActivity()) * .32).toInt())
        mAlertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mAlertDialog.show()
    }

}