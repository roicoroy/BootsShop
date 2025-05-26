package org.goiaba.boot.shop

import com.mmk.kmpnotifier.permission.permissionUtil
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import bootsshop.composeapp.generated.resources.Res
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize
import org.goiaba.boots.shop.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )

        super.onCreate(savedInstanceState)

//        NotifierManager.initialize(
//            configuration = NotificationPlatformConfiguration.Android(
//                notificationIconResId = com.google.firebase.appcheck.interop.R.drawable.common_google_signin_btn_icon_light_normal,
//                showPushNotification = true,
//            )
//        )
//
//        val permissionUtil by permissionUtil()
//        permissionUtil.askNotificationPermission()

//        initializeKoin(
//            config = {
//                androidContext(this@MainActivity)
//            }
//        )
//        Firebase.initialize(context = this)

        setContent {
            App()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val uri = intent.data

        val isSuccess = uri?.getQueryParameter("success")
        val isCancelled = uri?.getQueryParameter("cancel")
        val token = uri?.getQueryParameter("token")
//
//        PreferencesRepository.savePayPalData(
//            isSuccess = isSuccess?.toBooleanStrictOrNull(),
//            error = if (isCancelled == "null") null
//            else "Payment has been canceled.",
//            token = token
//        )
//        intentHandler.navigateToPaymentCompleted(
//            isSuccess = isSuccess?.toBooleanStrictOrNull(),
//            error = if (isCancelled == "null") null
//            else "Payment has been canceled.",
//            token = token
//        )
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
//    App()
//}