package com.waseefakhtar.doseapp.feature.medicationconfirm.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.waseefakhtar.doseapp.core.navigation.DoseNavigationDestination
import com.waseefakhtar.doseapp.feature.medicationconfirm.MedicationConfirmRoute

object MedicationConfirmDestination : DoseNavigationDestination {
    override val route = "medication_confirm_route"
    override val destination = "medication_confirm_destination"
}

fun NavGraphBuilder.medicationConfirmGraph(bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>, onBackClicked: () -> Unit, navigateToHome: () -> Unit) {
    composable(route = MedicationConfirmDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = false
            fabVisibility.value = false
        }
        MedicationConfirmRoute(onBackClicked, navigateToHome)
    }
}