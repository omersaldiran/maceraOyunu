import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private  String charName;
    Scanner input = new Scanner(System.in);

    Inventory inventory = new Inventory();

    public Player(String name){
        this.name = name;
    }

    public void selectChar(){

        GameChar[] charlist = {new Samurai(), new Archer(), new Knight()};
        System.out.println("");
        System.out.println("Karakterler");
        System.out.println("---------------------------------");
        for (GameChar gameChar : charlist){
            System.out.println( gameChar.getId() + "\t\tKarakter : " + gameChar.getName() +
                        "\t\t Hasar : " + gameChar.getDamage() +
                        "\t\t Sağlık : " + gameChar.getHealth() +
                        "\t\t Para : " + gameChar.getMoney());
        }
        System.out.println("---------------------------------");
        System.out.println("Lütfen bir karakter seçiniz:");
        int selectChar = input.nextInt();

        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
    }


    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        System.out.println(gameChar.getName() + " seçildi!");
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
