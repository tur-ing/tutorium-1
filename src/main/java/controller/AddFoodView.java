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
	String name;
	String maker;
	int expiryDate;
	
	@ManagedProperty("#{foodService}")
	FoodService foodService;
	
	public void addFood() {
		Food food = new Food();
		food.setName(name);
		food.setMaker(maker);
		food.setExpiryDate(expiryDate);
		foodService.addFood(food);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMaker() {
		return maker;
	}
	
	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
	}

	public FoodService getFoodService() {
		return foodService;
	}

	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	
}
