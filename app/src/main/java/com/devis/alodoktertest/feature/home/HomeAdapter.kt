package com.devis.alodoktertest.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devis.alodoktertest.R
import com.devis.alodoktertest.core.model.CatMdl
import kotlinx.android.synthetic.main.item_cat_list.view.*

/**
 * Created by devis on 01/07/20
 */

class HomeAdapter(
    private val listCat: List<CatMdl>,
    private val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCat.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bind(listCat[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cat: CatMdl) {
            with(itemView) {
                Glide.with(context)
                    .load(cat.url)
                    .into(iv_cat)

                tv_cat_name.text = cat.name

                setOnClickListener {
                    listener.onItemClickListener(cat)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClickListener(cat: CatMdl)
    }

}