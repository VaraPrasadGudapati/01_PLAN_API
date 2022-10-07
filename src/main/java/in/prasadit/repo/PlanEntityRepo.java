package in.prasadit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.prasadit.entity.PlanEntity;

@Repository
public interface PlanEntityRepo extends JpaRepository<PlanEntity, Integer> {

}
