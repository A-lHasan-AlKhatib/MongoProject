package Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Teacher {
    private static int count = 0;
    private int id;
    private String name;
    private String password;
    private float salary;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Teacher.count = count;
    }

    public Teacher(int id, String password) {
        this.id = id;
        setPassword(password);
    }

    public Teacher(String name, String password, float salary) {
        this.id = ++count;
        this.name = name;
        setPassword(password);
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger integer = new BigInteger(1, messageDigest);
            this.password = integer.toString(16);
        } catch (NoSuchAlgorithmException ignored) {
        }
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID : " + id + " , Name : " + name +
                " , password : " + password +
                "\n , salary : " + salary;
    }
}