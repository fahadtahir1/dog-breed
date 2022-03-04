package com.arbisoft.dogbreedsearch.ui.navigation

import com.arbisoft.dogbreedsearch.managers.DataManager
import com.arbisoft.dogbreedsearch.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(dataManager: DataManager) : BaseViewModel<MainNavigator>(dataManager) {
}