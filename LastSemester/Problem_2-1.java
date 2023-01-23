public class Problem_2 {

    public static String calcCheapestCar(String[] cars, int[] prices){
        assert(cars.length == prices.length);

        String Cheapest = new String();
        long ValueOfCar = Long.MAX_VALUE;

        for(int i = 0; i < cars.length; i++){
            if(prices[i] < ValueOfCar){
                ValueOfCar = prices[i];
                Cheapest = cars[i];
            }
        }

        return Cheapest;
    }

    public static void main(String[] args) {
        String cars[]={"Honda Accord", "Chevrolet Suburban", "Dodge Charger", "Kia Optima", "Acura TLX"};
        int prices[]={17000, 48000, 24000, 22500, 17999};

        System.out.println(calcCheapestCar(cars, prices));

    }
}