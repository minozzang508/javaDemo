//package com.jungsuk.Starcraft.DAO;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Vector;
//
///**
// * Created by minho on 2017-06-16.
// */
//
////1. 인터페이스 상속
//interface Selectable {
//
//}
//interface Moveable {
//    int move = 10;
//    void setMove(int a);
//}
//interface Attackable {
//    int damage = 100;
//    void setAttack(int a);
//}
//interface Repairable {
//
//}
////두개의 인터페이스 상속 가능.
//interface Fightable extends Moveable, Attackable {
//
//}
//
//interface SteamPackable {
//    void steamPack();
//}
//
////빌딩
//interface Liftable {
//    //public abstract 생략.
//    void liftOff(); //건물을 들어올린다.
//    void move(int x, int y);
//    void stop();
//    void land();
//}
//
//class Unit<T> implements Cloneable, Selectable{
//    int hitPoint;
//    final int MAX_UP;
//    Unit(int hp) {
//        MAX_UP = hp;
//    }
//
//    Unit(Unit u) {
//        this.hitPoint = u.hitPoint;
//        this.MAX_UP = u.MAX_UP;
//    }
//
//    public String toString() {
//        //return new StringTokenizer(this.getClass().getName(), ".").nextToken();
//        return this.getClass().getSimpleName();
//    }
//
//    public void selectUnit(ArrayList<T> selected, T unit, String status) {
//        if(selected.size() < 12) {
//            switch(status) {
//                case "Shift" :
//                    selected.add(unit);
//                    break;
//
//                case "Ctrl" :
//                    selected.remove(selected.contains(unit));
//                    break;
//            }
//        }
//    }
//
//    public void showUlts (ArrayList<T> selected) {
//
//    }
//    //...
//}
//
//class GroundUnit extends Unit implements Fightable {
//    GroundUnit(int hp) {
//        super(hp);
//    }
//
//    GroundUnit(Unit u) {
//        super(u);
//    }
//
//    @Override
//    public void setMove(int a) {
//
//    }
//
//    @Override
//    public void setAttack(int a) {
//
//    }
//}
//
//class SteamPackUnit extends GroundUnit {
//    SteamPackUnit(int hp) {
//        super(hp);
//    }
//
//    SteamPackUnit(Unit u) {
//        super(u);
//    }
//
//    public void steamPack() {
//        if(this.hitPoint > 10) {
//            System.out.println("스팀팩 발동");
//        } else {
//            System.out.println("체력이 모자람");
//        }
//    }
//}
//
//class AirUnit extends Unit implements Fightable {
//    AirUnit(int hp) {
//        super(hp);
//    }
//
//    @Override
//    public void setMove(int a) {
//
//    }
//    @Override
//    public void setAttack(int a) {
//
//    }
//}
//
//class Tank extends GroundUnit implements Attackable, Repairable {
//    boolean isMode;
//    Tank() {
//        super(150);
//        this.hitPoint = MAX_UP;
//        isMode = false;
//    }
//
//    @Override
//    public void showUlts(ArrayList selected) {
//        super.showUlts(selected);
//        this.isMode = !this.isMode;
//        System.out.println("SiegeMode = " + isMode);
//    }
//}
//
//class Dropship extends AirUnit implements Repairable {
//    int spare = 8;
//    Dropship() {
//        super(125);
//        this.hitPoint = MAX_UP;
//    }
//
//    public void aboard() {
//
//    }
//}
//
//class Marine extends SteamPackUnit implements Attackable, SteamPackable {
//    Marine() {
//        super(40);
//        this.hitPoint = MAX_UP;
//    }
//
//    Marine(Unit u) {
//        super(u);
//    }
//
//    @Override
//    public void showUlts(ArrayList selected) {
//        super.showUlts(selected);
//        steamPack();
//    }
//
//    public void steamPack() {
//        if(this.hitPoint > 10) {
//            this.hitPoint -= 10;
//            System.out.println("스팀팩 발동");
//        }
//        else {
//            System.out.println("체력이 모자람");
//        }
//    }
//}
//
//class SCV extends GroundUnit implements Attackable, Repairable {
//    SCV() {
//        super(60);
//        this.hitPoint = MAX_UP;
//    }
//
//    @Override
//    public void showUlts(ArrayList selected) {
//        super.showUlts(selected);
//        System.out.println("You must select repairing Unit or Building");
//    }
//
//    public void showUlts(ArrayList selected, Object r) {
//        super.showUlts(selected);
//        repair(r);
//    }
//
//
//    void repair(Object r) {
//        if(r instanceof Repairable && r != this) {
//            Unit u = (Unit)r;
//            while(u.hitPoint != u.MAX_UP) {
//                //Unit의 HP를 증가시킨다.
//                u.hitPoint++;
//            }
//            System.out.println(u.toString() + " : repair is done.");
//        }
//        else if(r == this) {
//            System.out.println(r.toString() + " : Can not repair itself.");
//        }
//        else {
//            System.out.println(r.toString() + " : Can not repair this Unit.");
//        }
//    }
//
//    Building BuildCommandCenter(int x, int y) {
//        return new CommandCenter(x, y);
//    }
//    Building BuildSupplyDepot(int x, int y) {
//        return new SupplyDepot(x, y);
//    }
//}
//class Building {
//    int x;
//    int y;
//    int hitPoint;
//
//    Building(int hp, int x, int y) {
//        this.x = x;
//        this.y = y;
//        this.hitPoint = hp;
//    }
//
//    public String toString() {
//        return this.getClass().getSimpleName() + " has been created at x : " + this.x + ", y : " + this.y;
//    }
//}
//
//class CommandCenter extends Building implements Liftable, Repairable {
//    boolean movable = false;
//    CommandCenter(int x, int y) {
//        super(1300, x, y);
//    }
//
//    @Override
//    public void liftOff() {
//        this.movable = true;
//    }
//
//    @Override
//    public void move(int x, int y) {
//        if(movable) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    @Override
//    public void stop() {
//
//    }
//
//    @Override
//    public void land() {
//        this.movable = false;
//    }
//}
//
//
//
//class SupplyDepot extends Building implements Repairable {
//    SupplyDepot(int x, int y) {
//        super(600, x, y);
//    }
//}
//
//class userControl<T> {
//    private static userControl instance;
//    private static final int MAX_NUM = 12;
//    private static ArrayList units;
//    private int curNum;
//
//    private userControl() {
//        instance.units = new ArrayList();
//        instance.curNum = 0;
//    }
//
//    public userControl getInstance() {
//        if(instance == null) {
//            instance = new userControl();
//        }
//        return instance;
//    }
//
//    public void selectUnit(T unit) {
//        instance.units.add(unit);
//        instance.curNum++;
//    }
//
//    public void drag(int getNum) {
//        for(int i = 0; i < getNum; i++) {
//
//        }
//    }
//}
//
//public class SC_00_DAO {
//
//    public static void main(String[] args) {
//        Tank tank = new Tank();
//        Dropship dropship = new Dropship();
//        Marine marine = new Marine();
//        SCV scv = new SCV();
//
//        scv.repair(tank);
//        scv.repair(dropship);
//        scv.repair(marine);
//        scv.repair(scv);
//        scv.setAttack(5);
//        scv.setMove(10);
//
//
//        CommandCenter commandCenter = (CommandCenter) scv.BuildCommandCenter(100, 300);
//        SupplyDepot supplyDepot = (SupplyDepot) scv.BuildSupplyDepot(200, 300);
//
//        System.out.println(commandCenter.toString());
//        System.out.println(supplyDepot.toString());
//
//        Unit[] reinforce = new Unit[12];
//
//        reinforce[0] = new Tank();
//        reinforce[1] = new Marine();
//        reinforce[2] = new Dropship();
//        reinforce[3] = new SCV();
//        reinforce[4] = new Tank();
//        reinforce[5] = new Marine();
//        reinforce[6] = new Dropship();
//        reinforce[7] = new SCV();
//        reinforce[8] = new Tank();
//        reinforce[9] = new Marine();
//        reinforce[10] = new Dropship();
//        reinforce[11] = new SCV();
//
//        ArrayList<Unit> selected = new ArrayList();
//
//        reinforce[1].showUlts(selected);
//
//
//
//
//    }
//}
