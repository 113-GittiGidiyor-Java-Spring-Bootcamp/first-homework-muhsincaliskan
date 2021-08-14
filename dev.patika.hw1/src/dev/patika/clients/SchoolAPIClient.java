package dev.patika.clients;

import dev.patika.controllers.CourseController;
import dev.patika.controllers.InstructorController;
import dev.patika.controllers.StudentController;
import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class SchoolAPIClient {
    public static void main(String[] args) {
        if(checkTestData() == 0){
            saveTestData();
        }

        StudentController studentController = new StudentController();
        InstructorController instructorController=new InstructorController();
        CourseController courseController=new CourseController();



        /*
            Tested saving new customer
         */
         Student newStudent = new Student("Hoca5", "istanbul","Male", new Date(1996, 1, 6) );

        /*
            Tested finding all data
         */
        List<Student> returnedList = studentController.findAllStudent();
        for (Student student : returnedList) {
            System.out.println(student);
        }
        List<Course> courseList = courseController.findAllCourse();
        for (Course course : courseList) {
            System.out.println(course);
        }
        List<Instructor> instructorList = instructorController.findAllInstructors();
        for (Instructor instructor : instructorList) {
            System.out.println(instructor);
        }


         /*
            Tested finding course instructor
         */

        Instructor instructor= courseController.getInstructor(1);
        System.out.println(instructor );



        System.exit(0);
    }
    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("from Student", Student.class).getResultList().size();
    }


    private static void saveTestData() {

        Student student1 = new Student("Muhsin","Ankara","Male",new Date(1996, 1, 6));
        Student student2 = new Student("Ahmet","İstanbul","Male",new Date(1996, 1, 1));
        Student student3 = new Student("Volkan","Eskişehir","Male",new Date(1996, 7, 4));
        Student student4 = new Student("Furkan","İzmir","Male",new Date(1996, 11, 5));
        Student student5 = new Student("Selin","Kayseri","Male",new Date(1996, 8, 9));

        Instructor instructor1=new PermanentInstructor("Hoca1","Ankara",123456767,4000);
        Instructor instructor2=new VisitingResearches("Hoca2","İstanbul",13566577,12345);
        Instructor instructor3=new Instructor("Hoca3","İzmir",123456789);

        Course course1= new Course("Java","1232",20);
        Course course2= new Course("Javascript","1234",25);
        Course course3= new Course("SQL","1235",10);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);

        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);
        course1.getStudentList().add(student3);

        course2.getStudentList().add(student2);
        course2.getStudentList().add(student3);
        course2.getStudentList().add(student4);

        course3.getStudentList().add(student1);
        course3.getStudentList().add(student3);
        course3.getStudentList().add(student5);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.persist(instructor1);
            em.persist(instructor2);
            em.persist(instructor3);

            em.getTransaction().commit();

            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
