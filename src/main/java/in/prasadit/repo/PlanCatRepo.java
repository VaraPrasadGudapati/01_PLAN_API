package in.prasadit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.prasadit.entity.PlanCat;

@Repository
public interface PlanCatRepo extends JpaRepository<PlanCat, Integer> {

}
