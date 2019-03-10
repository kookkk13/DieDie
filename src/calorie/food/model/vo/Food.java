package calorie.food.model.vo;

public class Food implements java.io.Serializable {
	private static final long serialVersionUID = 220L;
	
	private int foodNo;
	private String foodName;
	private double onceIn;
	private double calorie;
	private double carb;
	private double protein;
	private double fat;
	private double sugar;
	private double na;
	
	public Food() {}
	
	public Food(int foodNo, String foodName, double onceIn, double calorie, double carb, double protein, double fat, double sugar,
			double na) {
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.onceIn = onceIn;
		this.calorie = calorie;
		this.carb = carb;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.na = na;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getOnceIn() {
		return onceIn;
	}

	public void setOnceIn(double onceIn) {
		this.onceIn = onceIn;
	}

	public double getCalorie() {
		return calorie;
	}

	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}

	public double getCarb() {
		return carb;
	}

	public void setCarb(double carb) {
		this.carb = carb;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getSugar() {
		return sugar;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public double getNa() {
		return na;
	}

	public void setNa(double na) {
		this.na = na;
	}

	@Override
	public String toString() {
		return "foodNo : " + foodNo + ", foodName : " + foodName + ", onceIn : " + onceIn + ", calorie : " + calorie
				+ ", carb : " + carb + ", protein : " + protein + ", fat : " + fat + ", sugar : " + sugar + ", na : " + na;
	}
	
	
	
	
	
	

}
