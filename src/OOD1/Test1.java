package OOD1;

class Test1 {
    public void print() {
        System.out.println("OOD1, TEST1");
        privateFunc();
        add(2,3); // non-static method can access static method

    }
    private void privateFunc() {
        System.out.println("this is a private function in OOD1 package, Test1 class");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.print();
        OOD2.Test1 ood2Test1 = new OOD2.Test1();
        ood2Test1.print();
        Test3 test3 = new Test3(1,2);
        test3.y = 3;
        System.out.println(test3.y);


        add(1,2); // static method can be accessed by static method directly without object
    }

    public static void add(int x, int y) {
        System.out.println(x + " + " + y + " = " + (x + y));
        return;
    }
}

// nested class
class Test3 {
    private int x; // x is not accessible

    public int y;
    public Test3 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}