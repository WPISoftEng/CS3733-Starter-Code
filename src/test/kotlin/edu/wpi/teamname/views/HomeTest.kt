package edu.wpi.teamname.views

import edu.wpi.teamname.services.ServiceTwo
import edu.wpi.teamname.services.database.DatabaseService
import edu.wpi.teamname.state.HomeState
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.any
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import org.testfx.api.FxAssert
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start

@ExtendWith(ApplicationExtension::class)
class HomeTest : FxRobot() {
    // Mock dependencies
    private val two: ServiceTwo = mock {
        given(it.results).willReturn(listOf("Results 1", "Results 2"))
    }

    private var dbService: DatabaseService = mock {
        given(it.employeeName).willReturn("Wilson Wong")
    }

    private val mockLoader: FXMLLoader = mock()

    private val state = HomeState()

    private val controller: HomeController = HomeController(dbService, two, mockLoader, state)
    private val loader: FXMLLoader = FXMLLoader()

    @Start
    private fun start(stage: Stage) {
        loader.setControllerFactory { controller }
        val sceneRoot: AnchorPane = loader.load(javaClass.getResourceAsStream("HomeView.fxml"))
        given(mockLoader.load<AnchorPane>(any())).willReturn(sceneRoot)
        val primaryScene = Scene(sceneRoot)
        stage.scene = primaryScene
        stage.isAlwaysOnTop = true
        stage.show()
    }

    @Test
    fun testSingleClick() {
        clickOn("Click Me")
        FxAssert.verifyThat("#text") { obj: Node -> obj.isVisible }
    }

    @Test
    fun testDoubleClick() {
        clickOn("Click Me")
        clickOn("Click Me")
        FxAssert.verifyThat("#text") { n: Node -> !n.isVisible }
    }

    @Test
    fun testGetNodes() {
        given(two.results).willReturn(listOf("Expected", "Not expected"))
        clickOn("Click Me")
        FxAssert.verifyThat("Wilson Wong, Expected") { obj: Node -> obj.isVisible }
    }
}
