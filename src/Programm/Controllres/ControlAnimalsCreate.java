package Programm.Controllres;

import Programm.Model.*;
import Programm.Vews.UserInterface;

import java.time.LocalDate;

public class ControlAnimalsCreate {
    UserInterface userInterface = new UserInterface();
    private String[] dateAnimals;
    DataBase dataBase = new DataBase();

    public void createRecordsAnimals(int numberMenuAnimals, String title) {
        switch (numberMenuAnimals) {
            case 1 -> {
                Dog dogs = new Dog();
                dateAnimals = userInterface.enteringDataAnimal();
                dogs.setName(dateAnimals[0]);
                dogs.setBreed(dateAnimals[1]);
                dogs.setDateOfBirth(LocalDate.parse(dateAnimals[2]));
                dataBase.fileRecording(title, true, dogs.toStringNew());
            }
            case 2 -> {
                Cat cats = new Cat();
                dateAnimals = userInterface.enteringDataAnimal();
                cats.setName(dateAnimals[0]);
                cats.setBreed(dateAnimals[1]);
                cats.setDateOfBirth(LocalDate.parse(dateAnimals[2]));
                dataBase.fileRecording(title, true, cats.toStringNew());
            }
            case 3 -> {
                Hamster hamsters = new Hamster();
                dateAnimals = userInterface.enteringDataAnimal();
                hamsters.setName(dateAnimals[0]);
                hamsters.setBreed(dateAnimals[1]);
                hamsters.setDateOfBirth(LocalDate.parse(dateAnimals[2]));
                dataBase.fileRecording(title, true, hamsters.toStringNew());
            }
            case 4 -> {
                Horse horses = new Horse();
                dateAnimals = userInterface.enteringDataAnimal();
                horses.setName(dateAnimals[0]);
                horses.setBreed(dateAnimals[1]);
                horses.setDateOfBirth(LocalDate.parse(dateAnimals[2]));
                dataBase.fileRecording(title, true, horses.toStringNew());
            }
            case 5 -> {
                Camel camels = new Camel();
                dateAnimals = userInterface.enteringDataAnimal();
                camels.setName(dateAnimals[0]);
                camels.setBreed(dateAnimals[1]);
                camels.setDateOfBirth(LocalDate.parse(dateAnimals[2]));
                dataBase.fileRecording(title, true, camels.toStringNew());
            }
            case 6 -> {
                Donkey donkeys = new Donkey();
                dateAnimals = userInterface.enteringDataAnimal();
                donkeys.setName(dateAnimals[0]);
                donkeys.setBreed(dateAnimals[1]);
                donkeys.setDateOfBirth(LocalDate.parse(dateAnimals[2]));
                dataBase.fileRecording(title, true, donkeys.toStringNew());
            }
        }
    }
}