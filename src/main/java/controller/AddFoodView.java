package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import model.Food;

@ManagedBean(name="addFoodView")
@ViewScoped
public class AddFoodView implements Serializable {

	private static final long serialVersionUID = -5614496873552383467L;
	String maker;
	
	@ManagedProperty("#{foodService}")
	FoodService foodService;
	
	public void addFood() {
		Food food = new Food(maker);
		System.out.println(food.getMaker());
		foodService.addFood(food);
	}
	
	public String getMaker() {
		return maker;
	}
	
	public void setMaker(String maker) {
		this.maker = maker;
	}

	public FoodService getFoodService() {
		return foodService;
	}

	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	
}
