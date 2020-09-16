package jungsuk;

import java.util.Vector;

/**
 * Created by minho on 2017-07-07.
 */
class Product {
    int price;
    int bonus;

    Product(int price) {
        this.price = price;
        this.bonus = price * (1 / 10);
    }

    Product(Product p) {
        this.price = p.price;
        this.bonus = p.bonus;
    }

    public void usingProduct ( Product product) {
        if(product instanceof Tv) {
            Tv temp = new Tv(product);
            temp.volumeUp();
        }else if (product instanceof Audio) {
            Audio temp = new Audio(product);
            temp.listenMusic();
        }else if (product instanceof Computer) {
            Computer temp = new Computer(product);
            temp.playGame();
        }else {
            System.out.println("사용 가능 기능 없음");
        }
    }
}

class Tv extends Product {
    Tv() {
        super(200);
    }
    Tv(Product p) {
        super(p);
    }

    void volumeUp() {
        System.out.println("볼륨업");
    }
}

class Audio extends Product {
    Audio() {
        super(50);
    }
    Audio(Product p) {
        super(p);
    }

    void listenMusic() {
        System.out.println("음악듣기");
    }
}

class Computer extends Product {
    Computer() {
        super(100);
    }

    Computer(Product p) {
        super(p);
    }

    void playGame() {
        System.out.println("게임하기");
    }
}

class Buyer {
    Vector item = new Vector();
    int money = 1000;
    int bonusPoints = 0;

    void buy(Product p) {
        if(money < p.price) {
            System.out.println("못사");
            return;
        }
        money -= p.price;
        bonusPoints += p.bonus;
        item.add(p);
        System.out.println(p + " 구매 완료");
    }

    void refund(Product p) {
        if(item.remove(p)) {
            money += p.price;
            bonusPoints -= p.bonus;
            System.out.println(p + " 환불 완료");
        } else {
            System.out.println("해당 제품을 구매한 적이 없음");
        }
    }

}
public class JS_00_Unsolved2 {
}
