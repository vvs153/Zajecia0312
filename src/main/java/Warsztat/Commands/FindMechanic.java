package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Vehicle;
import org.hibernate.Session;

import java.util.Optional;

public class FindMechanic implements Command{
    private DataAccessObject<Mechanic> dataAccessObject;
    public FindMechanic(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Znajdz mechanika";
    }

    @Override
    public void service() {
        System.out.println("Podaj id szukanego mechanika");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        Optional<Mechanic> mechanikOptional = dataAccessObject.find(Mechanic.class,id);
        if(mechanikOptional.isPresent()){
            System.out.println(mechanikOptional.get());
        } else {
            System.err.println("nie znaleziono mechanika");
        }
    }
}
