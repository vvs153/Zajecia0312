package Warsztat.Commands;


import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddVehicle implements Command {
    private DataAccessObject<Vehicle> dataAccessObject;
    public AddVehicle(){
        this.dataAccessObject = new DataAccessObject();
    }
    @Override
    public String getCommand(){
        return "Dodaj pojazd";
    }
    @Override
    public void service(){
        System.out.println("Podaj marke samochodu: ");
        String brand = Command.scanner.nextLine();
        System.out.println("Podaj model samochodu: ");
        String model = Command.scanner.nextLine();
        System.out.println("Podaj vin samochodu: ");
        String vin = Command.scanner.nextLine();
        System.out.println("Podaj nr rejestracyjny samochodu: ");
        String regNr = Command.scanner.nextLine();

        Vehicle vehicle = Vehicle.builder()
                .brand(brand)
                .model(model)
                .vin(vin)
                .regNr(regNr)
                .build();

        dataAccessObject.insert(vehicle);
    }
}
