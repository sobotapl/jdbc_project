import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements ContactDao {


    @Override
    public void addContact(Contact contact) {

        try {
            PreparedStatement statment = MysqlConnector.connect().prepareStatement ("INSERT into user VALUES (?,?,?,?,?)");
            statment.setInt(1, contact.getId());
            statment.setString(2, contact.getName());
            statment.setString(3, contact.getAge());
            statment.setString(4, contact.getCity());
            statment.setString(5, contact.getNumber());
            statment.execute();
            statment.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void removeContact(String number) {
        try {
            PreparedStatement statment = MysqlConnector.connect().prepareStatement ("DELETE FROM user WHERE number = ?");
            statment.setString(1, number);
            statment.execute();
            statment.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> getAllContact() {
        List<Contact> contacts = new ArrayList<>();
        try {
            PreparedStatement statment = MysqlConnector.connect().prepareStatement ("SELECT * FROM user");
            ResultSet rs = statment.executeQuery();
            while(rs.next()){
                contacts.add(new Contact(rs.getInt("id"),rs.getString("name"), rs.getString("age"), rs.getString("city"), rs.getString("number")));
            }
            statment.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public Contact getContactByNumber(String number) {
        Contact contact = null;
        try {
            PreparedStatement statment = MysqlConnector.connect().prepareStatement ("DELETE FROM user WHERE number = ?");
            ResultSet rs = statment.executeQuery();
            while(rs.next()){
                contact = new Contact(rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("city"),
                        rs.getString("number"));
            }
            statment.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }




}
