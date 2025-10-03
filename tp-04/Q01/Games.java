import java.util.Scanner;
import java.nio.file.*;

public class Games 
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

    /**
     * @brief 
     * @param args
     */
    public static void main(String[] args) 
    {
        String filename = "games.csv";
        Scanner sc = new Scanner(System.in);
        Scanner csvScanner = null;
        try 
        {
            csvScanner = new Scanner(Paths.get(filename));
        } 
        catch (java.io.IOException e) 
        {
            System.err.println("Error opening file: " + e.getMessage());
            return;
        }
        
        // Jogando cabeçalho fora
        csvScanner.nextLine();

        int size = csvSize(csvScanner);
        Games[] games = new Games[size];

        // Reinicializar scanner para ler os dados
        csvScanner.close();
        try {
            csvScanner = new Scanner(Paths.get(filename));
            csvScanner.nextLine(); // Pular cabeçalho novamente
        } catch (java.io.IOException e) {
            System.err.println("Error reopening file: " + e.getMessage());
            return;
        }

        // Preenche jogos
        preencheJogo(csvScanner, size, games);

        // Busca por ID
        leituraPubIn(sc, games);

        sc.close();
        csvScanner.close();
    }

    public static void preencheJogo(Scanner csvScanner, int size,  Games[] games)
    {
        int i = 0;
        String line = "";

        while(i < size && csvScanner.hasNextLine())
        {
            line = getLinha(csvScanner);
            games[i] = tratamentoSet(line);
            i = i+1;
        }
    }

    /**
     * @brief
     * @details Vai ler todos os ID's e vai chamar a função de busca
     * @param sc
     * @return
     */
    public static void leituraPubIn(Scanner sc, Games[] games)
    {
        int id = 0;
        boolean stop = false;
        String line = "";
        while(sc.hasNextLine() && !stop)
        {
            line = sc.nextLine();
            if(!line.equals("FIM"))
            {
                id = Integer.parseInt(line);
                buscarPorId(id, games);
            }
            else
            {
                stop = true;
            }
        }
    }

    /**
     * @brief
     * @details Pega o tamaho do csv
     * @param csvScanner
     * @return
     */
    public static int csvSize(Scanner csvScanner)
    {
        int size = 0;
        while(csvScanner.hasNextLine())
        {
            csvScanner.nextLine();
            size++;
        }
        return size;
    }

    /**
     * @brief
     * @details Pega a proxima linha
     * @param csvScanner
     * @return
     */
    public static String getLinha(Scanner csvScanner)
    {
        String csvLine = "";
        csvLine = csvScanner.nextLine();
        return csvLine;
    }

    /**
     * @brief
     * @details Funcao ira pegar os dados da linha e colocar nos atributos do objeto
     * @param csvLine
     */
    public static Games tratamentoSet(String csvLine)
    {
        String[] fields = csvLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // split by comma, ignoring commas inside quotes
        Games game = new Games();

        game.setId(Integer.parseInt(fields[0]));
        game.setName(fields[1]);
        game.setReleaseDate(fields[2].replace("\"", ""));
        game.setEstimatedOwners(Integer.parseInt(fields[3]));
        game.setPrice(Double.parseDouble(fields[4]));
        game.setSupportedLanguages(fields[5].replace("\"", ""));
        game.setMetaCritic(Integer.parseInt(fields[6]));
        game.setUserScore(Integer.parseInt(fields[7]));
        game.setAchievements(Integer.parseInt(fields[8]));
        game.setPublishers(fields[9]);
        game.setDevelopers(fields[10]);
        game.setCategories(fields[11].replace("\"", ""));
        game.setGenres(fields[12].replace("\"", ""));
        game.setTags(fields[13].replace("\"", ""));

        return game;
    }

    public static void buscarPorId(int ID, Games[] games)
    {
        for(int i = 0; i < games.length; i++)
        {
            if(games[i] != null && games[i].getId() == ID)
            {
                games[i].printGame();
                break;
            }
        }
    }

    public void printGame()
    {
        System.out.println(
            "=> " +
            getId() + " ## " +
            getName() + " ## " +
            getReleaseDate() + " ## " +
            getEstimatedOwners() + " ## " +
            getPrice() + " ## " +
            getSupportedLanguages() + " ## " +
            getMetaCritic() + " ## " +
            getUserScore() + " ## " +
            getAchievements() + " ## " +
            getPublishers() + " ## " +
            getDevelopers() + " ## " +
            getCategories() + " ## " +
            getGenres() + " ## " +
            getTags() + " ##"
        );
    }
    
}
