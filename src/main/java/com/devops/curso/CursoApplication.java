package com.devops.curso;

import com.devops.curso.dao.CourseDAO;
import com.devops.curso.dao.ModuleDao;
import com.devops.curso.domain.Course;
import com.devops.curso.domain.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CursoApplication {

	@Autowired
	CourseDAO courseDAO;

	@Autowired
	ModuleDao moduleDao;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Course course1 = new Course("curso1", 20L);
			Course course2 = new Course("curso2", 15L);
			Course course3 = new Course("curso3", 13L);

			courseDAO.save(course1);
			courseDAO.save(course2);
			courseDAO.save(course3);

			moduleDao.save(new Module("modulo1", "sistemas", 1.000000, course1));
			moduleDao.save(new Module("modulo2", "sistemas", 1.000000, course2));
			moduleDao.save(new Module("modulo3", "sistemas", 1.000000, course3));
		};
	}

}
