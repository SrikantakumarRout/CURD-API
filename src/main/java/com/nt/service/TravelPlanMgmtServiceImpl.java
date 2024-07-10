package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.PlanCategory;
import com.nt.entity.TravelPlan;
import com.nt.repository.IPlanCategoryRepository;
import com.nt.repository.ITravelPlanRepository;

@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {
	
	@Autowired
	private ITravelPlanRepository travelPlanRepo;

	@Autowired
	private IPlanCategoryRepository planCategoryRepo;
	
	
	@Override
	public String registerTravelPlan(TravelPlan plan) {
		//save the object
		TravelPlan saved=travelPlanRepo.save(plan);
		/*if(saved.getPlanId()!=null)
			return "TravelPlan is saved with the id Value:: "+saved.getPlanId();
		else 
			return "Problem in saving the TravelPlan";*/
		
		return saved.getPlanId()!=null?"TRravelPlan is saved with id value:: "+saved.getPlanId() : "problem in saving TravelPlan";
	}

	
	
	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		//get all TravelPlan categories
		List<PlanCategory> list=planCategoryRepo.findAll();
		Map<Integer,String> categoriesMap=new HashMap<Integer,String>();
		list.forEach(category->{
			categoriesMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoriesMap;
	}

	
	
	@Override
	public List<TravelPlan> showAllTravelPlans() {
		return travelPlanRepo.findAll();
	}
	
	

	@Override
	public TravelPlan showTravelPlanById(Integer planId) {
		return travelPlanRepo.findById(planId).orElseThrow(()->new IllegalArgumentException("TravelPlan is not found"));
		/*Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IllegalArgumentException("plan id not found");
		}*/
	}

	
	@Override
	public String updateTravelPlan(TravelPlan plan) {
		Optional<TravelPlan> opt=travelPlanRepo.findById(plan.getPlanId());
		if(opt.isPresent()) {
			//update the project
			travelPlanRepo.save(plan);
			return plan.getPlanId()+" Travel plan is updated";
		}
		else {
			return plan.getPlanId()+" Travel plan is not found";
		}
	}
	
	

	@Override
	public String deleteTravelPlan(Integer planId) {
		Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			//delete the object
			travelPlanRepo.deleteById(planId);
			return planId+" Travel plan is deleted";
		}
		else {
			return planId+" Travel plan id not found";
		}
	}

	
	
	@Override
	public String changeTravelPlanStatus(Integer planId, String status) {
	Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
	if(opt.isPresent()) {
		TravelPlan plan=opt.get();
		travelPlanRepo.save(plan);
		return planId+" Travel Plan status is changed";
	}
	else {
		return planId+" Travel Plan is not found for updation";
	}
		
	}

	
	
	
}









