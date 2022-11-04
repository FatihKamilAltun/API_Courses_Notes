package pojos;

public class BookingDatesPojo {

    // tum keyler icin private variable'lar oluşturalim
    private String checkin;
    private String checkout;

    // tum parametrelerle ve parametresiz constructorlar olusturalim
    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    // getter ve setter methodlari olusturalim
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    // toString() methodunu olusturalim
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
