package Warsztat.Commands;

import Warsztat.DataAccessObject;
import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteMechanic implements Command{
    private DataAccessObject<Mechanic> dataAccessObject;
    public DeleteMechanic(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Usun mechanika";
    }

    @Override
    public void service() {
        System.out.println("Podaj id usuwanego mechanika");
        String id = scanner.nextLine();
        Long mechanikId = Long.parseLong(id);
        if(dataAccessObject.delete(Mechanic.class,mechanikId)){
            System.out.println("Usunieto mechanika");
        } else {
            System.out.println("Nie znalezniono maechanika");
        }
    }
}
