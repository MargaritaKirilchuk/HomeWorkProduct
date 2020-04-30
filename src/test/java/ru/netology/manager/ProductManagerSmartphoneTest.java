package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerSmartphoneTest {
    private Smartphone firstPhone = new Smartphone(1,"Galaxy",1000, "Samsung");
    private Smartphone secondPhone = new Smartphone(1,"iPhone11",1000, "Apple");
    private Smartphone thirdPhone = new Smartphone(1,"RedmiNote",1000, "Xiaomi");
    private Smartphone fourthPhone = new Smartphone(1,"iPhoneX",1000, "Apple");
    private Smartphone fifthPhone = new Smartphone(1,"GalaxyNote",1000, "Samsung");


    @Test
    void searchByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(fourthPhone);
        manager.add(fifthPhone);

        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Smartphone[]{firstPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(fourthPhone);
        manager.add(fifthPhone);

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Smartphone[]{secondPhone, fourthPhone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneNoExist() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(fourthPhone);
        manager.add(fifthPhone);

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Smartphone[]{};

        assertArrayEquals(expected, actual);
    }


}