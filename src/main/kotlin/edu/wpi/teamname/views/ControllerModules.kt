package edu.wpi.teamname.views

import org.koin.dsl.module

val ControllerModules = module { factory { HomeController(get(), get(), get(), get()) } }
