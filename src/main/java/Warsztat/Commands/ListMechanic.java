package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Vehicle;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class ListMechanic implements Command {
    private DataAccessObject<Mechanic> dataAccessObject;
    public ListMechanic(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Lista mechanik";
    }

    @Override
    public void service() {
        List<Mechanic> mechanics = dataAccessObject.findAll(Mechanic.class);
        mechanics.forEach(System.out::println);
    }
}
