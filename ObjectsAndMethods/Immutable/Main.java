

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Братья Карамазовы", "Достоевский Федор Михайлович", 992, "978-5-17-139129-4");
        Book book2 = new Book("Защита Лужина", "Набоков Владимир Владимирович", 288, "978-5-17-137825-7");

        String infoBook = "Информация о книге: \n"
                + "\tНазвание: " + book1.getNameBook()
                + "\n\tАвтор: " + book1.getAuthor()
                + "\n\tКоличество страниц" + book1.getPagesCount() + " стр. "
                + "\n\tномер ISBN" + book1.getIsbn();
        System.out.println(infoBook);

        infoBook = "Информация о книге: \n"
                + "\tНазвание: " + book2.getNameBook()
                + "\n\tАвтор: " + book2.getAuthor()
                + "\n\tКоличество страниц" + book2.getPagesCount() + " стр. "
                + "\n\tномер ISBN" + book2.getIsbn();
        System.out.println(infoBook);

        Product product = new Product("Eggs", 123456789000l);
        product.setPrice(60);
        String infoProduct = "Информация о продукте: "
                + "\n\tНаименование: " + product.getName()
                + "\n\tЦена: " + product.getPrice() + " руб. "
                + "\n\tBarCode:"+ product.getBarCode();
        System.out.println(infoProduct);


    }
}
