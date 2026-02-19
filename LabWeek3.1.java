import java.time.LocalDate;

public class Sale {
    public int id;
    public LocalDate date;
    public double price;
    public String name;
    public Sale(int id, LocalDate date, double price, String name) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + ", Date: " + date + ", Price: $" + price + ", Name: " + name + "\n";
    }
}
