package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Mechanic;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddMechanic implements Command{

    private DataAccessObject<Mechanic> dataAccessObject;
    public AddMechanic(){
        this.dataAccessObject = new DataAccessObject();
    }
    @Override
    public String getCommand() {
        return "Dodaj mechanika";
    }

    @Override
    public void service() {
        System.out.println("Podaj imie mechanika: ");
        String name = Command.scanner.nextLine();
        System.out.println("Podaj kwalifikacje: ");
        String qualifications = Command.scanner.nextLine();
        System.out.println("Podaj specjalizacje: ");
        String specialisation = Command.scanner.nextLine();


       Mechanic mechanic = Mechanic.builder()
               .name(name)
               .qualifications(qualifications)
               .specialisation(specialisation)
               .build();

    dataAccessObject.insert(mechanic);
    }
}
