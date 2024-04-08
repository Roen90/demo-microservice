package com.roen.app.model;

import java.io.Serializable;
import java.util.List;

public class MarvelCharacterData implements Serializable {

    static final long serialVersionUID = 6907920719162709588L;

    private Integer offset;
    private Integer limit;
    private Integer total;
    private Integer count;
    private List<MarvelCharacter> results;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<MarvelCharacter> getResults() {
        return results;
    }

    public void setResults(List<MarvelCharacter> results) {
        this.results = results;
    }
}
