package com.devis.alodoktertest.feature.home

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.devis.alodoktertest.R
import com.devis.alodoktertest.core.base.BaseFragment
import com.devis.alodoktertest.core.model.CatMdl
import com.devis.alodoktertest.core.model.CatsMdl
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by devis on 01/07/20
 */

class HomeFragment : BaseFragment() {

    private lateinit var mAdapter: HomeAdapter

    override fun layout(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val gridLayoutManager = GridLayoutManager(mContext, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(p0: Int): Int {
                return 1
            }
        }
        mAdapter = HomeAdapter(CatsMdl().getAllCats(), object : HomeAdapter.OnItemClickListener {
            override fun onItemClickListener(cat: CatMdl) {
                val actionToDetailActivity = HomeFragmentDirections.actionHomeToDetail()
                actionToDetailActivity.data = cat
                view?.findNavController()?.navigate(actionToDetailActivity)
            }
        })
        rv_list_cat.apply {
            hasFixedSize()
            layoutManager = gridLayoutManager
            adapter = mAdapter
        }
    }

}