package com.isthifa.Student;

import com.isthifa.Student.dao.StudentDAO;
import com.isthifa.Student.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StudentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner->
		{
			readStudentbyId(studentDAO);
		};
	}

	private void readStudentbyId(StudentDAO studentDAO) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student id");
		int a=sc.nextInt();
		Student student=studentDAO.findById(a);
		System.out.println(student);
	}

	private void createMulti(StudentDAO studentDAO) {
		//creating student object
		Student temp1=new Student("test","t1","t1@gmail.com");
		Student temp2=new Student("test","t2","t2@gmail.com");
		Student temp3=new Student("test","t3","t3@gmail.com");
		//saving the student data
		studentDAO.save(temp1);
		studentDAO.save(temp2);
		studentDAO.save(temp3);
		//printing saved student id
		System.out.println("Student saved "+temp1.getId());
		System.out.println("Student saved "+temp2.getId());
		System.out.println("Student saved "+temp3.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		List<Student> students=studentDAO.findAll();
		for(Student st:students)
		{
			System.out.println(st);
		}
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Enter the student id to delete");
		//creating scanner object
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		studentDAO.delete(a);
		System.out.println("Student delete "+a);
	}

	private void createStudent(StudentDAO studentDAO) {
		//creating student object new student object
		Student student=new Student("isthifa","isthi","isthifa@gmail.com");
		//saving the student
		studentDAO.save(student);
		//printing saved student object
		System.out.println("saved data "+student.getId());

	}
}
