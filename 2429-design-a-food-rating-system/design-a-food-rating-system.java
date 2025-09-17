class FoodRatings {
    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    private Map<String, PriorityQueue<Food>> cuisinePQ = new HashMap<>();
    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);
            
            cuisinePQ.computeIfAbsent(cuisine, k -> new PriorityQueue<>(
                (a, b) -> a.rating != b.rating ? b.rating - a.rating : a.name.compareTo(b.name)
            )).offer(new Food(food, rating));
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food, newRating);
        cuisinePQ.get(cuisine).offer(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisinePQ.get(cuisine);

        while (true) {
            Food food = pq.peek();

            if (food.rating == foodToRating.get(food.name)) {
                return food.name;
            }
            pq.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */