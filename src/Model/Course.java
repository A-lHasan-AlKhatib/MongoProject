package Model;

public class Course {
    private static int count;
    private int id;
    private String name;
    private int hours;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Course.count = count;
    }

    public Course(String name, int hours) {
        this.id = ++count;
        this.name = name;
        this.hours = hours;
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

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "ID : " + id + " , Name : " + name + " , hours : " + hours;
    }
}
