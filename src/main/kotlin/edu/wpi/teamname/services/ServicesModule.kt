package edu.wpi.teamname.services

import edu.wpi.teamname.services.database.DatabaseService
import java.sql.DriverManager
import org.koin.dsl.module

/** Defines services for injection */
val ServiceModules = module {
    single { DatabaseService(get()) }

    single {
        DriverManager.getConnection("jdbc:derby:memory:myDB;create=true")
        // DriverManager.getConnection("jdbc:derby:myDB;create=true")
    }

    factory { ServiceTwo() }
}
