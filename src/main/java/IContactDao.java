import java.util.ArrayList;

public interface IContactDao {
    ArrayList<Contact> readAll();

    Contact findByName(String name);

    void add(Contact contact) throws ContactExecption;

    void del(String name) throws ContactNotFound;
}
