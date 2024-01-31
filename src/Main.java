public class Main {
    public static void main(String[] args) {

        Farm farm = new Farm();
        farm.giveBirth("1", "2", "child1", farm);
        farm.giveBirth("2", "3", "child2", farm);
        farm.giveBirth("3", "4", "child3", farm);
        farm.endLifeSpan("3", farm);
        farm.giveBirth("4", "5", "child4", farm);
        System.out.println(Farm.printFarmData(farm));
    }
}