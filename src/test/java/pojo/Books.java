package pojo;

public class Books {
    private String CourseName;
    private String Purchasedate;
    private int Amount;

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getPurchasedate() {
        return Purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        Purchasedate = purchasedate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    private String Location;


}
