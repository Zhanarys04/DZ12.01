class LibrarySystem {
    private List<Book> books;
    private List<User> users;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(String id, String title, String author, String genre) {
        books.add(new Book(id, title, author, genre));
    }

    public void addUser(String id, String name, String role) {
        users.add(new User(id, name, role));
    }

    public void searchBooks(String keyword) {
        System.out.println("Результаты поиска:");
        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword) || book.getGenre().contains(keyword)) {
                System.out.println(book);
            }
        }
    }

    public void bookReservation(String userId, String bookId) {
        User user = users.stream().filter(u -> u.getName().equals(userId)).findFirst().orElse(null);
        Book book = books.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);

        if (user != null && book != null && book.isAvailable()) {
            book.setAvailable(false);
            user.addBooking(book.getTitle());
            System.out.println("Книга \"" + book.getTitle() + "\" успешно забронирована для пользователя " + user.getName() + ".");
        } else {
            System.out.println("Бронирование невозможно. Проверьте доступность книги или правильность данных.");
        }
    }

    public void cancelReservation(String userId, String bookId) {
        User user = users.stream().filter(u -> u.getName().equals(userId)).findFirst().orElse(null);
        Book book = books.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);

        if (user != null && book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Бронирование книги \"" + book.getTitle() + "\" отменено для пользователя " + user.getName() + ".");
        } else {
            System.out.println("Отмена невозможна. Проверьте статус бронирования.");
        }
    }

    public void showBookingHistory(String userId) {
        User user = users.stream().filter(u -> u.getName().equals(userId)).findFirst().orElse(null);

        if (user != null) {
            System.out.println("История бронирований пользователя " + user.getName() + ":");
            for (String booking : user.getBookingHistory()) {
                System.out.println("- " + booking);
            }
        } else {
            System.out.println("Пользователь не найден.");
        }
    }
}
