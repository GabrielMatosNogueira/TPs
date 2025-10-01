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

    // Getters
    public int getId()                                              {return (this.id);}
    public String getName()                                         {return(this.name);}
    public String getReleaseDate()                                  {return(this.releaseDate);}
    public int getEstimatedOwners()                                 {return(this.estimatedOwners);}
    public double getPrice()                                        {return(this.price);}
    public String getSupportedLanguages()                           {return(this.supportedLanguages);}
    public int getMetaCritic()                                      {return(this.metaCritic);}
    public int getUserScore()                                       {return(this.userScore);}
    public int getAchievements()                                    {return(this.achievements);}
    public String getPublishers()                                   {return(this.publishers);}
    public String getDevelopers()                                   {return(this.developers);}
    public String getCategories()                                   {return(this.categories);}
    public String getGenres()                                       {return(this.genres);}
    public String getTags()                                         {return(this.tags);}

    // Setters
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

    // Constructors
    public Game(int id, String name, String releaseDate, int estimatedOwners, double price, String supportedLanguages,
            int metaCritic, int userScore, int achievements, String publishers, String developers,
            String categories, String genres, String tags) 
    {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.estimatedOwners = estimatedOwners;
        this.price = price;
        this.supportedLanguages = supportedLanguages;
        this.metaCritic = metaCritic;
        this.userScore = userScore;
        this.achievements = achievements;
        this.publishers = publishers;
        this.developers = developers;
        this.categories = categories;
        this.genres = genres;
        this.tags = tags;
    }

    public Game() 
    {
        this(-1, null, null, -1, -1.0, null, -1, -1, -1, null, null, null, null, null);
    }

    /**
     * @brief 
     * @param filename
     * @return
     * @throws java.io.IOException
     */
    public Game setterInstanceValues(Game game, String)
    {
        int i = 0;
        while(i < line.length())
        {
            // Obter o ID do jogo
            

            i=i+1;
        }
    }

    /**
     * @brief Programa principal
     * @details Irá ler as linhas do arquivo csv e irá
     *          enviar para outras funcoes para trata-
     *          mento
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws java.io.IOException
    {
        String filenamae = "games.csv";
        String line = "";
        Scanner sc = new Scanner(System.in);
        Scanner csvScanner = new Scanner(Paths.get(filenamae));
        boolean continueReading = true;
        int gamesCounter = 0;
        int i = 0;

        // Pular o cabeçalho
        if(csvScanner.hasNext())
        {
            csvScanner.nextLine();
        }

        // Contador numero de jogos
        while(csvScanner.hasNext() && continueReading)
        {
            line = csvScanner.nextLine();
            if(line.charAt(0) != 'F' && line.charAt(1) != 'I' && line.charAt(2) != 'M' && line.length() != 3)
            {
                gamesCounter++;
            }
            else
            {
                continueReading = false;
            }
        }

        String[] games = new String[gamesCounter];
        Game[] game = new Game[gamesCounter];

        while(csvScanner.hasNext() && continueReading)
        {
            line = csvScanner.nextLine();
            if(line.charAt(0) != 'F' && line.charAt(1) != 'I' && line.charAt(2) != 'M' && line.length() != 3)
            {
                game[i] = setterInstanceValues(game, line);
                i = i+1;
            }
            else
            {
                continueReading = false;
            }
        }

        csvScanner.close();
    }
}
