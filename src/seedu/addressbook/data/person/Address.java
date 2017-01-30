package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should follow this format:"
    		                                                 + "a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_DELIMITING_REGEX = ",";

    public AddressBlock block;
    public AddressStreet street;
    public AddressUnit unit;
    public AddressPostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] splittedAddress = trimmedAddress.split(ADDRESS_DELIMITING_REGEX);
        this.block = new AddressBlock(splittedAddress[0]);
        this.street = new AddressStreet(splittedAddress[1]);
        this.unit = new AddressUnit(splittedAddress[2]);
        this.postalCode = new AddressPostalCode(splittedAddress[3]);
    }
    
    public class AddressBlock {
    	private final String blockValue;
    	private AddressBlock(String block) {
    		this.blockValue = block;
    	}
    	private String getBlock() {
    		return this.blockValue;
    	}
    }
    
    public class AddressStreet {
    	private final String streetValue;
    	private AddressStreet(String street) {
    		this.streetValue = street;
    	}
    	private String getStreet() {
    		return this.streetValue;
    	}
    }
    
    public class AddressUnit {
    	private final String unitValue;
    	private AddressUnit(String unit) {
    		this.unitValue = unit;
    	}
    	private String getUnit() {
    		return this.unitValue;
    	}
    }
    
    public class AddressPostalCode {
    	private final String postalCodeValue;
    	private AddressPostalCode(String postalCode) {
    		this.postalCodeValue = postalCode;
    	}
    	private String getPostalCode() {
    		return this.postalCodeValue;
    	}
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.split(ADDRESS_DELIMITING_REGEX).length == 4;
    }
    
    public String makeAddress(AddressBlock block, AddressStreet street, AddressUnit unit, AddressPostalCode postalCode) {
    	String fullAddressString = "";
    	fullAddressString += block.getBlock() + ",";
    	fullAddressString += street.getStreet() + ",";
    	fullAddressString += unit.getUnit() + ",";
    	fullAddressString += postalCode.getPostalCode();
    	return fullAddressString;
    }

    @Override
    public String toString() {
        return this.makeAddress(this.block, this.street, this.unit, this.postalCode);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
