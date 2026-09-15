package br.edu.ifsp.scl.sc3035018.stringconcatenator.navigation

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen") // sender
    object ReceiverAddWord: Screen(route = "receiver_add_word_screen")
}