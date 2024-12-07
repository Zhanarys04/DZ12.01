public class LibrarySystemTest {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("1", "Война и мир", "Лев Толстой", "Роман");
        library.addBook("2", "Преступление и наказание", "Фёдор Достоевский", "Роман");
        library.addBook("3", "Мастер и Маргарита", "Михаил Булгаков", "Фантастика");

        library.addUser("u1", "Иван", "Читатель");
        library.addUser("u2", "Анна", "Библиотекарь");

        library.searchBooks("Роман");

        library.bookReservation("Иван", "1");

        library.bookReservation("Анна", "1");

        library.showBookingHistory("Иван");

        library.cancelReservation("Иван", "1");

        library.bookReservation("Анна", "1");
    }
}
