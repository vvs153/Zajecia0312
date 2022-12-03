package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Service;

import java.util.List;

public class ListService implements Command {
    private DataAccessObject<Service> dataAccessObject;
    public ListService(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Lista serwis";
    }

    @Override
    public void service() {
        List<Service> services = dataAccessObject.findAll(Service.class);
        services.forEach(System.out::println);
    }
}
