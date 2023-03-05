package dmucs.dmu.member.repository;

import dmucs.dmu.member.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDivisionRepository extends JpaRepository<Division, Long> {
}
