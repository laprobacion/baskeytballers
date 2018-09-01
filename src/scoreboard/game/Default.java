 package scoreboard.game;
 
 
 
 public class Default {
     
   private Team teamA;
   private Team teamB;
   private int maxShotClock;
   private int maxShotClock1;
   private int foulPenalty;
   private int minutesPerPeriod;
   private int timeoutPerPeriod;
   
   public Team getTeamA() {
     return this.teamA;
   }
   
   public void setTeamA(Team teamA) {
     this.teamA = teamA;
   }
   
   public Team getTeamB() {
     return this.teamB;
   }
   
   public void setTeamB(Team teamB) {
     this.teamB = teamB;
   }
   
   public int getMaxShotClock() {
     return this.maxShotClock;
   }
   
   public void setMaxShotClock(int maxShotClock) {
     this.maxShotClock = maxShotClock;
   }
   public int getMaxShotClock1() {
     return this.maxShotClock1;
   }
   public void setMaxShotClock1(int maxShotClock1) {
     this.maxShotClock1 = maxShotClock1;
   }
   public int getFoulPenalty() {
     return this.foulPenalty;
   }
   
   public void setFoulPenalty(int foulPenalty) {
     this.foulPenalty = foulPenalty;
   }
   
   public int getMinutesPerPeriod() {
     return this.minutesPerPeriod;
   }
   
   public void setMinutesPerPeriod(int minutesPerPeriod) {
     this.minutesPerPeriod = minutesPerPeriod;
   }
   
   public int getTimeoutPerPeriod() {
     return this.timeoutPerPeriod;
   }
   
   public void setTimeoutPerPeriod(int timeoutPerPeriod) {
     this.timeoutPerPeriod = timeoutPerPeriod;
   }
 }