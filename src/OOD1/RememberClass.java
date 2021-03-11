package OOD1;

public class RememberClass {
    public static void main(String[] args) {
        People p1 = new People("tianbo");
        System.out.println(p1);
        System.out.println(People.FUCK);
    }
}

class People {
    // public/private, static, final 三个类别互相没有关系！垂直关系
    // fields
    public int age;  // member
    private final String name; // constant    一但赋值，就不能变了
    private static String school; // static
    private static final String HI = "HI!";
    public static final String FUCK = "fuck";

    // constructor
    // default constructor if you don't define your own constructor
//    public People() {
//
//    }
    public People(String n) {
        name = n;
    }

    public People(String n, int age) {
        this.name = n; // name = n; 推荐这种写法，剩this
        this.age = age;
    }

    // methods
}