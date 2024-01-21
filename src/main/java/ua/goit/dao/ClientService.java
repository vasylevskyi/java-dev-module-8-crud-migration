package ua.goit.dao;

/*
* Напиши клас з назвою ClientService. Цей клас призначений для CRUD операцій з клієнтами. Мають бути наступні методи:

long create(String name) - додає нового клієнта з іменем name. Повертає ідентифікатор щойно створеного клієнта.
String getById(long id) - повертає назву клієнта з ідентифікатором id
void setName(long id, String name) - встановлює нове ім'я name для клієнта з ідентифікатором id
void deleteById(long id) - видаляє клієнта з ідентифікатором id
List<Client> listAll() - повертає всіх клієнтів з БД у вигляді колекції об'єктів типу Client (цей клас створи сам,
* у ньому має бути 2 поля - id та name)

* Передбач валідацію вхідних даних в методах класу ClientService. Якщо якісь вхідні дані некоректні (наприклад, ми
* намагаємось створити клієнта з занадто коротким чи довгим іменем) - відповідний метод має викидати Exception.*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientService {
    private PreparedStatement createStatement;
    private PreparedStatement readStatement;
    public ClientService(Connection connection) throws SQLException {
        createStatement = connection
                .prepareStatement("INSERT INTO client (name) VALUES (?)");

        readStatement = connection
                .prepareStatement("SELECT id, name FROM client WHERE id = ?");
    }




    //додає нового клієнта з іменем name. Повертає ідентифікатор щойно створеного клієнта.
    public long create(String name) throws SQLException {
        createStatement.setString(1, name);
/*
        createStatement.setInt(2, person.getAge());
        createStatement.setString(3, person.getBirthday().toString());
*/
        int i = createStatement.executeUpdate();
        return (long) i;


    }

    // повертає назву клієнта з ідентифікатором id

    public String getById(long id) {

    }

    // встановлює нове ім'я name для клієнта з ідентифікатором id
    public void setName(long id, String name) {

    }

    // видаляє клієнта з ідентифікатором id
    public void deleteById(long id) {

    }

    /* повертає всіх клієнтів з БД у вигляді колекції об'єктів типу Client (цей клас створи сам,
            * у ньому має бути 2 поля - id та name)*/
    public List<Client> listAll() {

    }
    public long getMaxId() {

    }
}

/*
*     private PreparedStatement createSt;
    private PreparedStatement readSt;

    public PersonCrudService(Connection connection) {
        createSt = connection
            .prepareStatement("INSERT INTO people (name, age, birthday) VALUES (?, ?, ?)");

        readSt = connection
            .prepareStatement("SELECT id, name, age, birthday FROM people WHERE id = ?");
    }

    public void create(Person person) {
        createSt.setString(1, person.getName());
        createSt.setInt(2, person.getAge());
        createSt.setString(3, person.getBirthday().toString());

        createSt.executeUpdate();
    }

    public Person getById(long id) {
        readSt.setLong(1, id);

        ResultSet rs = readSt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        String name = rs.getString("name");
        int age = rs.getInt("age");
        LocalDate birthday = LocalDate.parse(rs.getString("birthday"));

        Person result = new Person();
        result.setName(name);
        result.setAge(age);
        result.setBirthday(birthday);
        result.setId(id);

        return result;
    }*/
