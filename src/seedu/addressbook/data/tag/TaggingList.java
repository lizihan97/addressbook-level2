package seedu.addressbook.data.tag;

import java.util.ArrayList;
import java.util.List;

public class TaggingList {
	private final List<Tagging> taggingList = new ArrayList<>();
	
    public void addTagging(Tagging tagging){
    	taggingList.add(tagging);
    }
    
    public void deleteTagging(Tagging tagging){
    	taggingList.add(tagging);
    }
}
