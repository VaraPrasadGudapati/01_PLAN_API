package in.prasadit.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import in.prasadit.entity.PlanEntity;

@Service
public interface PlanService {
	public Map<Integer, String> getPlanCategories();

	public boolean savePlan(PlanEntity plan);

	public List<PlanEntity> getAllPlan();

	public PlanEntity getPlanById(Integer planId);

	public boolean updatePlan(PlanEntity plan);

	public boolean deletePlanById(Integer planId);

	public boolean planStatusChange(Integer planId, String status);
}
