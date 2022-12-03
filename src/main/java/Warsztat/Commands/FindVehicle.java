package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Vehicle;
import org.hibernate.Session;

import java.util.Optional;

public class FindVehicle implements Command{
    private DataAccessObject<Vehicle> dataAccessObject;
    public FindVehicle(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Znajdz pojazd";
    }

    @Override
    public void service() {
        System.out.println("Podaj id szukanego pojazdu");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        Optional<Vehicle> vehicleOptional = dataAccessObject.find(Vehicle.class,id);
        if(vehicleOptional.isPresent()){
            System.out.println(vehicleOptional.get());
        } else {
            System.err.println("nie znaleziono pojazdu");
        }
    }
}
