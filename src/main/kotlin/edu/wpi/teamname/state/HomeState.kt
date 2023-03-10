package edu.wpi.teamname.state

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty

/* This stores the state of the home screen */
class HomeState {
    val visible = SimpleBooleanProperty(false)
    val text = SimpleStringProperty(null)
    var numClicks = -1
        private set

    fun toggleClicked() {
        visible.value = !visible.value
        if (visible.value) numClicks++
    }

    fun setNode(newVal: String?) {
        text.value = newVal
    }
}
