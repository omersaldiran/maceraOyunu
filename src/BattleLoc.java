public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player, name);
        this.award = award;
        this.obstacle = obstacle;

    }

    @Override
    public boolean onLocation() {
        return false;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
