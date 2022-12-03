package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Service;

import java.util.Optional;

public class FindService implements Command{
    private DataAccessObject<Service> dataAccessObject;
    public FindService(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Znajdz serwis";
    }

    @Override
    public void service() {
        System.out.println("Podaj id szukanego servisu");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        Optional<Service> serviceOptional = dataAccessObject.find(Service.class,id);
        if(serviceOptional.isPresent()){
            System.out.println(serviceOptional.get());
        } else {
            System.err.println("nie znaleziono servisu");
        }
    }
}
