public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz!");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        System.out.println("Canınız yenilendi !");

        return true;
    }
}
