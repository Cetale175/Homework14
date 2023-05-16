package ProductManager;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void testAdd() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book( id: 1, name: "Harry Potter 1", price: 100, auhor: "Rowlling");
        Book book2 = new Book( id: 2, name: "War and Piece", price: 200, auhor: "Tolstoy");
        Book book3 = new Book( id: 3, name: "Harry Potter 2", price: 150, auhor: "Rowlling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearchByWhenFewProductsFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book( id: 1, name: "Harry Potter 1", price: 100, auhor: "Rowlling");
        Book book2 = new Book( id: 2, name: "War and Piece", price: 200, auhor: "Tolstoy");
        Book book3 = new Book( id: 3, name: "Harry Potter 2", price: 150, auhor: "Rowlling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy(text: "Potter");
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    class ProductRepositoryTest {


        @Test
        public void testRemoveWhenIdExist() {
            ProductRepository repo = new ProductRepository();
            ProductManager manager = new ProductManager(repo);
            Book book1 = new Book( id: 1, name: "Harry Potter 1", price: 100, auhor: "Rowlling");
            Book book2 = new Book( id: 2, name: "War and Piece", price: 200, auhor: "Tolstoy");
            Book book3 = new Book( id: 3, name: "Harry Potter 2", price: 150, auhor: "Rowlling");

            repo.add(book1);
            repo.add(book2);
            repo.add(book3);
            repo.removeById(remove: 1);
            Product[] actual = repo.findAll();
            Product[] expected = {book1, book3};
            Assertions.assertArrayEquals(expected, actual);


