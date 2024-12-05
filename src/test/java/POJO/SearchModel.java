package POJO;

import lombok.Getter;

@Getter
public class SearchModel {

    private String searchInput;

    public SearchModel(){

    }
    public SearchModel(String searchInput){
        this.searchInput = searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }
    @Override
    public String toString() {
        return "SearchModel value: {\n" +
                "searchInput='" + searchInput;
                }
    }


