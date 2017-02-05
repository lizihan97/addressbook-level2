package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact information in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class Contact {
	public static String EXAMPLE;
    public static String MESSAGE_CONTACT_CONSTRAINTS;
    public static String CONTACT_VALIDATION_REGEX;

    public final String value;
    private boolean isPrivate;
    
    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact is invalid.
     */
    public Contact(String contact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }
    
    /**
     * Checks if a given string is a valid contact.
     */
    public static boolean isValidContact(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
