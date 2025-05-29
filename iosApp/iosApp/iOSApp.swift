import Firebase
import FirebaseCore
import FirebaseAuth
//import FirebaseMessaging
import GoogleSignIn
// import shared
import SwiftUI

@main
struct iOSApp: App {
    // @UIApplicationDelegateAdaptor(AppDelegate.self) var delegate
    
    var body: some Scene {
        WindowGroup {
            // FirebaseApp.configure()
            ContentView().onOpenURL(perform: { url in
                         GIDSignIn.sharedInstance.handle(url)
                     })
        }
    }
}


class AppDelegate: NSObject, UIApplicationDelegate {

    func application(
        _ app: UIApplication,
        open url: URL, options: [UIApplication.OpenURLOptionsKey : Any] = [:]
    ) -> Bool {

        // FirebaseApp.configure()

        var handled: Bool

        handled = GIDSignIn.sharedInstance.handle(url)
        if handled {
            return true
        }

        // Handle other custom URL types.

        // If not handled by this app, return false.
        return false
    }


}
