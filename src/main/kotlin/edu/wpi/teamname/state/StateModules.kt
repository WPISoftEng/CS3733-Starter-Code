package edu.wpi.teamname.state

import org.koin.dsl.module

val StateModules = module { single { HomeState() } }
