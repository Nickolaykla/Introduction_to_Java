package tasks.task3;

import tasks.task3.controller.StudentArchive;
import tasks.task3.controller.UserLogging;
import tasks.task3.model.Role;
import tasks.task3.model.User;


public class Test {
    public static void main(String[] args) {
        UserLogging.getFromXml().getAllusers().forEach(System.out::println);
    }
}
