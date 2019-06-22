package datastructure.puzzle.dictionary.sortedarray;

/**
 * ADT: sorted list
 * Description:
 * Design a simple address book with the basic functionality of adding a contact, deleting a contact, finding a contact
 * by the ID and printing the list of existing contacts. Implement this using the dictionary ADT with the ID of the
 * contact as the key, which means, in the address book, multiple contacts with the same ID cannot exist. Use a fixed
 * array (large enough) to store all the contacts in a sorted order with respect to their IDs using the Bin/Bucket sort
 * algorithm. The IDs of the contacts range from 100 to 999.
 *
 * The information in each record of the array is:
 * - Phone Number
 * - Name
 * - ID
 * So the array has objects of class Record. Complete the functions of the AddressBook class as mentioned in the
 * comments. Do not change the Source class code. The printing should be exactly as per the instructions given,
 * including spacing.
 *
 * (No input needed)
 */

class Record {
    private int ID;
    private String name;
    private long number;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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
    private int lowInd = 100;
    private int highInd = 999;
    private Record[] records;

    public AddressBook() {
        this.records = new Record[900];
    }

    public void add(String name, long number, int ID) {
        Record record = new Record();
        record.setName(name);
        record.setNumber(number);
        record.setID(ID);

        if (ID > highInd) {
            System.out.println("ID "+record.getID()+" out of range");
        } else {
            int ind = ID - lowInd - 1;
            this.records[ind] = record;
            System.out.println("Successfully added: " + record.getName());
        }
    }

    public void findByID(int ID) {
        int ind = ID - lowInd - 1;
        if (this.records[ind] != null) {
            System.out.println("Name: "+records[ind].getName()+" Number: "+records[ind].getNumber());
        } else {
            System.out.println("No such ID exists");
        }
    }

    public void delete(int ID) {
        int ind = ID - lowInd - 1;
        if (this.records[ind] != null) {
            String contactName = records[ind].getName();
            this.records[ind] = null;
            System.out.println("Successfully deleted: "+contactName);
        } else {
            System.out.println("No such ID exists");
        }
    }

    public void printAddressBook() {
        System.out.println("List of contacts:");
        for (Record record : this.records) {
            if (record != null)
                System.out.println("Name: "+record.getName()+" ID: "+record.getID()+" Number: "+record.getNumber());
        }
    }
}

public class AddressBookDictionary {
    public static void main(String[] args) {
        AddressBook myContacts = new AddressBook();
        myContacts.add("John", 9876123450l, 101);
        myContacts.add("Mellisa", 8360789114l, 560);
        myContacts.add("Daman",9494149900l, 444);
        myContacts.findByID(999);
        myContacts.printAddressBook();
        myContacts.delete(101);
        myContacts.add("Gregory",7289880988l, 980);
        myContacts.printAddressBook();
        myContacts.findByID(560);
        myContacts.add("Mary",7205678901l, 670);
        myContacts.delete(101);
        myContacts.findByID(670);
        myContacts.printAddressBook();
    }
}
