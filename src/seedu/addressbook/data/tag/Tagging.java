package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
	Tag _tag;
	Person _person;
	String _operation;
	
	public Tagging(Tag tag, Person person, String operation) {
		_tag = tag;
		_person = person;
		_operation = operation;
	}
}
