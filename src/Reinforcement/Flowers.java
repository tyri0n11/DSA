package Reinforcement;

public class Flowers {
    private String name;
    private int numbers;
    private float price;

    public Flowers() {
    }

    public Flowers(String name) {
        this.name = name;
    }

    public Flowers(int numbers) {
        this.numbers = numbers;
    }

    public Flowers(float price) {
        this.price = price;
    }

    public Flowers(String name, int numbers, float price) {
        this.name = name;
        this.numbers = numbers;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
