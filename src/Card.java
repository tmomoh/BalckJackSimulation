public class Card {
    private int value;

    public Card(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Card value: " + this.getValue() +"\n";
    }
}
