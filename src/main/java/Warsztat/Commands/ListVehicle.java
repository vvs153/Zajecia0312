package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Vehicle;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class ListVehicle implements Command{
private DataAccessObject<Vehicle> dataAccessObject;
public ListVehicle(){
    this.dataAccessObject = new DataAccessObject<>();
}
    @Override
    public String getCommand() {
        return "Lista pojazd";
    }

    @Override
    public void service() {
    List<Vehicle> pojazdy = dataAccessObject.findAll(Vehicle.class);
    pojazdy.forEach(System.out::println);
    }
}
