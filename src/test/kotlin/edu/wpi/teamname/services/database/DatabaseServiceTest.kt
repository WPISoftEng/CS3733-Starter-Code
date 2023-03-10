package edu.wpi.teamname.services.database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DatabaseServiceTest {
    private var conn: Connection = DriverManager.getConnection(jdbcUrl)
    private var db: DatabaseService = DatabaseService(conn)

    @AfterEach
    fun teardown() {
        try {
            conn.close()
            DriverManager.getConnection(closeUrl)
        } catch (ignored: SQLException) {}
    }

    @Test
    fun testGetEmployeeName() {
        db.initTable()
        Assertions.assertEquals("Wilson Wong", db.employeeName)
    }

    @Test
    fun testGetEmployeeNameNoResults() {
        Assertions.assertNull(db.employeeName)
        conn.createStatement().execute("Create Table Employees(Name varchar(25))")
        Assertions.assertNull(db.employeeName)
    }

    companion object {
        private const val jdbcUrl = "jdbc:derby:memory:myDb;create=true"
        private const val closeUrl = "jdbc:derby:memory:myDb;drop=true"
    }
}
