package ua.goit.DatabaseStorage;

import java.sql.SQLException;

import org.flywaydb.core.Flyway;

public class DatabaseInitService {
//    private static final String INIT_DB_FILE_NAME = "sql\\init_db.sql";
    private static final String DB_URL = "jdbc:h2:./MegaSoft";

    public void initDb(Database database) throws SQLException {
        Flyway flyway = Flyway
                .configure()
                .dataSource(DB_URL, null, null)
                .load();

        flyway.migrate();

        database.close();
    }



}
