public class DigitalArchive {
public static void main(String[] args) {
}
class Book {
private String title;
private int pageCount;
private String isbn;
private double price;
public Book(String title, int pageCount, String isbn, double price) {
this.isbn = isbn;
this.pageCount = pageCount;
this.title = title;
this.price = price;
}
//gettters and setters
public String gettitle() {
return title;
}
public double getPrice() {
return price;
}
public String getIsbn() {
return isbn;
}
public String getTitle() {
return title;
}
public int getPageCount() {
return pageCount;
}
public void setTitle(String title) {
this.title = title;
}
public void setPageCount(int pageCount) {
this.pageCount = pageCount;
}
public void setIsbn(String isbn) {
this.isbn = isbn;
}
public void setPrice(double price) {
this.price = price;
}
}
class Librarian {
private String name;
private int employeeID;
private int age;
private Book[] libsBooks;
private int BookCount;
//getters and setters
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public int getEmployeeID() {
return employeeID;
}
public void setEmployeeID(int employeeID) {
this.employeeID = employeeID;
}
public int getAge() {
return age;
}
public void setAge(int age) {
this.age = age;
}
public Book[] getLibsBooks() {
return libsBooks;
}
public void setLibsBooks(Book[] libsBooks) {
this.libsBooks = libsBooks;
}
public int getBookCount() {
return BookCount;
}
public void setBookCount(int bookCount) {
BookCount = bookCount;
}
public Librarian(int employeeID, String name, int age) {
this.age = age;
this.name = name;
this.employeeID = employeeID;
this.libsBooks = new Book[5];
this.BookCount = BookCount;
}
public void addBook(Book book) {
if (BookCount < 5) {
libsBooks[BookCount] = book;
BookCount++;
} else {
System.out.println("librarian book count is full.");
}
}
public void removeBook(String isbn) {
for (int i = 0; i < BookCount; i++) {
if (libsBooks[i].getIsbn().equals(isbn)) {
for (int x = i; x < BookCount - 1; x++) {
libsBooks[x] = libsBooks[x + 1];
}
}
}
}
public Book findBook(String isbn) {
for (int i = 0; i < BookCount; BookCount++) {
if (libsBooks[i].getIsbn().equals(isbn)) {
return libsBooks[i];
}
}
return null;
}
public void updatePrice(Book book, double newPrice) {
findBook(book.getIsbn()).setPrice(newPrice);
}
public void findbookAndApplyDiscount(String isbn, double disountPercentage) {
Book book = findBook(isbn);
double newPrice = book.getPrice() - (disountPercentage / 100);
}
public void displayAllBooks() {
for (int i = 0; i < BookCount; i++) {
System.out.println(libsBooks);
}
}
}
}
