package src.Notes.Abstraction;

public abstract class Animal {
    @SuppressWarnings("unused") //no want to be yelled at
    private int age;
    
    public Animal() {
        age = 0;
    }

    public void age() {
        age++;
    }

    public abstract Animal[] reproduce(Animal mate); //no implementation

    public static void main(String[] args) {
        Animal[] animals = new Animal[5]; //CANNOT INSTANTIATE

        //animals[0] = new Amoeba()   WORKS
        //animals[1] = new Dog()      WORKS

        for(Animal a : animals) {
            a.age();
        }
    }
}

//public class Amoeba extends Animal {
//  public Animal[] reproduce(Animal mate) {
//        return new Animal[]{ new Amoeba(), this };
//  }
//}

//public class Dog extends Animal {
//  public Animal[] reproduce(Animal mate)
//}

//both are REQUIRED to implement public Animal[] reproduce(Animal mate)