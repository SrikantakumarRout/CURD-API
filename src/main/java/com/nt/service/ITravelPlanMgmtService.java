package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entity.TravelPlan;

public interface ITravelPlanMgmtService {
	
	public String registerTravelPlan(TravelPlan plan);//save operation
	public Map<Integer,String> getTravelPlanCategories();//for select operation
	public List<TravelPlan> showAllTravelPlans();//for select operation
	public TravelPlan showTravelPlanById(Integer planId);//for edit operation form lunch (to show the existing record for editing)
	public String updateTravelPlan(TravelPlan plan);//for edit operation form submission
	public String deleteTravelPlan(Integer planId);//for deletion operation(hard deletion)
	public String changeTravelPlanStatus(Integer planId,String status);//for soft deletion acctivity

}
