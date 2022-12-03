package Warsztat.Commands;


import Warsztat.DataAccessObject;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Service;
import Warsztat.Model.Vehicle;

import java.util.Optional;

public class AddService implements Command {
    private DataAccessObject<Service> dataAccessObject;
    private DataAccessObject<Vehicle> dataAccessObjectVEHICLE;
    private DataAccessObject<Mechanic> dataAccessObjectMECHANIC;
    public AddService(){

        this.dataAccessObject = new DataAccessObject();
        this.dataAccessObjectVEHICLE = new DataAccessObject();
        this.dataAccessObjectMECHANIC = new DataAccessObject();
    }
    @Override
    public String getCommand(){
        return "Dodaj serwis";
    }
    @Override
    public void service(){
        System.out.println("Podaj id pojazdu");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);

        Optional<Vehicle> optionalVehicle = dataAccessObjectVEHICLE.find(Vehicle.class, id);
        if(optionalVehicle.isEmpty()){
            System.err.println("Pojazd nie istnieje");
            return;
        }
        System.out.println("Podaj id mechanika");
        String idString2 = Command.scanner.nextLine();
        Long idMechanic = Long.parseLong(idString2);
        Optional<Mechanic> optionalMechanic = dataAccessObjectMECHANIC.find(Mechanic.class, idMechanic);
        if(optionalMechanic.isEmpty()){
            System.err.println("Mechanik nie istnieje");
            return;
        }
        System.out.println("Podaj opis");
        String description = Command.scanner.nextLine();
        Service service = Service.builder()
                .mechanic(optionalMechanic.get())
                .vehicle(optionalVehicle.get())
                .description(description)
                .build();
        dataAccessObject.insert(service);
    }
}
