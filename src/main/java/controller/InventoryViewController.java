package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.*;
import model.Food;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="inventoryViewController")
@ViewScoped
public class InventoryViewController implements Serializable {

	private static final long serialVersionUID = -6583410885242844807L;
	private List<Food> foods;

	@ManagedProperty("#{foodService}")
	FoodService foodService;

	@PostConstruct
	public void init() {
		foods = foodService.returnFood();
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public FoodService getFoodService() {
		return foodService;
	}

	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	
}
