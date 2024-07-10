package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.TravelPlan;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {

}
