package edu.wpi.teamname

import javafx.fxml.FXMLLoader
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent

val AppModule = module {
    // FXMLLoader can only be used once. factory creates a new one each time it is requested, and
    // sets up the controller factory correctly to use koin
    factory { FXMLLoader().apply { setControllerFactory { KoinJavaComponent.get(it) } } }
}
