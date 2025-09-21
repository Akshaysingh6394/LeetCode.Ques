class MovieRentingSystem {
    private Map<String, Integer> price;  
    private Map<Integer, List<int[]>> movieShops; 
    private Set<String> rented;         

    private String encode(int shop, int movie) {
        return shop + "#" + movie;
    }

    public MovieRentingSystem(int n, int[][] entries) {
        price = new HashMap<>();
        movieShops = new HashMap<>();
        rented = new HashSet<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], p = e[2];
            String key = encode(shop, movie);
            price.put(key, p);

            movieShops.putIfAbsent(movie, new ArrayList<>());
            movieShops.get(movie).add(new int[]{p, shop});
        }

        for (List<int[]> shops : movieShops.values()) {
            shops.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; 
                return a[1] - b[1]; 
            });
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!movieShops.containsKey(movie)) return res;

        for (int[] ps : movieShops.get(movie)) {
            int price = ps[0], shop = ps[1];
            if (!rented.contains(encode(shop, movie))) {
                res.add(shop);
                if (res.size() == 5) break;
            }
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        rented.add(encode(shop, movie));
    }
    
    public void drop(int shop, int movie) {
        rented.remove(encode(shop, movie));
    }
    
    public List<List<Integer>> report() {
        List<int[]> rentedList = new ArrayList<>();
        for (String key : rented) {
            String[] parts = key.split("#");
            int shop = Integer.parseInt(parts[0]);
            int movie = Integer.parseInt(parts[1]);
            int p = price.get(key);
            rentedList.add(new int[]{p, shop, movie});
        }

        rentedList.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rentedList.size() && i < 5; i++) {
            res.add(Arrays.asList(rentedList.get(i)[1], rentedList.get(i)[2]));
        }
        return res;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */