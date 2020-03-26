package org.itadventure.covid.entity.base;



public enum StatusRecord  {
    ACTIV("active"),
    NEW("new"),
    INPRO("inprogress"),
    INACT("inactive"),
    RECYC("recycled"),
    ARCHI("archived");

    private final String code;

    private StatusRecord(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.getDesc();
    }
}