package dmucs.dmu.repository;

import dmucs.dmu.member.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDepartmentRepository extends JpaRepository<Department, Long> {

}
