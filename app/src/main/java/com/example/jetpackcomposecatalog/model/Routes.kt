package com.example.jetpackcomposecatalog.model

sealed class Routes(val route: String) {
    object Screen1: Routes("Screen_1")
    object Screen2: Routes("Screen_2")
    object Screen3: Routes("Screen_3")
    object Screen4: Routes("Screen_4/{name}")
    object Screen5: Routes("Screen_5/{numberPage}"){
        fun createUrlRoute(numberPage: Int) = "Screen_5/$numberPage"
    }

}