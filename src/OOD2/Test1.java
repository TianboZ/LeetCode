package OOD2;

public class Test1 {
    public void print() {
        System.out.println("OOD2, TEST1");
        privateFunc();

    }
    private void privateFunc() {
        System.out.println("this is a private function in OOD2 package, Test1 class");

        // Yuangong is a base class
        Yuangong yuangong1 = new Manager();
        Yuangong yuangong2 = new Programmer();

        // polymorphism
        System.out.println("yuangong1 salary = " + yuangong1.calculate(1));
        System.out.println("yuangong2 salary = " + yuangong2.calculate(1));

        // People is an interface
        // List is an interface
        People people1 = new GoodPeople();
        People people2 = new BadPeople();

        // polymorphism, 相同的method, 通过不同的instance call, 产生的结果不一样
        people1.say();
        people2.say();
    }

}
