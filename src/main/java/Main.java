import org.w3c.dom.ls.LSOutput;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String response;
        ContactDao contactDao = new ContactDaoImpl();
        List<Contact> contactList = new ArrayList<>();

        do {
            System.out.println("Wpisz: ");
            System.out.println("1 - aby dodać nowy kontakt");
            System.out.println("2 - aby usunąć kontakt");
            System.out.println("3 - aby wyświetlić wszystkie kontakty");
            System.out.println("4 - aby wyswietlic imie i nazwisko po numerze");
            System.out.println("5 - aby zapisać swoją liste do pliku");

            System.out.print("Twój wybór: ");
            response = scanner.nextLine();

            switch (response){
                case "1": {
                    System.out.println("Podaj imie: ");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj wiek: ");
                    String wiek = scanner.nextLine();
                    System.out.println("Podaj miasto: ");
                    String miasto = scanner.nextLine();
                    System.out.println("Podaj numer: ");
                    String numer = scanner.nextLine();
                    Contact contact= new Contact (imie,wiek,miasto,numer);
                    contactDao.addContact(contact);
                    contactList.add(contact);
                    break;
                }
                case "2": {
                    System.out.print("Podaj numer który chcesz usunąć: ");
                    contactDao.removeContact(scanner.nextLine());
                    break;
                }
                case "3": {
                    for (Contact contactModel : contactDao.getAllContact()) {
                        contactList.add(contactModel);
                        System.out.println(contactModel.toString());
                    }
                    //Utils.saveTofile(Paths.get("Contacts.txt"), contactList);
                    break;
                }
                case "4": {
                    System.out.print("Wpisz numer telefonu: ");
                    System.out.println(contactDao.getContactByNumber(scanner.nextLine()));
                    break;
                }
                case "5":{
                    System.out.println("Zapisz liste do pliku");
                    for (Contact contactModel : contactDao.getAllContact()) {
                        contactList.add(contactModel);

                    }

                    System.out.println(Utils.dateGeneration());
                    Utils.saveToFileList(contactList);
                    break;
                }
            }

        }while (!response.equals("exit"));


    }


}