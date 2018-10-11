package com.telran.repeat.model;

public class Group {
    private  String nameGroup;
    private  String headerGroup;
    private  String footerGroup;

    public Group withNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
        return this;
    }

    public Group  withHeaderGroup(String headerGroup) {
        this.headerGroup = headerGroup;
        return this;
    }

    public Group withFooterGroup(String footerGroup) {
        this.footerGroup = footerGroup;
        return this;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public String getHeaderGroup() {
        return headerGroup;
    }

    public String getFooterGroup() {
        return footerGroup;
    }
}
