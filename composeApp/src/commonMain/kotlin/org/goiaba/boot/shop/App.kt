package org.goiaba.boot.shop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import bootsshop.composeapp.generated.resources.Res
import bootsshop.composeapp.generated.resources.compose_multiplatform
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import com.nutrisport.navigation.SetupNavGraph
import org.goiaba.boots.shop.auth.AuthScreen
import org.goiaba.boots.shop.auth.TestScreen
import org.goiaba.boots.shop.shared.Constants
import kotlin.text.Typography.amp

val typography =
    Typography(
        displaySmall = TextStyle(fontWeight = FontWeight.W100, fontSize = 96.sp),
        labelLarge = TextStyle(fontWeight = FontWeight.W600, fontSize = 14.sp)
    )

val shapes = Shapes(extraSmall = RoundedCornerShape(3.0.dp), small = RoundedCornerShape(6.0.dp))

@Composable
@Preview
fun App() {

    SetupNavGraph()

//    MaterialTheme(typography = typography) {
//        var showContent by remember { mutableStateOf(false) }
//        var appReady by remember { mutableStateOf(false) }
//
//        Column(
//            modifier = Modifier
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(
//                onClick = { showContent = !showContent }
//            ) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//
//        }
//    }
}