package com.waseefakhtar.doseapp.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.waseefakhtar.doseapp.ui.theme.Pink40
import kotlinx.coroutines.launch

class SnackBarUtil {

    companion object {
        @Composable
        fun SnackbarWithoutScaffold(
            message: String,
            showSb: Boolean,
            openSnackbar: (Boolean) -> Unit
        ) {
            val snackState = remember { SnackbarHostState() }
            val snackScope = rememberCoroutineScope()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(bottom = 76.dp)
                    .zIndex(10f)
                ,
                contentAlignment = Alignment.BottomCenter
            ) {
                SnackbarHost(
                    modifier = Modifier,
                    hostState = snackState
                ) {
                    Snackbar(
                        snackbarData = it,
                        containerColor = Pink40,
                        contentColor = androidx.compose.ui.graphics.Color.White
                    )
                }

            }

            if (showSb) {
                LaunchedEffect(Unit) {
                    snackScope.launch {
                        snackState.showSnackbar(message)
                        openSnackbar(false)
                    }
                }
            }
        }

    }

}
