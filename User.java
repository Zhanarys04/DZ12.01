
class User {
    private String id;
    private String name;
    private String role;
    private List<String> bookingHistory;

    public User(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.bookingHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void addBooking(String bookTitle) {
        bookingHistory.add(bookTitle);
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }
}
