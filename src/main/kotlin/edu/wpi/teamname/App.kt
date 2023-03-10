package edu.wpi.teamname

import edu.wpi.teamname.services.ServiceModules
import edu.wpi.teamname.services.database.DatabaseService
import edu.wpi.teamname.state.StateModules
import edu.wpi.teamname.views.ControllerModules
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent

class App : Application(), KoinComponent {

    private lateinit var loader: FXMLLoader
    private lateinit var primaryScene: Scene
    override fun init() {
        startKoin { modules(AppModule, ServiceModules, StateModules, ControllerModules) }
        println("init")
        // get singleton from Koin
        loader = get()
        loader.setControllerFactory { KoinJavaComponent.get(it) }
        val db = get<DatabaseService>()
        db.initTable()
    }

    override fun start(primaryStage: Stage) {
        println("start")
        val root: Parent = loader.load(javaClass.getResourceAsStream("views/HomeView.fxml"))
        primaryScene = Scene(AnchorPane())

        primaryStage.scene = primaryScene
        primaryStage.isAlwaysOnTop = true

        primaryScene.root = root

        primaryStage.show()
    }

    override fun stop() {
        println("Shutting Down")
    }
}
