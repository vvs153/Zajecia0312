package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteVehicle implements Command {
    private DataAccessObject<Vehicle> dataAccessObject;
    public DeleteVehicle(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Usun pojazd";
    }

    @Override
    public void service() {
        System.out.println("Podaj id usuwanego pojazdu");
        String id = scanner.nextLine();
        Long vehicleId = Long.parseLong(id);
        if(dataAccessObject.delete(Vehicle.class,vehicleId)){
            System.out.println("Usunieto pojazd");
        } else {
            System.err.println("Nie znalezniono pojazdu");
        }
}
}