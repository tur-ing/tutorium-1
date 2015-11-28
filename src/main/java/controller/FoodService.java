package controller;

import model.Food;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@ManagedBean(name="foodService")
@ApplicationScoped
public class FoodService {
	
    private static final String PERSISTENCE_UNIT_NAME = "fridge";
	private static EntityManagerFactory emf;
	
	public List<Food> returnFood() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    Query query = em.createQuery("SELECT foods FROM Food foods");
	    List<Food> foods = query.getResultList();
		em.close();
		return foods;
	}
	
	public void addFood(Food food) {
		System.out.println("Entered addFood method on FoodService");
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(food);
		Food secondFood = new Food();
		food.setMaker("Bauer");
		em.persist(secondFood);
		em.getTransaction().commit();
		em.close();
		System.out.println("Persisted: " + food.getMaker() + " - end of transaction");
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setEmf(EntityManagerFactory emf) {
		FoodService.emf = emf;
	}

}
