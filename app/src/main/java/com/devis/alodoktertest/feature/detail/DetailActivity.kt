package com.devis.alodoktertest.feature.detail

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.devis.alodoktertest.R
import com.devis.alodoktertest.core.base.BaseActivity
import com.devis.alodoktertest.core.model.CatMdl
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar_transparent.*

/**
 * Created by devis on 01/07/20
 */

class DetailActivity : BaseActivity() {

    private var mCatMdl: CatMdl? = null

    override fun layout(): Int {
        return R.layout.activity_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mCatMdl = intent.getSerializableExtra("data") as CatMdl

        initToolbar()
        initViewPager()
    }

    private fun initToolbar() {
        tv_toolbar_title.text = mCatMdl?.name
        toolbar.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_back_light))
    }

    private fun initViewPager() {
        val adapter = ImagePreviewAdapter(this, mCatMdl?.listCatType!!)
        vp_image_preview.adapter = adapter
        cpi_image_preview.setViewPager(vp_image_preview)
    }

}