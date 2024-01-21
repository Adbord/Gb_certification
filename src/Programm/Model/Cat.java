package Programm.Model;

public class Cat extends Pet {
    public Cat() {
        setTitle("Кошка");
    }

    @Override
    public String toString() {
        return getPet() + " - " + getTitle() + ": кличка " + getName() + ", порода " + getBreed() + ", дата рождения " + getDateOfBirth();
    }

    public String toStringNew() {
        return getName() + "," + getBreed() + "," + getDateOfBirth();
    }
}
