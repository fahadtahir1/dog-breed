package com.arbisoft.dogbreedsearch.ui.navigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.arbisoft.dogbreedsearch.BR
import com.arbisoft.dogbreedsearch.R
import com.arbisoft.dogbreedsearch.databinding.ActivityMainBinding
import com.arbisoft.dogbreedsearch.utils.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override val viewModel: MainViewModel by viewModels()

    override fun getBindingVariable(): Int = BR._all
}