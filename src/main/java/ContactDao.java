import java.util.List;

public interface ContactDao {

    void addContact (Contact contact);

    void removeContact(String number);

    List<Contact> getAllContact();

    Contact getContactByNumber(String number);

}
