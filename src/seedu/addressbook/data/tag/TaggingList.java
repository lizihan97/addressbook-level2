package seedu.addressbook.data.tag;

import java.util.ArrayList;
import java.util.List;

public class TaggingList {
	private final List<Tagging> taggingList = new ArrayList<>();
	
    public void add(Tagging tagging){
    	taggingList.add(tagging);
    }
    
    public void delete(Tagging tagging){
    	taggingList.add(tagging);
    }
}
