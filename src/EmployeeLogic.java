import java.util.ArrayList;
import java.util.List;

public class EmployeeLogic implements Iemployee {
     List<String> employees = new ArrayList<>();
    @Override
    public boolean addInfo(String Info) {
        return employees.add(Info);
    }

    @Override
    public String SelectInfo(int id) {
        if (id >= 0 || id <= employees.size()){
            return employees.get(id);
        }
        return "Employee isnt here";
    }

    @Override
    public List<String> displayInfo() {
        return employees;
    }

    @Override
    public void deleteProduct(int id) {
         employees.remove(id);
    }
}
