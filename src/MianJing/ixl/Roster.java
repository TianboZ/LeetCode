package MianJing.ixl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Student {
    String name;
    String userName;
    int id;
    Student() {

    }
    Student(String n, String u, int _id) {
        name = n;
        userName = u;
        id = _id;
    }
}
public class Roster {
    String DE = "a#a";  // delimiter for Student object fields
    String DE2 = "b#b";  // delimiter  for list of encoded Student string
    String ENCODE = "##"; // replace original "#"  to "##"

    public String encode(List<Student> list) {
        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(encodeStudent(s));
            sb.append(DE2);
        }
        return sb.toString();
    }

    // Encodes a list of strings to a single string.
    private String encodeStudent(Student s) {
        StringBuilder sb = new StringBuilder();

        sb.append(s.name.replace("#", ENCODE)).append(DE);
        sb.append(s.userName.replace("#", ENCODE)).append(DE);

        return sb.toString();
    }

    // ---------------------------------------------------------------------------

    public List<Student> decode(String s) {
        List<Student> list = new ArrayList<>();
        // step1
        String[] students = s.split(DE2, -1);

        // step2
        for (int i = 0; i < students.length - 1; i++) { // we want to escape last ""
            String encodedStu = students[i];
            list.add(decodeStudent(encodedStu));
        }
        System.out.println(list);
        return list;
    }

    // Decodes a single string to a list of strings.
    public Student decodeStudent(String s) {
        Student stu = new Student();

        String[] arr = s.split(DE, -1);
        for (int i = 0; i < arr.length - 1; i++) {
            //  i < arr.length - 1:  we want to escapge last ""
            if (i == 0) {
                stu.name = arr[i].replace(ENCODE, "#");
            }
            if (i == 1) {
                stu.userName = arr[i].replace(ENCODE, "#");
            }
        }
        return stu;
    }


    private List<String> decodeStudentList() {
        return null;
    }

    public static void main(String[] args) {
        Roster sol = new Roster();
        Student s = new Student("tianboa#a", "tianbozong##", 100);
        Student s2 = new Student("tom", "b#b", 9);

        List<Student> list = Arrays.asList(s, s2);

        // encode
        String encodedRes = sol.encode(list);
        System.out.println(encodedRes);

        // decode
        sol.decode(encodedRes);
    }


}
