package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Mechanic;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateMechanic implements Command {

    private DataAccessObject<Mechanic> dataAccessObject;

    public UpdateMechanic() {
        this.dataAccessObject = new DataAccessObject();
    }

    @Override
    public String getCommand() {
        return "Aktualizuj mechanika";
    }

    @Override
    public void service() {
        System.out.println("Podaj id mechanika: ");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        if(!dataAccessObject.exists(Mechanic.class,id)){
            System.err.println("Nie ma mechanika o takim id");
            return;
        }
        System.out.println("Podaj imie mechanika: ");
        String name = Command.scanner.nextLine();
        System.out.println("Podaj kwalifikacje: ");
        String qualifications = Command.scanner.nextLine();
        System.out.println("Podaj specjalizacje: ");
        String specialisation = Command.scanner.nextLine();
        Mechanic mechanic = Mechanic.builder()
                .id(id)
                .name(name)
                .specialisation(specialisation)
                .qualifications(qualifications)
                .build();
        dataAccessObject.update(Mechanic.class,id,mechanic);



    }
}

