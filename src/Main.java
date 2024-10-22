import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Ball ball = new Ball(1);
    Player p1 = new Player("amine",ball);
    Player p2 = new Player("yassine",ball);
    Player p3 = new Player("ben",ball);
    p1.start();
    p2.start();
    p3.start();
  }
}

class Player extends Thread{
  private String playerName;
  private Ball ball;

  public Player(String name, Ball ball) {
    this.playerName = name;
    this.ball = ball;
  }

  @Override
  public void run() {
    while (true){
      ball.takeGiveBall(this);
    }
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public Ball getBall() {
    return ball;
  }

  public void setBall(Ball ball) {
    this.ball = ball;
  }
}

class Ball {
  private int num;
  private List<Player> players= new ArrayList<>();

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public Ball(int num) {
    this.num = num;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public synchronized void takeGiveBall(Player player) {
    System.out.println("\n");
    System.out.println(player.getPlayerName()+" Has the ball");
    System.out.println(player.getPlayerName()+" shot the ball");
      try {
          Thread.sleep(2000);
      } catch (InterruptedException e) {
          System.out.println(e.getMessage());
      }
  }
}