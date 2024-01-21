package Programm.Controllres;



import java.util.ArrayList;
import java.util.List;

public class MenuController {
    Programm.Vews.UserInterface userInterface = new Programm.Vews.UserInterface();
    ControlAnimalsCreate controlAnimalsCreate = new ControlAnimalsCreate();
    ControlStudiedCommand controlStudiedCommand = new ControlStudiedCommand();
    DataBase dataBase = new DataBase();

    public void controlMainMenu() {
        while (true) {
            userInterface.showMenu(userInterface.mainMenu(), "ГЛАВНОЕ МЕНЮ");
            int number = userInterface.selectingMenuNumber();
            switch (number) {
                case 1 -> {
                    System.out.println("\nРаздел записи в справочник");
                    controlAnimalsMenu(number);
                }
                case 2 -> {
                    System.out.println("\nРаздел чтения справочника");
                    controlAnimalsMenu(number);
                }
                case 3 -> {
                    System.out.println("\nДанные обо всех животных");
                    System.out.println("\nЗАПИСИ ВСЕХ СПРАВОЧНИКОВ");
                    List<String[]> listDirectory = new ArrayList<>();
                    List<String[]> listCommands = new ArrayList<>();
                    for (String name : userInterface.createListAnimals()) {
                        List<String[]> listDirectoryFile = dataBase.fileReading(name, name);
                        List<String[]> listCommandsFile = dataBase.fileReading(name + "Commands", name);
                        if (!listDirectoryFile.get(0)[0].equals("Файл не существует")) {
                            listDirectory.addAll(listDirectoryFile);
                        }
                        if (!listCommandsFile.get(0)[0].equals("Файл не существует")) {
                            listCommands.addAll(listCommandsFile);
                        }
                    }
                    userInterface.showEntryAll(listDirectory, listCommands);
                }
                case 4 -> {
                    System.out.println("\nРаздел добавления изученной команды");
                    controlAnimalsMenu(number);
                }
                case 5 -> {
                    System.out.println("\nЗавершение программы...");
                    return;
                }
                default -> System.out.println("Нет такого пункта меню\n");
            }
        }
    }

    public void controlAnimalsMenu(int numberMainMenu) {
        while (true) {
            userInterface.showMenu(userInterface.animalMenu(), "МЕНЮ ВЫБОРА СПРАВОЧНИКА");
            int numberMenuAnimals = userInterface.selectingMenuNumber();
            switch (numberMenuAnimals) {
                case 1 -> {
                    String title = "dogs";
                    List<String[]> commandsFile = dataBase.fileReading(title + "Commands", title);
                    if (numberMainMenu == 1) {
                        controlAnimalsCreate.createRecordsAnimals(numberMenuAnimals, title);
                    } else if (numberMainMenu == 2) {
                        userInterface.showEntry(dataBase.fileReading(title, title), title, commandsFile);
                    } else if (numberMainMenu == 4) {
                        int i = 0;
                        List<String[]> animalsList = dataBase.fileReading(title, title);
                        if (!animalsList.get(0)[0].equals("Файл не существует")) {
                            List<String[]> listCommands = new ArrayList<>();
                            if (!commandsFile.get(0)[0].equals("Файл не существует")) {
                                listCommands = commandsFile;
                            }
                            userInterface.showEntry(animalsList, title, commandsFile);
                            listCommands.add(controlStudiedCommand.addCommands(animalsList, commandsFile));
                            for (String[] text : listCommands) {
                                Boolean records = true;
                                if (i == 0) {
                                    records = false;
                                }
                                i++;
                                dataBase.fileRecording(title + "Commands", records, text[0] + "," + text[1]);
                            }
                        } else {
                            System.out.println("Список животных пуст");
                        }
                    }
                }
                case 2 -> {
                    String title = "cats";
                    List<String[]> commandsFile = dataBase.fileReading(title + "Commands", title);
                    if (numberMainMenu == 1) {
                        controlAnimalsCreate.createRecordsAnimals(numberMenuAnimals, title);
                    } else if (numberMainMenu == 2) {
                        userInterface.showEntry(dataBase.fileReading(title, title), title, commandsFile);
                    } else if (numberMainMenu == 4) {
                        int i = 0;
                        List<String[]> animalsList = dataBase.fileReading(title, title);
                        if (!animalsList.get(0)[0].equals("Файл не существует")) {
                            List<String[]> listCommands = new ArrayList<>();
                            if (!commandsFile.get(0)[0].equals("Файл не существует")) {
                                listCommands = commandsFile;
                            }
                            userInterface.showEntry(animalsList, title, commandsFile);
                            listCommands.add(controlStudiedCommand.addCommands(animalsList, commandsFile));
                            for (String[] text : listCommands) {
                                Boolean records = true;
                                if (i == 0) {
                                    records = false;
                                }
                                i++;
                                dataBase.fileRecording(title + "Commands", records, text[0] + "," + text[1]);
                            }
                        } else {
                            System.out.println("Список животных пуст");
                        }
                    }
                }
                case 3 -> {
                    String title = "hamsters";
                    List<String[]> commandsFile = dataBase.fileReading(title + "Commands", title);
                    if (numberMainMenu == 1) {
                        controlAnimalsCreate.createRecordsAnimals(numberMenuAnimals, title);
                    } else if (numberMainMenu == 2) {
                        userInterface.showEntry(dataBase.fileReading(title, title), title, commandsFile);
                    } else if (numberMainMenu == 4) {
                        int i = 0;
                        List<String[]> animalsList = dataBase.fileReading(title, title);
                        if (!animalsList.get(0)[0].equals("Файл не существует")) {
                            List<String[]> listCommands = new ArrayList<>();
                            if (!commandsFile.get(0)[0].equals("Файл не существует")) {
                                listCommands = commandsFile;
                            }
                            userInterface.showEntry(animalsList, title, commandsFile);
                            listCommands.add(controlStudiedCommand.addCommands(animalsList, commandsFile));
                            for (String[] text : listCommands) {
                                Boolean records = true;
                                if (i == 0) {
                                    records = false;
                                }
                                i++;
                                dataBase.fileRecording(title + "Commands", records, text[0] + "," + text[1]);
                            }
                        } else {
                            System.out.println("Список животных пуст");
                        }
                    }
                }
                case 4 -> {
                    String title = "horses";
                    List<String[]> commandsFile = dataBase.fileReading(title + "Commands", title);
                    if (numberMainMenu == 1) {
                        controlAnimalsCreate.createRecordsAnimals(numberMenuAnimals, title);
                    } else if (numberMainMenu == 2) {
                        userInterface.showEntry(dataBase.fileReading(title, title), title, commandsFile);
                    } else if (numberMainMenu == 4) {
                        int i = 0;
                        List<String[]> animalsList = dataBase.fileReading(title, title);
                        if (!animalsList.get(0)[0].equals("Файл не существует")) {
                            List<String[]> listCommands = new ArrayList<>();
                            if (!commandsFile.get(0)[0].equals("Файл не существует")) {
                                listCommands = commandsFile;
                            }
                            userInterface.showEntry(animalsList, title, commandsFile);
                            listCommands.add(controlStudiedCommand.addCommands(animalsList, commandsFile));
                            for (String[] text : listCommands) {
                                Boolean records = true;
                                if (i == 0) {
                                    records = false;
                                }
                                i++;
                                dataBase.fileRecording(title + "Commands", records, text[0] + "," + text[1]);
                            }
                        } else {
                            System.out.println("Список животных пуст");
                        }
                    }
                }
                case 5 -> {
                    String title = "camels";
                    List<String[]> commandsFile = dataBase.fileReading(title + "Commands", title);
                    if (numberMainMenu == 1) {
                        controlAnimalsCreate.createRecordsAnimals(numberMenuAnimals, title);
                    } else if (numberMainMenu == 2) {
                        userInterface.showEntry(dataBase.fileReading(title, title), title, commandsFile);
                    } else if (numberMainMenu == 4) {
                        int i = 0;
                        List<String[]> animalsList = dataBase.fileReading(title, title);
                        if (!animalsList.get(0)[0].equals("Файл не существует")) {
                            List<String[]> listCommands = new ArrayList<>();
                            if (!commandsFile.get(0)[0].equals("Файл не существует")) {
                                listCommands = commandsFile;
                            }
                            userInterface.showEntry(animalsList, title, commandsFile);
                            listCommands.add(controlStudiedCommand.addCommands(animalsList, commandsFile));
                            for (String[] text : listCommands) {
                                Boolean records = true;
                                if (i == 0) {
                                    records = false;
                                }
                                i++;
                                dataBase.fileRecording(title + "Commands", records, text[0] + "," + text[1]);
                            }
                        } else {
                            System.out.println("Список животных пуст");
                        }
                    }
                }
                case 6 -> {
                    String title = "donkeys";
                    List<String[]> commandsFile = dataBase.fileReading(title + "Commands", title);
                    if (numberMainMenu == 1) {
                        controlAnimalsCreate.createRecordsAnimals(numberMenuAnimals, title);
                    } else if (numberMainMenu == 2) {
                        userInterface.showEntry(dataBase.fileReading(title, title), title, commandsFile);
                    } else if (numberMainMenu == 4) {
                        int i = 0;
                        List<String[]> animalsList = dataBase.fileReading(title, title);
                        if (!animalsList.get(0)[0].equals("Файл не существует")) {
                            List<String[]> listCommands = new ArrayList<>();
                            if (!commandsFile.get(0)[0].equals("Файл не существует")) {
                                listCommands = commandsFile;
                            }
                            userInterface.showEntry(animalsList, title, commandsFile);
                            listCommands.add(controlStudiedCommand.addCommands(animalsList, commandsFile));
                            for (String[] text : listCommands) {
                                Boolean records = true;
                                if (i == 0) {
                                    records = false;
                                }
                                i++;
                                dataBase.fileRecording(title + "Commands", records, text[0] + "," + text[1]);
                            }
                        } else {
                            System.out.println("Список животных пуст");
                        }
                    }
                }
                case 7 -> {
                    return;
                }
                default -> System.out.println("Нет такого пункта меню\n");
            }
        }
    }
}