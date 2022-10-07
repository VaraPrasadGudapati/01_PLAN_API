package in.prasadit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.prasadit.entity.PlanEntity;
import in.prasadit.service.PlanService;


@RestController
public class PlanRestController {
	
	@Autowired
	private PlanService planservice;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> planCategory(){
		Map<Integer, String> categories = planservice.getPlanCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	@PostMapping("/plan")
	public ResponseEntity<String> savePlane(@RequestBody PlanEntity plan){
		String responseMsg="";
		boolean isSaved = planservice.savePlan(plan);
		if(isSaved)
			responseMsg="Plane is saved";
		else
			responseMsg="Plane is not saved";
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}
	@GetMapping("/plans")
	public ResponseEntity<List<PlanEntity>> plans(){
		List<PlanEntity> allPlan = planservice.getAllPlan();
		return new ResponseEntity<>(allPlan,HttpStatus.OK);
	}
	@GetMapping("/plan/{planId}")
	public ResponseEntity<PlanEntity> editPlan(@PathVariable Integer planId){
		PlanEntity planById = planservice.getPlanById(planId);
		return new ResponseEntity<>(planById,HttpStatus.OK);
	}
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody PlanEntity planId){
	boolean updatePlan = planservice.updatePlan(planId);
	String msg="";
	if(updatePlan)
		msg="plane is updated";
	else
		msg="Plan is not updated ";
	return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		String msg="";
		boolean deletePlanById = planservice.deletePlanById(planId);
		if(deletePlanById)
			msg="plane is deleted";
		else
			msg="plane is not deleted";
	return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	ResponseEntity<String> statusChanged(@PathVariable Integer planId,@PathVariable String status){
		boolean planStatusChange = planservice.planStatusChange(planId, status);
		String msg="";
		if(planStatusChange)
		msg="plan staus got changed";
		else
			msg="plan status is not changed";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
