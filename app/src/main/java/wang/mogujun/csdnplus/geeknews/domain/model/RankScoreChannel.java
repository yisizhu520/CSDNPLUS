package wang.mogujun.csdnplus.geeknews.domain.model;

public class RankScoreChannel
{
  public Channel[] channel;
  public Rank[] rank;
  public int score;
  
  public static class Channel
  {
    public int diffvalue;
    public String image_url;
    public int level;
    public int percent;
    public int score;
    public boolean setDiffvalue;
    public boolean setImage_url;
    public boolean setLevel;
    public boolean setPercent;
    public boolean setScore;
    public boolean setType;
    public boolean setUsername;
    public int type;
    public String typeName;
    public String username;
  }
  
  public static class Rank
  {
    public String image_url;
    public int score;
    public boolean setImage_url;
    public boolean setScore;
    public boolean setType;
    public boolean setUsername;
    public int type;
    public String typeName;
    public String username;
  }
}