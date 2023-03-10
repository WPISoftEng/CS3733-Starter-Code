package edu.wpi.teamname.views

import edu.wpi.teamname.services.ServiceTwo
import edu.wpi.teamname.services.database.DatabaseService
import edu.wpi.teamname.state.HomeState
import java.net.URL
import java.util.*
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.control.Label
import org.koin.core.component.KoinComponent

class HomeController(
    private val db: DatabaseService,
    private val s2: ServiceTwo,
    private val loader: FXMLLoader,
    private val state: HomeState,
) : Initializable, KoinComponent {
    @FXML private lateinit var text: Label
    //
    //    private val db: DatabaseService by inject()
    //    private val s2: ServiceTwo by inject()
    //    private val loader: FXMLLoader by inject()
    //    private val state: HomeState by inject()

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        text.visibleProperty().bind(state.visible)
        text.textProperty().bind(state.text)
    }

    @FXML
    private fun buttonClicked(actionEvent: ActionEvent) {
        state.toggleClicked()
        state.setNode("${db.employeeName}, ${s2.results[state.numClicks % 2]}")
        advanceScene()
    }

    /**
     * Advances to next scene. In this contrived example, the view is the same, but without proper
     * EBC, the text would not toggle correctly.
     */
    private fun advanceScene() {
        val root = loader.load<Parent>(javaClass.getResourceAsStream("HomeView.fxml"))
        text.scene.root = root
    }
}
