package pojo;


import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class BookingExpected {

    private Integer bookingid;
    private BookingBody booking;

    /**
     * No args constructor for use in serialization
     *
     */
    public BookingExpected() {
    }

    /**
     *
     * @param booking
     * @param bookingid
     */
    public BookingExpected(Integer bookingid, BookingBody booking) {
        super();
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingBody getBooking() {
        return booking;
    }

    public void setBooking(BookingBody booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BookingExpected.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bookingid");
        sb.append('=');
        sb.append(((this.bookingid == null)?"<null>":this.bookingid));
        sb.append(',');
        sb.append("booking");
        sb.append('=');
        sb.append(((this.booking == null)?"<null>":this.booking));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}