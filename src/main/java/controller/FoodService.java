package controller;

import model.Food;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name="foodService")
@ApplicationScoped
public class FoodService {
	
    private static final String PERSISTENCE_UNIT_NAME = "fridge";
	private static EntityManagerFactory emf;
	
	public List<Food> returnFood() {
		List<Food> foods = new ArrayList<Food>();
		foods.add(new Food("Alnatura"));
		foods.add(new Food("Bauer"));
		foods.add(new Food("Bergbauer"));
		foods.add(new Food("Müller"));
		return foods;
	}
	
	public void addFood(Food food) {
		System.out.println("Entered addFood method on FoodService");
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setEmf(EntityManagerFactory emf) {
		FoodService.emf = emf;
	}

}
