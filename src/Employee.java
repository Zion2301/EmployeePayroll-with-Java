public class Employee {
    private String Info;
    private int id;

    public Employee(String info, int id) {
        Info = info;
        this.id = id;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
