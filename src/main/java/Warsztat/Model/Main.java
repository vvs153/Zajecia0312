package Warsztat.Model;

import Warsztat.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj komende");
        List<Command> commandList = new ArrayList<>(List.of(
                new AddVehicle(),
                new AddMechanic(),
                new AddService(),
                new ListVehicle(),
                new ListMechanic(),
                new ListService(),
                new FindVehicle(),
                new FindMechanic(),
                new FindService(),
                new DeleteVehicle(),
                new DeleteMechanic(),
                new DeleteService()



        ));

        System.out.println("Lista dostepnych komand");
        commandList.forEach(command -> System.out.println(command.getCommand()));
        System.out.println("Podaj komende");
        String command = Command.scanner.nextLine();
        for (Command dostepnaKomenda:commandList) {
            if(dostepnaKomenda.getCommand().equalsIgnoreCase(command)){
                dostepnaKomenda.service();
            }
        }
    }
}
