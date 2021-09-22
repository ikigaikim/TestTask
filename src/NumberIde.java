class NumberIde {

    private int value;
    private NumberType type;

     public NumberIde (int value, NumberType type) {
        this.value = value;
        this.type = type;
    }

     int getValue() {
        return value;
    }

    NumberType getType() {
        return type;
    }
}
