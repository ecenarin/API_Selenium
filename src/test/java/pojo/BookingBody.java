package pojo;


import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class BookingBody {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    /**
     * No args constructor for use in serialization
     *
     */
    public BookingBody() {
    }

    /**
     *
     * @param firstname
     * @param additionalneeds
     * @param bookingdates
     * @param totalprice
     * @param depositpaid
     * @param lastname
     */
    public BookingBody(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Bookingdates bookingdates, String additionalneeds) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BookingBody.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("firstname");
        sb.append('=');
        sb.append(((this.firstname == null)?"<null>":this.firstname));
        sb.append(',');
        sb.append("lastname");
        sb.append('=');
        sb.append(((this.lastname == null)?"<null>":this.lastname));
        sb.append(',');
        sb.append("totalprice");
        sb.append('=');
        sb.append(((this.totalprice == null)?"<null>":this.totalprice));
        sb.append(',');
        sb.append("depositpaid");
        sb.append('=');
        sb.append(((this.depositpaid == null)?"<null>":this.depositpaid));
        sb.append(',');
        sb.append("bookingdates");
        sb.append('=');
        sb.append(((this.bookingdates == null)?"<null>":this.bookingdates));
        sb.append(',');
        sb.append("additionalneeds");
        sb.append('=');
        sb.append(((this.additionalneeds == null)?"<null>":this.additionalneeds));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
