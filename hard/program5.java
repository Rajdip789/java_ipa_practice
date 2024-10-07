import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

class Player {
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    Player(int playerId, String playerName, int runs, String playerType, String matchType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }

    int getPlayerId() {
        return this.playerId;
    }

    int getRuns() {
        return this.runs;
    }

    String getPlayerType() {
        return this.playerType;
    }

    String getMatchType() {
        return this.matchType;
    }
}

public class program5 {
    public static int findPlayerWithLowestruns(Player[] player, String playerType) {
        int minRuns = Integer.MAX_VALUE;
        for(Player p : player) {
            if(p.getPlayerType().equalsIgnoreCase(playerType)) {
                minRuns = Integer.min(minRuns, p.getRuns());
            }
        }

        return minRuns == Integer.MAX_VALUE ? 0 : minRuns;
    }

    public static Player[] findPlayerByMatchType(Player[] player, String matchType) {
        Player[] res = Arrays.stream(player).filter((p) -> p.getMatchType().equalsIgnoreCase(matchType)).sorted((p1, p2) -> Integer.compare(p2.getPlayerId(), p1.getPlayerId())).toArray(Player[]::new); 

        return res.length == 0 ? null : res;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player[] p = new Player[4];

        for(int i = 0; i < p.length; i++) {
            int inputPlayerId = sc.nextInt();
            sc.nextLine();
            String inputPlayerName = sc.nextLine();
            int inputRuns = sc.nextInt();
            sc.nextLine();
            String inputPlayerType = sc.nextLine();
            String inputMatchType = sc.nextLine();

            p[i] = new Player(inputPlayerId, inputPlayerName, inputRuns, inputPlayerType, inputMatchType);
        }

        String paramPlayerType = sc.nextLine();
        String paramMatchType = sc.nextLine();
        
        int runs = findPlayerWithLowestruns(p, paramPlayerType);
        if(runs > 0) {
            System.out.println(runs);
        } else {
            System.out.println("No such player");
        }

        Optional<Player[]> op = Optional.ofNullable(findPlayerByMatchType(p, paramMatchType));
        if(op.isPresent()) {
            Player[] player = op.get();
            for(int i = 0; i < player.length; i++) {
                System.out.println(player[i].getPlayerId());
            }
        } else {
            System.out.println("No Player with given matchType");
        }
    }    
}
/*

--- input ---
11
Sachin
100
International
One day
12
Shewag
133
International
Test
13
Varun
78
State
Test
14
Ashwin
67
State
One day
State
One day

---- output ---
67
14
11

*/