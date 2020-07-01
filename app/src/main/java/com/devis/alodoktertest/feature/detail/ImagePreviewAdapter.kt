package com.devis.alodoktertest.feature.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.devis.alodoktertest.R
import com.devis.alodoktertest.core.model.CatTypeMdl
import kotlinx.android.synthetic.main.item_image_preview.view.*

/**
 * Created by devis on 01/07/20
 */

class ImagePreviewAdapter(
    private val context: Context,
    private val itemList: List<CatTypeMdl>
) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun getCount(): Int {
        return itemList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_image_preview, container, false)
        Glide.with(context)
            .load(itemList[position].url)
            .into(layout.iv_image_preview)

        container.addView(layout, 0)

        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}