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
            System.out.println("");
            System.out.println("Bölgeler");
            System.out.println("-----------------------------");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");

            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
        }

    }
}
