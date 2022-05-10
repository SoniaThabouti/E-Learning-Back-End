package ElearningBack.repository;

import ElearningBack.model.Course;
import ElearningBack.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value ="Select * from students S where S.email=:email and S.password=:password", nativeQuery=true)
    Student getStudentFromEmailAndPassword(@Param("email") String email,@Param("password") String password);

    @Query(value ="Select * from students S where S.student_group=:id", nativeQuery=true)
    List<Student> getstudentbygroup(@Param("id") Long id);

	
}



