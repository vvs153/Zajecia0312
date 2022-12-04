package Warsztat.Commands;


import Warsztat.DataAccessObject;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Vehicle;

public class UpdateVehicle implements Command {
    private DataAccessObject<Vehicle> dataAccessObject;
    public UpdateVehicle(){
        this.dataAccessObject = new DataAccessObject();
    }
    @Override
    public String getCommand(){
        return "Aktualizuj pojazd";
    }
    @Override
    public void service(){
        System.out.println("Podaj id samochodu: ");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        if(!dataAccessObject.exists(Vehicle.class,id)){
            System.err.println("Nie ma auta o takim id");
            return;
        }
        System.out.println("Podaj marke samochodu: ");
        String brand = Command.scanner.nextLine();
        System.out.println("Podaj model samochodu: ");
        String model = Command.scanner.nextLine();
        System.out.println("Podaj vin samochodu: ");
        String vin = Command.scanner.nextLine();
        System.out.println("Podaj nr rejestracyjny samochodu: ");
        String regNr = Command.scanner.nextLine();

        Vehicle vehicle = Vehicle.builder()
                .id(id)
                .brand(brand)
                .model(model)
                .vin(vin)
                .regNr(regNr)
                .build();

        dataAccessObject.update(Vehicle.class,id,vehicle);
    }
}
