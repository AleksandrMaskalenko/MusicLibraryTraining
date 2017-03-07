package springlibrary.objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springlibrary.enums.SearchType;

import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("singleton")
public class Utils {

    private Map<String, SearchType> searchTypeList = new HashMap<String, SearchType>();
    private String searchString;

    @Autowired
    private MessageSource msg;

    private Character[] letters = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public Character[] getLetters() {
        return letters;
    }

    public Map<String, SearchType> getSearchTypeList() {
        searchTypeList.clear();
        searchTypeList.put(msg.getMessage("author_name", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.AUTHOR);
        searchTypeList.put(msg.getMessage("song_name", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.TITLE);
        return searchTypeList;
    }


    public void setSearchTypeList(Map<String, SearchType> searchTypeList) {
        this.searchTypeList = searchTypeList;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
