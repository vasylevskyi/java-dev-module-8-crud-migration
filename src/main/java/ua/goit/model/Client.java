package ua.goit.model;

//HEADER: Client ID,Name

import com.opencsv.bean.CsvBindByName;

public class Client {

    @CsvBindByName ( column = "Clint ID", required = true)
    private long id;
    @CsvBindByName ( column = "Name", required = true)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
