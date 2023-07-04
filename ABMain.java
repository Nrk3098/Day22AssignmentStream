package Com.AB;
import java.util.*;

class ContactPerson {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Contact: " + firstName + " " + lastName +
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nState: " + state +
                "\nZIP: " + zip +
                "\nPhone: " + phoneNumber +
                "\nEmail: " + email;
    }
}

class AddressBook {
    private String name;
    private List<ContactPerson> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Add a new contact
    public void addContact(ContactPerson contact) {
        contacts.add(contact);
    }

    // Edit an existing contact
    public void editContact(String firstName, String lastName, ContactPerson newContact) {
        for (int i = 0; i < contacts.size(); i++) {
            ContactPerson contact = contacts.get(i);
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                contacts.set(i, newContact);
                break;
            }
        }
    }

    // Delete a contact
    public void deleteContact(String firstName, String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            ContactPerson contact = contacts.get(i);
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                contacts.remove(i);
                break;
            }
        }
    }

    // Search contacts by city
    public List<ContactPerson> searchByCity(String city) {
        List<ContactPerson> results = new ArrayList<>();
        for (ContactPerson contact : contacts) {
            if (contact.getCity().equals(city)) {
                results.add(contact);
            }
        }
        return results;
    }

    // Search contacts by state
    public List<ContactPerson> searchByState(String state) {
        List<ContactPerson> results = new ArrayList<>();
        for (ContactPerson contact : contacts) {
            if (contact.getState().equals(state)) {
                results.add(contact);
            }
        }
        return results;
    }

    // Get count of contacts by city
    public int getCountByCity(String city) {
        int count = 0;
        for (ContactPerson contact : contacts) {
            if (contact.getCity().equals(city)) {
                count++;
            }
        }
        return count;
    }

    // Get count of contacts by state
    public int getCountByState(String state) {
        int count = 0;
        for (ContactPerson contact : contacts) {
            if (contact.getState().equals(state)) {
                count++;
            }
        }
        return count;
    }

    // Sort contacts by name
    public void sortContactsByName() {
        contacts.sort(Comparator.comparing(ContactPerson::getFirstName).thenComparing(ContactPerson::getLastName));
    }

    // Sort contacts by city
    public void sortContactsByCity() {
        contacts.sort(Comparator.comparing(ContactPerson::getCity));
    }

    // Sort contacts by state
    public void sortContactsByState() {
        contacts.sort(Comparator.comparing(ContactPerson::getState));
    }

    // Sort contacts by ZIP
    public void sortContactsByZIP() {
        contacts.sort(Comparator.comparing(ContactPerson::getZip));
    }

    // Override toString() method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address Book: ").append(name).append("\n");
        for (ContactPerson contact : contacts) {
            sb.append(contact.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<ContactPerson> searchByFirstName(String firstName, String lastName) {
        contacts.sort(Comparator.comparing(ContactPerson::getFirstName));
        return null;
    }
}

public class ABMain {
    private static Map<String, AddressBook> addressBooks = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("***** Address Book *****");
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit an existing contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Search contacts by city");
            System.out.println("5. Search contacts by state");
            System.out.println("6. Count contacts by city");
            System.out.println("7. Count contacts by state");
            System.out.println("8. Sort contacts by name");
            System.out.println("9. Sort contacts by city");
            System.out.println("10. Sort contacts by state");
            System.out.println("11. Sort contacts by ZIP");
            System.out.println("0. Exit");
            System.out.println("*************************");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    editContact(scanner);
                    break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    searchByCity(scanner);
                    break;
                case 5:
                    searchByState(scanner);
                    break;
                case 6:
                    countByCity(scanner);
                    break;
                case 7:
                    countByState(scanner);
                    break;
                case 8:
                    sortContactsByName(scanner);
                    break;
                case 9:
                    sortContactsByCity(scanner);
                    break;
                case 10:
                    sortContactsByState(scanner);
                    break;
                case 11:
                    sortContactsByZIP(scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Helper method to add a new contact
    private static void addContact(Scanner scanner) {
        System.out.println("Enter the address book name:");
        String addressBookName = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            addressBook = new AddressBook(addressBookName);
            addressBooks.put(addressBookName, addressBook);
        }

        System.out.println("Enter the first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the city:");
        String city = scanner.nextLine();
        System.out.println("Enter the state:");
        String state = scanner.nextLine();
        System.out.println("Enter the ZIP code:");
        String zip = scanner.nextLine();
        System.out.println("Enter the phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the email address:");
        String email = scanner.nextLine();

        ContactPerson contact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    // Helper method to edit an existing contact
    private static void editContact(Scanner scanner) {
        System.out.println("Enter the address book name:");
        String addressBookName = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("Address book not found.");
            return;
        }

        System.out.println("Enter the first name of the contact to edit:");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the contact to edit:");
        String lastName = scanner.nextLine();

        List<ContactPerson> contacts = addressBook.searchByFirstName(firstName, lastName);
        if (contacts.isEmpty()) {
            System.out.println("Contact not found.");
            return;
        }

        ContactPerson contact = contacts.get(0);
        System.out.println("Enter the new first name:");
        String newFirstName = scanner.nextLine();
        System.out.println("Enter the new last name:");
        String newLastName = scanner.nextLine();
        System.out.println("Enter the new address:");
        String newAddress = scanner.nextLine();
        System.out.println("Enter the new city:");
        String newCity = scanner.nextLine();
        System.out.println("Enter the new state:");
        String newState = scanner.nextLine();
        System.out.println("Enter the new ZIP code:");
        String newZip = scanner.nextLine();
        System.out.println("Enter the new phone number:");
        String newPhoneNumber = scanner.nextLine();
        System.out.println("Enter the new email address:");
        String newEmail = scanner.nextLine();

        ContactPerson newContact = new ContactPerson(newFirstName, newLastName, newAddress, newCity, newState, newZip, newPhoneNumber, newEmail);
        addressBook.editContact(firstName, lastName, newContact);
        System.out.println("Contact edited successfully.");
    }

    // Helper method to delete a contact
    private static void deleteContact(Scanner scanner) {
        System.out.println("Enter the address book name:");
        String addressBookName = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("Address book not found.");
            return;
        }

        System.out.println("Enter the first name of the contact to delete:");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the contact to delete:");
        String lastName = scanner.nextLine();

        addressBook.deleteContact(firstName, lastName);
        System.out.println("Contact deleted successfully.");
    }

    // Helper method to search contacts by city
    private static void searchByCity(Scanner scanner) {
        System.out.println("Enter the city to search for:");
        String city = scanner.nextLine();

        List<ContactPerson> results = new ArrayList<>();
        for (AddressBook addressBook : addressBooks.values()) {
            results.addAll(addressBook.searchByCity(city));
        }

        if (results.isEmpty()) {
            System.out.println("No contacts found in the given city.");
        } else {
            System.out.println("Search results:");
            for (ContactPerson contact : results) {
                System.out.println(contact);
            }
        }
    }

    // Helper method to search contacts by state
    private static void searchByState(Scanner scanner) {
        System.out.println("Enter the state to search for:");
        String state = scanner.nextLine();

        List<ContactPerson> results = new ArrayList<>();
        for (AddressBook addressBook : addressBooks.values()) {
            results.addAll(addressBook.searchByState(state));
        }

        if (results.isEmpty()) {
            System.out.println("No contacts found in the given state.");
        } else {
            System.out.println("Search results:");
            for (ContactPerson contact : results) {
                System.out.println(contact);
            }
        }
    }

    // Helper method to count contacts by city
    private static void countByCity(Scanner scanner) {
        System.out.println("Enter the city to count contacts for:");
        String city = scanner.nextLine();

        int count = 0;
        for (AddressBook addressBook : addressBooks.values()) {
            count += addressBook.getCountByCity(city);
        }

        System.out.println("Number of contacts in the city: " + count);
    }

    // Helper method to count contacts by state
    private static void countByState(Scanner scanner) {
        System.out.println("Enter the state to count contacts for:");
        String state = scanner.nextLine();

        int count = 0;
        for (AddressBook addressBook : addressBooks.values()) {
            count += addressBook.getCountByState(state);
        }

        System.out.println("Number of contacts in the state: " + count);
    }

    // Helper method to sort contacts by name
    private static void sortContactsByName(Scanner scanner) {
        System.out.println("Enter the address book name:");
        String addressBookName = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("Address book not found.");
            return;
        }

        addressBook.sortContactsByName();
        System.out.println("Contacts sorted by name:");
        System.out.println(addressBook);
    }

    // Helper method to sort contacts by city
    private static void sortContactsByCity(Scanner scanner) {
        System.out.println("Enter the address book name:");
        String addressBookName = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("Address book not found.");
            return;
        }

        addressBook.sortContactsByCity();
        System.out.println("Contacts sorted by city:");
        System.out.println(addressBook);
    }

    // Helper method to sort contacts by state
    private static void sortContactsByState(Scanner scanner) {
        System.out.println("Enter the address book name:");
        String addressBookName = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("Address book not found.");
            return;
        }

        addressBook.sortContactsByState();
        System.out.println("Contacts sorted by state:");
        System.out.println(addressBook);
    }

    // Helper method to sort contacts by ZIP
    private static void sortContactsByZIP(Scanner scanner) {
        System.out.println("Enter the address book name:");
        String addressBookName = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("Address book not found.");
            return;
        }

        addressBook.sortContactsByZIP();
        System.out.println("Contacts sorted by ZIP:");
        System.out.println(addressBook);
    }
}
