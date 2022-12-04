package Warsztat.Commands;


import Warsztat.DataAccessObject;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Service;
import Warsztat.Model.Vehicle;

import java.time.LocalDateTime;
import java.util.Optional;

public class EndService implements Command {
    private DataAccessObject<Service> dataAccessObject;

    public EndService(){

        this.dataAccessObject = new DataAccessObject();
    }
    @Override
    public String getCommand(){
        return "Zakoncz serwis";
    }
    @Override
    public void service(){
        System.out.println("Podaj id serwisu");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        Optional<Service> serviceOptional = dataAccessObject.find(Service.class,id);
        if(serviceOptional.isEmpty()){
            System.err.println("Nie ma serwisu o takim id");
            return;
        }
        Service  originalServis = serviceOptional.get();
        System.out.println("Podaj wykonane czynnosci");
        String work = Command.scanner.nextLine();
        System.out.println("Podaj koszt serwisu");
        String costString = Command.scanner.nextLine();
        Double cost = Double.parseDouble(costString);

        Service service = Service.builder()
                .vehicle(originalServis.getVehicle())
                .mechanic(originalServis.getMechanic())
                .description(originalServis.getDescription())
                .addTime(originalServis.getAddTime())
                .leadTime(LocalDateTime.now())
                .job(work)
                .cost(cost)
                .id(id)

                .build();
dataAccessObject.update(Service.class,id,service);
    }
}
