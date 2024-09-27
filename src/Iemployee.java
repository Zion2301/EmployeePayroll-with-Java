import java.util.List;

public interface Iemployee {
    boolean addInfo(String Info);
    String SelectInfo(int id);
    List<String> displayInfo();
    void deleteProduct(int id);
}
