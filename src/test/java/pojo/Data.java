package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("CourseName") // Map JSON field "CourseName" to this field
    private String courseName;

    @JsonProperty("Purchasedate") // Map JSON field "Purchasedate" to this field
    private String purchasedate;

    @JsonProperty("Amount") // Map JSON field "Amount" to this field
    private int amount;

    @JsonProperty("Location") // Map JSON field "Location" to this field
    private String location;

    // Getters and Setters

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        this.purchasedate = purchasedate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
