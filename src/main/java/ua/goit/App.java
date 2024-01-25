package ua.goit;

import ua.goit.DatabaseStorage.Database;
import ua.goit.DatabaseStorage.DatabaseInitService;
import ua.goit.DatabaseStorage.DatabaseQueryService;
import ua.goit.DatabaseStorage.ReadCSV;
import ua.goit.dao.*;
import ua.goit.dto.*;
import ua.goit.model.Client;

import javax.lang.model.SourceVersion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class App {
    public static void main(String[] args) throws SQLException {

        //Module 8. JDBC CRUD, Migration
        Database database = Database.getInstance();

        //Task 1

/*
        new DatabaseInitService().initDb(database);

        System.out.println("Migration");
*/

        //Task 2.1

/*        Long newId = new ClientService(database.getConnection()).create("Coca Cola");

        System.out.println("New Client Id = " + newId);*/


        //Task 2.2
/*
        String clientName = new ClientService(database.getConnection()).getById(5);

        System.out.println("Client Name = " + clientName);
*/

        //Task 2.3

/*        new ClientService(database.getConnection()).setName(3,"New client name");*/


        //Task 2.4

/*        new ClientService(database.getConnection()).deleteById(4);*/

        //Task 2.5

        List<Client> clients = new ClientService(database.getConnection()).listAll();

        System.out.println("Clients List " + clients.toString());






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
