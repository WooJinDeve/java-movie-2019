package domain.payment;

import java.util.Arrays;

public enum PayGroupAdvanced {
    CASH(1,"현금",0.98),
    CARD(2,"카드",0.95);
    private int typeNum;
    private String title;
    private double discountRete;
    PayGroupAdvanced(int typeNum, String title, double discountRete) {
        this.typeNum = typeNum;
        this.title = title;
        this.discountRete = discountRete;
    }

    public static PayGroupAdvanced findByPayType(int typeNum){
        return Arrays.stream(PayGroupAdvanced.values())
                .filter(payGroup -> payGroup.hasTypeNum(typeNum))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean hasTypeNum(int typeNum){
        return this.typeNum == typeNum;
    }

    public static double discountPrice(PayGroupAdvanced payGroupAdvanced, int price){
        return price * payGroupAdvanced.discountRete;
    }
}
