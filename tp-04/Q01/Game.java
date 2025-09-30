import java.util.Scanner;
import java.nio.file.*;

public class Game
{
    private int id;
    private String name;
    private String releaseDate;
    private int estimatedOwners;
    private double price;
    private String supportedLanguages;
    private int metaCritic;
    private int userScore;
    private int achievements;
    private String publishers;
    private String developers;
    private String categories;
    private String genres;
    private String tags;

    public void getId()                                             {System.out.println(this.id);}
    public void getName()                                           {System.out.println(this.name);}
    public void getReleaseDate()                                    {System.out.println(this.releaseDate);}
    public void getEstimatedOwners()                                {System.out.println(this.price);}
    public void getPrice()                                          {System.out.println(this.estimatedOwners);}
    public void getSupportedLanguages()                             {System.out.println(this.supportedLanguages);}
    public void getMetaCritic()                                     {System.out.println(this.metaCritic);}
    public void getUserScore()                                      {System.out.println(this.userScore);}
    public void getAchievements()                                   {System.out.println(this.achievements);}
    public void getPublishers()                                     {System.out.println(this.publishers);}
    public void getDevelopers()                                     {System.out.println(this.developers);}
    public void getCategories()                                     {System.out.println(this.categories);}
    public void getGenres()                                         {System.out.println(this.genres);}
    public void getTags()                                           {System.out.println(this.tags);}

    public void setId(int id)                                       {this.id = id;}
    public void setName(String name)                                {this.name = name;}
    public void setReleaseDate(String date)                         {this.releaseDate = date;}
    public void setEstimatedOwners(int estimatedOwners)             {this.estimatedOwners = estimatedOwners;}
    public void setPrice(double price)                              {this.price = price;}
    public void setSupportedLanguages(String supportedLanguages)    {this.supportedLanguages = supportedLanguages;}
    public void setMetaCritic(int metaCritic)                       {this.metaCritic = metaCritic;}
    public void setUserScore(int userScore)                         {this.userScore = userScore;}
    public void setAchievements(int achievements)                   {this.achievements = achievements;}
    public void setPublishers(String publishers)                    {this.publishers = publishers;}
    public void setDevelopers(String developers)                    {this.developers = developers;}
    public void setCategories(String categories)                    {this.categories = categories;}
    public void setGenres(String genres)                            {this.genres = genres;}
    public void setTags(String tags)                                {this.tags = tags;}
}