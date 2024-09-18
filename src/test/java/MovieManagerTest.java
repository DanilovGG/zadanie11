import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void testFindAll() {
        MovieManager m = new MovieManager();

        m.addMovie("Бладшот");
        m.addMovie("Вперед");
        m.addMovie("Отель \"Белград\"");
        m.addMovie("Джентельмены");
        m.addMovie("Человек-невидимка");

        String[] expected = {"Бладшот", "Вперед", "Отель \"Белград\"", "Джентельмены", "Человек-невидимка"};
        String[] actual = m.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLast() {
        MovieManager m = new MovieManager();

        m.addMovie("Бладшот");
        m.addMovie("Вперед");
        m.addMovie("Отель \"Белград\"");
        m.addMovie("Джентельмены");
        m.addMovie("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентельмены", "Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = m.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLast_OverLimit_PartiallyFilled() {
        MovieManager m = new MovieManager(7);

        m.addMovie("Бладшот");
        m.addMovie("Вперед");
        m.addMovie("Отель \"Белград\"");
        m.addMovie("Джентельмены");
        m.addMovie("Человек-невидимка");
        m.addMovie("Тролли. Мировой тур");
        m.addMovie("Номер один");
        m.addMovie("Люди Х");
        m.addMovie("Человек-паук");

        String[] expected = {"Человек-паук", "Люди Х", "Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель \"Белград\""};
        String[] actual = m.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testConstructorWithLimit() {
        MovieManager customLimitManager = new MovieManager(6);

        int expected = 6;
        int actual = customLimitManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }
}
