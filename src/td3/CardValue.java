package td3;

public enum CardValue {
    deux(2), trois(3), quatre(4), cinq(5), six(6), sept(7), huit(8), neuf(9), dix(10), valet(10), dame(10), roi(10),
    as(20);

    private final Integer value;

    CardValue(Integer v) {
        value = v;
    }

    public Integer getValue() {
        return value;
    }
}