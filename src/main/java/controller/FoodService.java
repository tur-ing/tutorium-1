package controller;

import model.Food;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="foodService")
@ApplicationScoped
public class FoodService {
	
	public List<Food> returnFood() {
		List<Food> foods = new ArrayList<Food>();
		foods.add(new Food("Alnatura"));
		foods.add(new Food("Bauer"));
		foods.add(new Food("Bergbauer"));
		foods.add(new Food("Müller"));
		return foods;
	}

}
