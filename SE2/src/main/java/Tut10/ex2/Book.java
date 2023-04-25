package Tut10.ex2;

public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author.trim());
        this.setTitle(title);
        this.setPrice(price);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        author = author.trim();
        if (author.contains(" ")) {
            String secondName = author.substring(author.indexOf(" ") + 1);
            if (secondName.startsWith("0")
                    || secondName.startsWith("1")
                    || secondName.startsWith("2")
                    || secondName.startsWith("3")
                    || secondName.startsWith("4")
                    || secondName.startsWith("5")
                    || secondName.startsWith("6")
                    || secondName.startsWith("7")
                    || secondName.startsWith("8")
                    || secondName.startsWith("9")) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
