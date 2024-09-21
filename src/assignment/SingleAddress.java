package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SingleAddress {
    private String lastName;
    private String firstName;
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;

    public SingleAddress(String lastName, String firstName, String streetAddress, String city, String country, String postalCode) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + streetAddress + ", " + city + ", " + country;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SingleAddress that = (SingleAddress) obj;
        return Objects.equals(this.lastName, that.lastName) && Objects.equals(this.firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        int a = this.firstName.toLowerCase().hashCode();
        int b = this.lastName.toLowerCase().hashCode();
        return a+b;
    }
}

interface AddressBook {
    void addAddress(SingleAddress address) throws DuplicateAddressException;
    void removeAddress(String firstName, String lastName) throws AddressNotFoundException;
    String toString();
}

class AddressBookImpl implements AddressBook {
    private List<SingleAddress> addressList;

    public AddressBookImpl() {
        addressList = new ArrayList<>();
    }

    @Override
    public void addAddress(SingleAddress address) throws DuplicateAddressException {
        for (SingleAddress existingAddress : addressList) {
            if (existingAddress.getFirstName().equalsIgnoreCase(address.getFirstName()) && existingAddress.getLastName().equalsIgnoreCase(address.getLastName().toLowerCase())) {
                throw new DuplicateAddressException("Address already exists");
            }
        }
        addressList.add(address);
    }

    @Override
    public void removeAddress(String firstName, String lastName) throws AddressNotFoundException {
        for (SingleAddress address : addressList) {
            if (address.getFirstName().equalsIgnoreCase(firstName) && address.getLastName().equalsIgnoreCase(lastName)) {
                addressList.remove(address);
                System.out.println("Address removed successfully");
            }
        }
        throw new AddressNotFoundException("Address not found");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SingleAddress address : addressList) {
            sb.append(address.toString()).append("\n");
        }
        return sb.toString();
    }
}

class TestAddressBook {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBookImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add address");
            System.out.println("2. Delete address");
            System.out.println("3. Show all user details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.next();
                    System.out.print("Enter street address: ");
                    String streetAddress = scanner.next();
                    System.out.print("Enter city: ");
                    String city = scanner.next();
                    System.out.print("Enter country: ");
                    String country = scanner.next();
                    System.out.print("Enter postal code: ");
                    String postalCode = scanner.next();

                    SingleAddress address = new SingleAddress(lastName, firstName, streetAddress, city, country, postalCode);
                    try {
                        addressBook.addAddress(address);
                        System.out.println("Address added successfully");
                    } catch (DuplicateAddressException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter first name: ");
                    firstName = scanner.next();
                    System.out.print("Enter last name: ");
                    lastName = scanner.next();

                    try {
                        addressBook.removeAddress(firstName, lastName);
                        System.out.println("Address removed successfully");
                    } catch (AddressNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(addressBook.toString());
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

class DuplicateAddressException extends Exception {
    public DuplicateAddressException(String message) {
        super(message);
    }
}

class AddressNotFoundException extends Exception {
    public AddressNotFoundException(String message) {
        super(message);
    }
}