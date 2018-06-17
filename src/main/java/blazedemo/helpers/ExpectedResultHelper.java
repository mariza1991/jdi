package blazedemo.helpers;

public class ExpectedResultHelper {

    public static String getCardNumber(String cardNumber)
    {
        for (int i = 0; i < cardNumber.length() - 4; i++) {
            cardNumber = cardNumber.substring(0,i) + 'x' + cardNumber.substring(i+1);
        }
        return cardNumber;
    }

    public static String getPrice(String price){
        String[] result = price.split("\\s");
        return result[result.length - 1];
    }
}
