package semester2.chapter11;



public abstract class Animal {
    public abstract void eat(Object ob);
}

abstract class Swimmer extends Animal{
    public abstract void swim();
}


class Plankton extends Swimmer {
    public void swim(){
        System.out.println(this.toString() + " is swimming");
    }

    public void eat(Object ob){
        System.out.println(this.toString() + " eats " + ob.toString());
    }

    public String toString(){
        return "Plankton";
    }
}

class Panda extends Animal {
    public void eat(Object ob){
        System.out.println(this + " eats " + ob);
    }

    public String toString(){
        return "Panda";
    }
}


class Tuna extends Swimmer {
    public void swim(){
        System.out.println(this.toString() + " swims!");
    }

    public void eat(Object ob){
        //if ob is instance of swimmer, only then can tuna eat it
        if(ob instanceof Swimmer) {
            System.out.println(this + " eats the " + ob);
        } else {
            System.out.println(this.toString() + " cannot eat a non-swimmer. Still hungry! *Stomach gurgles*");
        }
    }
    public String toString() {
        return "Tuna";
    }
}

class AnimalTester {
    public static void main(String[] args) {

        Animal plankton = new Plankton();
        Animal tuna = new Tuna();
        Animal panda = new Panda();

        tuna.eat(plankton);
        tuna.eat(panda);
    }
}