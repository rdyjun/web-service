package dmucs.dmu.member.repository;

import dmucs.dmu.member.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDepartmentRepository extends JpaRepository<Department, Long> {
}
