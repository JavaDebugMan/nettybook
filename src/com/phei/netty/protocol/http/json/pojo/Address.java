package com.phei.netty.protocol.http.json.pojo;

/**
 * Address information.
 */
public class Address {
    /**
     * First line of street information (required).
     * 街道1
     */
    private String street1;

    /**
     * Second line of street information (optional).
     * 街道2
     */
    private String street2;
    /**
     * 城市
     */
    private String city;

    /**
     * State abbreviation (required for the U.S. and Canada, optional
     * otherwise).
     * 州,省份
     */
    private String state;

    /**
     * Postal code (required for the U.S. and Canada, optional otherwise).
     * 邮政编码
     */
    private String postCode;

    /**
     * Country name (optional, U.S. assumed if not supplied).
     * 国家
     */
    private String country;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Address [street1=" + street1 + ", street2=" + street2
                + ", city=" + city + ", state=" + state + ", postCode="
                + postCode + ", country=" + country + "]";
    }
}