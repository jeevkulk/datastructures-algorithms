package datastructure.puzzle.dictionary.unsortedarray;

import java.util.*;

/**
 * ADT: unsorted list
 * Description:
 * Design a simple address book with the basic functionality of adding a contact, deleting a contact, finding a contact
 * by the number and printing the list of existing contacts. Implement this using the dictionary ADT with the key as
 * the phone number. Use a linked list to store all the contacts in the order in which they were added. The information
 * in each record of the list is:
 *
 * Phone Number
 * Name
 *
 * So the linked list has objects of class Record. Complete the functions of the AddressBook class as mentioned in the
 * comments. The printing should be exactly as per the instructions given, including spacing.
 */

class Record {
    private String name;
    private long number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}

class AddressBook {
    private List<Record> list;

    public AddressBook() {
        this.list = new LinkedList<>();
    }

    public void add(String name, long number) {
        Record record = new Record();
        record.setName(name);
        record.setNumber(number);

        this.list.add(record);
        System.out.println("Successfully added: "+record.getName());
    }

    public void findByNumber(long number) {
        boolean present = false;
        Record record = null;
        for (int i = 0; i < list.size(); i++) {
            record = list.get(i);
            if (record.getNumber() == number) {
                present = true;
                break;
            }
        }
        if (present)
            System.out.println("Name: "+record.getName());
        else
            System.out.println("No such Number exists");
    }

    public void delete(long number) {
        boolean deleted = false;
        Record record = null;
        for (int i = 0; i < list.size(); i++) {
            record = list.get(i);
            if (record.getNumber() == number) {
                deleted = true;
                record = list.remove(i);
                System.out.println("Successfully deleted: "+record.getNumber());
                break;
            }
        }
        if (!deleted)
            System.out.println("No such Number exists");
    }

    public void printAddressBook() {
        System.out.println("List of contacts:");
        Record record = null;
        for (int i = 0; i < list.size(); i++) {
            record = list.get(i);
            System.out.println("Name: "+record.getName()+" Number: "+record.getNumber());
        }
    }
}

public class AddressBookDictionary {
    public static void main(String[] args) {
        AddressBook myContacts = new AddressBook();
        myContacts.add("John", 9876123450l);
        myContacts.add("Mellisa", 8360789114l);
        myContacts.add("Daman",9494149900l);
        myContacts.findByNumber(9998760333l);
        myContacts.printAddressBook();
        myContacts.delete(9876123450l);
        myContacts.add("Gregory",7289880988l);
        myContacts.printAddressBook();
        myContacts.findByNumber(8360789114l);
        myContacts.add("Mary",7205678901l);
        myContacts.delete(9876123450l);
        myContacts.findByNumber(7205678901l);
        myContacts.printAddressBook();
    }
}