package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Service;

public class DeleteService implements Command{
    private DataAccessObject<Service> dataAccessObject;
    public DeleteService(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Usun serwis";
    }

    @Override
    public void service() {
        System.out.println("Podaj id usuwanego serwisu");
        String id = scanner.nextLine();
        Long serviceId = Long.parseLong(id);
        if(dataAccessObject.delete(Service.class,serviceId)){
            System.out.println("Usunieto serwis");
        } else {
            System.out.println("Nie znalezniono servicu");
        }
    }
}
