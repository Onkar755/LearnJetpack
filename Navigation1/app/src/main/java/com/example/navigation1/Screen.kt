package com.example.navigation1

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

sealed class Screen(
    val route: String
) {
    object Home : Screen(route = "home_screen")
    object Detail :
        Screen(route = "detail_screen?id={$DETAIL_ARGUMENT_KEY}&name={$DETAIL_ARGUMENT_KEY2}") {
//        fun passId(id: Int = 0): String {
//            return this.route.replace(
//                oldValue = "{$DETAIL_ARGUMENT_KEY}",
//                newValue = id.toString()
//            )
//        }

        fun passNameAndId(id: Int = 0, name: String = "NA"): String {
            return this.route.replace(
                oldValue = "{$DETAIL_ARGUMENT_KEY}&name={$DETAIL_ARGUMENT_KEY2}",
                newValue = "$id&name=$name"
            )
        }
    }

//    object Detail : Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}") {
//        fun passId(id: Int): String {
//            return this.route.replace(
//                oldValue = "{$DETAIL_ARGUMENT_KEY}",
//                newValue = id.toString()
//            )
//        }
//
//        fun passNameAndId(id: Int, name: String): String {
//            return this.route.replace(
//                oldValue = "{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}",
//                newValue = "$id/$name"
//            )
//        }
}
