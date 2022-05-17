public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("");
        System.out.println("Mağazaya hoşgeldiniz!");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
        System.out.println("Seçiminiz : ");
        int selectCase = input.nextInt();
        while (selectCase< 1 || selectCase > 3){
            System.out.println("Geçersiz bir değer, tekrar giriniz : ");
            selectCase = input.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Tekrar bekleriz!");
                break;
        }

        return true;
    }

    public void printWeapon(){
        System.out.println("Silahlar");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getName() + " Para : " + w.getPrice() + " Hasar : " + w.getDamage());
        }
    }

    public void printArmor(){
        System.out.println("Zırhlar");
    }
}
