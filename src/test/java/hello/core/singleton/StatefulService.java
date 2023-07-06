package hello.core.singleton;

public class StatefulService {

//    private int price;

//    public void order(String name, int price){
//        System.out.println("name = " + name + "price = " + price);
//        this.price = price; // 여기가 문제 -> 무상태로 설계를 해야한다.
//    }

//    public int getPrice(){
//        return price;
//    }

    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        return price;
    }

    // 스프링 빈은 항상 stateless 하게 설계해야 한다.

}
