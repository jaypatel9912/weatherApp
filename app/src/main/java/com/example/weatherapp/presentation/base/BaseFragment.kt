package com.example.weatherapp.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import com.example.weatherapp.R
import com.example.weatherapp.comman.views.SafetyClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.fragment_base.view.*

@AndroidEntryPoint
abstract class BaseFragment : Fragment(), IBaseFragment {

    override val baseActivity: BaseActivity?
        get() = activity as? BaseActivity

    override val safetyClickListener: SafetyClickListener by lazy { SafetyClickListener() }


    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_base, container, false)
        inflater.inflate(getLayoutId(), rootView.containerContent, true)
        return rootView
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(arguments)
        initActions()
        initViews()
        initActions()
        initObservers()
    }

    override fun onBackPressed() {
    }

    override fun showLoading() {
        loadingView.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loadingView.visibility = View.GONE
    }
}