package com.example.navigation1.navigation

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

const val AUTHENTICATION_ROUTE = "authentication"
const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"

sealed class Screen(
    val route: String
) {
    object Home : Screen(route = "home_screen")
    object Detail :
        Screen(route = "detail_screen?id={$DETAIL_ARGUMENT_KEY}&name={$DETAIL_ARGUMENT_KEY2}") {
        fun passNameAndId(id: Int = 0, name: String = "NA"): String {
            return this.route.replace(
                oldValue = "{$DETAIL_ARGUMENT_KEY}&name={$DETAIL_ARGUMENT_KEY2}",
                newValue = "$id&name=$name"
            )
        }
    }

    object SignUp : Screen(route = "sign_up_screen")
    object Login : Screen(route = "login_screen")
}
