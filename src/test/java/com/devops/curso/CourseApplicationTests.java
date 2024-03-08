package com.devops.curso;

import com.devops.curso.dao.CourseDAO;
import com.devops.curso.dao.ModuleDao;
import com.devops.curso.domain.Course;
import com.devops.curso.domain.Module;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CourseApplicationTests {

	@Mock
	private CourseDAO courseDAO;

	@Mock
	private ModuleDao moduleDao;

	@InjectMocks
	private CursoApplication cursoApplication;

	@Test
	public void testRunner() throws Exception {
		// Arrange
		Course course1 = new Course("curso1", 20L);
		Course course2 = new Course("curso2", 15L);
		Course course3 = new Course("curso3", 13L);

		Module module1 = new Module("modulo1", "sistemas", 1.000000, course1);
		Module module2 = new Module("modulo2", "sistemas", 1.000000, course2);
		Module module3 = new Module("modulo3", "sistemas", 1.000000, course3);

		// Act
		cursoApplication.runner().run();

		// Assert
		verify(courseDAO, times(1)).save(argThat(course -> course.getName().equals(course1.getName())));
		verify(courseDAO, times(1)).save(argThat(course -> course.getName().equals(course2.getName())));
		verify(courseDAO, times(1)).save(argThat(course -> course.getName().equals(course3.getIdCourse())));

		verify(moduleDao, times(1)).save(argThat(module -> module.getName().equals(module1.getName())));
		verify(moduleDao, times(1)).save(argThat(module -> module.getName().equals(module2.getName())));
		verify(moduleDao, times(1)).save(argThat(module -> module.getName().equals(module3.getName())));
	}

}
