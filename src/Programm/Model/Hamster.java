package Programm.Model;

public class Hamster extends Pet{
    public Hamster() {
        setTitle("Хомяк");
    }

    @Override
    public String toString() {
        return getPet() + " - " + getTitle() + ": кличка " + getName() + ", порода " + getBreed() + ", дата рождения " + getDateOfBirth();
    }

    public String toStringNew() {
        return getName() + "," + getBreed() + "," + getDateOfBirth();
    }
}
    

