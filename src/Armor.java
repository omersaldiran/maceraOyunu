public class Armor {
    private int id;
    private String Name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        Name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = {
                new Armor(1,"Hafif",1,5),
                new Armor(2,"Orta",3,10),
                new Armor(3,"Ağır",5,15)
        };

        return armorList;
    }

    public static Armor getArmorByID(int id){
        for(Armor a : Armor.armors()){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
