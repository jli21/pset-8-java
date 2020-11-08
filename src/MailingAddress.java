  
public class MailingAddress {

    String primaryStreet;
    String secondaryStreet;
    String city;
    String state;
    String postalCode;

    public MailingAddress(String primaryStreet, String secondaryStreet, String city, String state, String postalCode) {

        this.primaryStreet = primaryStreet;
        this.secondaryStreet = secondaryStreet;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;

    }

    public void setPrimaryStreet(String primaryStreet) {
        this.primaryStreet = primaryStreet;
    }

    public void setSecondaryStreet(String secondaryStreet) {
        this.secondaryStreet = secondaryStreet;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFormattedAddress() {

        if (!validateAddress()) {
            return "N/A";
        }

        if (secondaryStreet == null) {
            return primaryStreet + "\n" + city + ", " + state + " " + postalCode;
        }
        else {
            return primaryStreet + "\n" + secondaryStreet + "\n" + city + ", " + state + " " + postalCode;
        }

    }

    private boolean validateAddress() {
        if (primaryStreet.length() == 0) {
            return false;
        }
        if (secondaryStreet.length() == 0) {
            return false;
        }
        if (city.length() == 0) {
            return false;
        }
        if (state.length() == 0) {
            return false;
        }
        if (postalCode.length() == 0) {
            return false;
        }
        return true;
    }

}