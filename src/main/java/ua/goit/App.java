package ua.goit;

import ua.goit.DatabaseStorage.Database;
import ua.goit.DatabaseStorage.DatabaseInitService;
import ua.goit.DatabaseStorage.DatabaseQueryService;
import ua.goit.DatabaseStorage.ReadCSV;
import ua.goit.dao.ClientDAO;
import ua.goit.dao.ProjectDAO;
import ua.goit.dao.ProjectWorkerDAO;
import ua.goit.dao.WorkerDAO;
import ua.goit.dto.*;
import ua.goit.model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class App {
    public static void main(String[] args) throws SQLException {

        //Module 8. JDBC CRUD, Migration
        Database database = Database.getInstance();

        new DatabaseInitService().initDb(database);

        database.close();



        //Module 7. JDBC Extended

/*        Database database = Database.getInstance();
        Connection connection = database.getConnection();

        new ClientDAO().populateClients(connection);

        new WorkerDAO().populateWorkers(connection);

        new ProjectDAO().populateProjects(connection);

        new ProjectWorkerDAO().populateProjectWorkers(connection);

        connection.close();
        database.close();*/


        //Module 6. JDBC Extended

/*        List<LongestProjectDurationDTO> longestProjectDurations = DatabaseQueryService.findLongestProject();
        System.out.println("longestProjectDurations = " + longestProjectDurations);*/

/*        List<MaxProjectCountClientDTO> maxProjectCountClients = DatabaseQueryService.findMaxProjectsClient();
        System.out.println("maxProjectCountClients = " + maxProjectCountClients);*/

/*        List<MaxSalaryAmountWorkerDTO> maxSalaryAmountWorkers = DatabaseQueryService.findMaxSalaryAmountWorker();
        System.out.println("maxSalaryAmountWorkers = " + maxSalaryAmountWorkers);*/

/*        List<YoungestEldestWorkersDTO> youngestEldestWorkers = DatabaseQueryService.findYoungestEldestWorkers();
        System.out.println("youngestEldestWorkers = " + youngestEldestWorkers);*/

/*        List<PrintProjectPricesDTO> pintProjectPrices = DatabaseQueryService.printProjectPrices();
        System.out.println("pintProjectPrices = " + pintProjectPrices);*/

    }
}
