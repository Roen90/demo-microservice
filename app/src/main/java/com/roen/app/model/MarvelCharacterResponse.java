package com.roen.app.model;

import java.io.Serializable;

public class MarvelCharacterResponse implements Serializable {

    static final long serialVersionUID = 137491509508950118L;

    private Integer code;
    private String status;
    private String copyright;

    private MarvelCharacterData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public MarvelCharacterData getData() {
        return data;
    }

    public void setData(MarvelCharacterData data) {
        this.data = data;
    }
}
