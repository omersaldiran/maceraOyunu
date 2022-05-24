import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz!");
        System.out.print("Lütfen bir isim giriniz:");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " adaya hoşgeldin!");
        System.out.println("Bu adada yaşananların hepsi gerçek!");
        System.out.println("Lütfen bir karakter seçiniz!");
        player.selectChar();

        Location location = null;
        while(true){
            player.printInfo();
            System.out.println("");
            System.out.println("Bölgeler");
            System.out.println("-----------------------------");
            System.out.println("1 - Güvenli Ev   --> Burada canını doldurabilirsin.");
            System.out.println("2 - Eşya Dükkanı --> Burada alışveriş yapabilirsin.");
            System.out.println("3 - Mağara       --> Mağaraya git ! Dikkat zombi çıkabilir ! - Ödül > Yemek");
            System.out.println("4 - Orman        --> Ormana git ! Dikkat vampir çıkabilir ! - Ödül > Odun");
            System.out.println("5 - Nehir        --> Nehre git ! Dikkat ayı çıkabilir ! - Ödül > Su");
            System.out.println("0 - Çıkış Yap");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
            }
            if(location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin !");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
        }

    }
}
