package tasks.task3.data;

import tasks.task3.model.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Serialization {
   private static final String path =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task3/data/students.xml";

    public static void main(String[] args) {
        StudentList list = new StudentList();
        try(FileWriter fw = new FileWriter(path,true)) {
            JAXBContext jaxb = JAXBContext.newInstance(Student.class, StudentList.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(list, fw);
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
//        deserialize();
    }
    public static void deserialize() {
        try(FileInputStream fr = new FileInputStream(path)) {
            JAXBContext context = JAXBContext.newInstance(StudentList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StudentList studentList = (StudentList) unmarshaller.unmarshal(fr);
            System.out.println(studentList);

        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}