package nnk.com.rtrofitexamle.Model;

import com.google.gson.annotations.SerializedName;

public class EnterpriseModel {
    @SerializedName("id")
    private int id;
    @SerializedName("enterprise_name")
    private String enterprise_name;
    @SerializedName("description")
    private String description;
    @SerializedName("email_enterprise")
    private String email_enterprise;
    @SerializedName("facebook")
    private String facebook;
    @SerializedName("twitter")
    private String twitter;
    @SerializedName("linkedin")
    private String linkedin;
    @SerializedName("phone")
    private String phone;
    @SerializedName("own_enterprise")
    private String own_enterprise;
    @SerializedName("photo")
    private String photo;
    @SerializedName("value")
    private String value;
    @SerializedName("shares")
    private String shares;
    @SerializedName("share_price")
    private String share_price;
    @SerializedName("own_shares")
    private String own_shares;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("enterprise_type")
    private TypeEnterpriseModel type_enterprise_model;

    public EnterpriseModel(int id, String enterprise_name,
                           String description, String email_enterprise,
                           String facebook, String twitter,
                           String linkedin, String phone,
                           String own_enterprise, String photo,
                           String value, String shares,
                           String share_price, String own_shares,
                           String city, String country,
                           TypeEnterpriseModel type_enterprise_model) {

        this.id = id;
        this.enterprise_name = enterprise_name;
        this.description = description;
        this.email_enterprise = email_enterprise;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedin = linkedin;
        this.phone = phone;
        this.own_enterprise = own_enterprise;
        this.photo = photo;
        this.value = value;
        this.shares = shares;
        this.share_price = share_price;
        this.own_shares = own_shares;
        this.city = city;
        this.country = country;
        this.type_enterprise_model = type_enterprise_model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail_enterprise() {
        return email_enterprise;
    }

    public void setEmail_enterprise(String email_enterprise) {
        this.email_enterprise = email_enterprise;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwn_enterprise() {
        return own_enterprise;
    }

    public void setOwn_enterprise(String own_enterprise) {
        this.own_enterprise = own_enterprise;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getShare_price() {
        return share_price;
    }

    public void setShare_price(String share_price) {
        this.share_price = share_price;
    }

    public String getOwn_shares() {
        return own_shares;
    }

    public void setOwn_shares(String own_shares) {
        this.own_shares = own_shares;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TypeEnterpriseModel getType_enterprise_model() {
        return type_enterprise_model;
    }

    public void setType_enterprise_model(TypeEnterpriseModel type_enterprise_model) {
        this.type_enterprise_model = type_enterprise_model;
    }
}
