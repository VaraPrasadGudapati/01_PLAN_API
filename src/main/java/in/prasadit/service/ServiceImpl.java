package in.prasadit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.prasadit.entity.PlanCat;
import in.prasadit.entity.PlanEntity;
import in.prasadit.repo.PlanCatRepo;
import in.prasadit.repo.PlanEntityRepo;

@Component
public class ServiceImpl implements PlanService {
	@Autowired
	private PlanCatRepo plancatrepo;
	@Autowired
	private PlanEntityRepo planentityrepo;
	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCat> categories = plancatrepo.findAll();
		Map<Integer,String>map=new HashMap<>();
		categories.forEach(category->map.put(category.getCategoryId(),category.getCategoryName()));
		return map;
	}
	@Override
	public boolean savePlan(PlanEntity plan) {
		PlanEntity save = planentityrepo.save(plan);
		return save.getPlanId()!=null;
	}
	@Override
	public List<PlanEntity> getAllPlan() {
			
		return planentityrepo.findAll();
	}
	@Override
	public PlanEntity getPlanById(Integer planId) {
		Optional<PlanEntity> findById = planentityrepo.findById(planId);
		if(findById.isPresent())
			return findById.get();		
		return null;
	}
	@Override
	public boolean updatePlan(PlanEntity plan) {
		PlanEntity updateplan = planentityrepo.save(plan);
		return updateplan.getPlanId()!=null;
	}
	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status=false;
		try {
		planentityrepo.deleteById(planId);
		status=true;
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<PlanEntity> findById = planentityrepo.findById(planId);
		if(findById.isPresent()) {
			PlanEntity plan = findById.get();
			plan.setAcitiveSw(status);
			planentityrepo.save(plan);
			return true;
		}
		return false;
	}
	
}
