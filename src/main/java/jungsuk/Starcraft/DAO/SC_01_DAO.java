package jungsuk.Starcraft.DAO;


class Unit {
    private int MAX_HP;
    private int hp;
    private int MAX_MP;
    private int mp;
}

class Building {
    int MAX_HP;
    private int hp;
}

interface floatable {

}

interface attackable {

}

interface repairable {

}

interface skillable {
    void use();
}