package com.mindvalley.downloader.userInformation.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.mindvalley.test.BR
import com.mindvalley.test.R
import com.mindvalley.downloader.base.mvvm.BaseActivityMVVM
import com.mindvalley.downloader.userInformation.adapter.UserInformationAdapter
import com.mindvalley.downloader.userInformation.viewmodel.UserInformationViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.view.animation.OvershootInterpolator
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator


class MainActivity : BaseActivityMVVM<com.mindvalley.test.databinding.ActivityMainBinding, UserInformationViewModel>(),
    SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        getViewModel().fetchUserInformation()
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBindingViewModel(): UserInformationViewModel {
        return ViewModelProviders.of(this).get(UserInformationViewModel::class.java)
    }

    private lateinit var adapter: UserInformationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        initRecyclerView()
        getViewModel().userInformationLiveData.observe(this, Observer {
            it?.let { list -> adapter.submitList(list) }
            pullToRefresh.isRefreshing = false
        })

        pullToRefresh.setOnRefreshListener(this)
        pullToRefresh.isRefreshing = true
        getViewModel().fetchUserInformation()
    }

    private fun initRecyclerView(){
        recyclerview.addItemDecoration(DividerItemDecoration(this, (recyclerview.layoutManager as LinearLayoutManager).orientation))
        recyclerview.itemAnimator = SlideInUpAnimator().apply { setInterpolator(OvershootInterpolator()) }
        recyclerview.itemAnimator?.apply {
            addDuration = 400
            removeDuration = 400
            moveDuration = 400
            changeDuration = 400
        }
        adapter = UserInformationAdapter()
        recyclerview.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
