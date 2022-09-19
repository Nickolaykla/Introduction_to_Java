package tasks.task1;

import tasks.task1.controllers.FileWorker;

import static tasks.task1.controllers.FileWorker.BOOKS_TXT;
import static tasks.task1.controllers.FileWorker.USERS_TXT;

public class Main {
    public static void main(String[] args) {

       FileWorker.readUsersFromFile(USERS_TXT);
       FileWorker.readBooksFromFile(BOOKS_TXT);

       LibraryMenu.startMenu();
    }
}