package ATM;

public class Card {
    String cardNumber;
    String atmPin;
    User cardUser;

    public Card(String cardNum, String pin, User user){
        cardNumber = cardNum;
        atmPin = pin;
        cardUser = user;
    }

    public String getAtmPin(){
        return atmPin;
    }
}
