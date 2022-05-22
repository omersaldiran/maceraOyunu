public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("");
        System.out.println("Mağazaya hoşgeldiniz!");
        boolean showMenu = true;
        while (showMenu){
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
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("-----Silahlar------");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getName() + " Para : " + w.getPrice() + " Hasar : " + w.getDamage());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz :");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID< 0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz bir değer, tekrar giriniz : ");
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);

            if(selectedWeapon != null){
                if (selectedWeapon.getPrice() > getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır!");
                }
                else{
                    // Satın almanın gerçekleştiği alan
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : "+ this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız : "+ getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız : " + getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmor(){
        System.out.println("-----Zırhlar-----");
        for (Armor a : Armor.armors()){
            System.out.println(a.getName() + " Para : " + a.getPrice() + " Engelleme : " + a.getBlock());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyArmor(){
        System.out.print("Bir zırh seçiniz :");
        int selectArmorID = input.nextInt();
        while (selectArmorID< 0 || selectArmorID > Armor.armors().length){
            System.out.println("Geçersiz bir değer, tekrar giriniz : ");
            selectArmorID = input.nextInt();
        }

        if(selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorByID(selectArmorID);

            if(selectedArmor != null){
                if (selectedArmor.getPrice() > getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır!");
                }
                else{
                    // Satın almanın gerçekleştiği alan
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız!");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : "+ this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız : "+ getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni zırhınız : " + getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }


}
