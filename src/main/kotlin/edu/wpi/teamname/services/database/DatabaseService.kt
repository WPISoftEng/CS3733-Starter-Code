package edu.wpi.teamname.services.database

import java.sql.Connection
import java.sql.SQLException

/*
 Database service class. This class will be loaded as a Singleton by Koin.
*/
class DatabaseService(private val connection: Connection) {
    fun initTable() {
        try {
            val stmt = connection.createStatement()
            var query =
                ("CREATE TABLE Employees( " +
                    "Id INT NOT NULL GENERATED ALWAYS AS IDENTITY, " +
                    "Name VARCHAR(255), " +
                    "Salary INT NOT NULL, " +
                    "Location VARCHAR(255), " +
                    "PRIMARY KEY (Id))")
            stmt.execute(query)
            query =
                "INSERT into Employees(Name, salary, location) VALUES('Wilson Wong', 1000000, 'WPI')"
            stmt.execute(query)
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    val employeeName: String?
        get() {
            try {
                val stmt = connection.createStatement()
                val res = stmt.executeQuery("SELECT Name from Employees")
                if (res.next()) {
                    return res.getString("Name")
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            }
            return null
        }
}
