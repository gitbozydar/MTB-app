package com.example.demo.Quiz;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/Quiz")
public class QuizController {

    private final QuestionRepository questionRepository;
    private final RankingRepository rankingRepository;

    public QuizController(QuestionRepository questionRepository, RankingRepository rankingRepository) {
        this.questionRepository = questionRepository;
        this.rankingRepository = rankingRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        if (questionRepository.count() == 0) {
            List<Question> qList = new ArrayList<>();
            System.out.println("Baza pytań jest pusta. Dodawanie pytań...");

            // FILMY (30)
            addQ(qList, "Filmy", "Kto grał Jacka w Titanic?", "DiCaprio", "Pitt", "Depp", "Cruise", "A");
            addQ(qList, "Filmy", "Reżyser 'Pulp Fiction'?", "Nolan", "Tarantino", "Spielberg", "Scott", "B");
            addQ(qList, "Filmy", "W którym roku wyszedł pierwszy 'Matrix'?", "1997", "2001", "1999", "1995", "C");
            addQ(qList, "Filmy", "Kto jest ojcem Luke'a Skywalkera?", "Yoda", "Obi-Wan", "Vader", "Palpatine", "C");
            addQ(qList, "Filmy", "Jak nazywa się planeta w 'Avatarze'?", "Mars", "Pandora", "Ziemia", "Asgard", "B");
            addQ(qList, "Filmy", "Który aktor wcielił się w Iron Mana?", "Chris Evans", "Tom Holland", "Robert Downey Jr.", "Mark Ruffalo", "C");
            addQ(qList, "Filmy", "Imię bałwana z 'Krainy Lodu'?", "Sven", "Olaf", "Kristoff", "Hans", "B");
            addQ(qList, "Filmy", "Jak nazywa się szkoła magii w Harrym Potterze?", "Narnia", "Śródziemie", "Hogwart", "Camelot", "C");
            addQ(qList, "Filmy", "Ile Oscarów zdobył 'Władca Pierścieni: Powrót Króla'?", "11", "5", "8", "12", "A");
            addQ(qList, "Filmy", "Kto wyreżyserował 'Incepcję'?", "Tarantino", "Nolan", "Fincher", "Burton", "B");
            addQ(qList, "Filmy", "Jak nazywa się kapitan w 'Piratach z Karaibów'?", "Barbossa", "Sparrow", "Hook", "Morgan", "B");
            addQ(qList, "Filmy", "Główny przeciwnik Avengersów w 'Endgame'?", "Loki", "Ultron", "Thanos", "Red Skull", "C");
            addQ(qList, "Filmy", "Film, który zdobył Oscara w 2020?", "1917", "Parasite", "Joker", "Irlandczyk", "B");
            addQ(qList, "Filmy", "Jak nazywa się fikcyjne miasto Batmana?", "Metropolis", "Gotham", "Central City", "Star City", "B");
            addQ(qList, "Filmy", "Kto napisał muzykę do 'Interstellar'?", "John Williams", "Hans Zimmer", "Ennio Morricone", "Danny Elfman", "B");
            addQ(qList, "Filmy", "Ile części liczy saga 'Harry Potter'?", "7", "8", "9", "6", "B");
            addQ(qList, "Filmy", "Aktor, który zagrał Forresta Gumpa?", "Brad Pitt", "Tom Hanks", "Johnny Depp", "Jim Carrey", "B");
            addQ(qList, "Filmy", "Z jakiej bajki pochodzi Simba?", "Bambi", "Król Lew", "Tarzan", "Mulan", "B");
            addQ(qList, "Filmy", "W którym roku zatonął Titanic (film)?", "1910", "1912", "1914", "1905", "B");
            addQ(qList, "Filmy", "Główny bohater 'Leona Zawodowca'?", "Gary Oldman", "Jean Reno", "Bruce Willis", "Sylvester Stallone", "B");
            addQ(qList, "Filmy", "Agent 007 to?", "Jason Bourne", "Ethan Hunt", "James Bond", "Jack Reacher", "C");
            addQ(qList, "Filmy", "Gdzie toczy się akcja 'Casablanki'?", "Francja", "Maroko", "Egipt", "Włochy", "B");
            addQ(qList, "Filmy", "Kto grał Jokera w 'Mrocznym Rycerzu'?", "Phoenix", "Nicholson", "Ledger", "Leto", "C");
            addQ(qList, "Filmy", "Z jakiego kraju pochodzi 'Dom z papieru'?", "Włochy", "Hiszpania", "Meksyk", "Brazylia", "B");
            addQ(qList, "Filmy", "Imię psa z filmu 'Beethoven'?", "Azor", "Ciapek", "Beethoven", "Rex", "C");
            addQ(qList, "Filmy", "Główny bohater 'Gladiatora'?", "Maximus", "Commodus", "Spartakus", "Leonidas", "A");
            addQ(qList, "Filmy", "Jaki kolor ma pigułka Neo?", "Niebieska", "Zielona", "Czerwona", "Żółta", "C");
            addQ(qList, "Filmy", "Reżyser 'E.T.'?", "Spielberg", "Lucas", "Cameron", "Coppola", "A");
            addQ(qList, "Filmy", "Kto namalował Monę Lisę (film 'Kod Da Vinci')?", "Anioł", "Picasso", "Da Vinci", "Dali", "C");
            addQ(qList, "Filmy", "Imię mordercy z 'Halloween'?", "Jason", "Freddy", "Michael", "Chucky", "C");

            // GRY (30)
            addQ(qList, "Gry", "Główny bohater Wiedźmina?", "Lambert", "Geralt", "Eskel", "Vesemir", "B");
            addQ(qList, "Gry", "Twórca Minecrafta?", "Notch", "Jeb", "Gates", "Musk", "A");
            addQ(qList, "Gry", "Hydraulik z Nintendo?", "Luigi", "Wario", "Mario", "Yoshi", "C");
            addQ(qList, "Gry", "Akcja GTA V toczy się w?", "Liberty City", "Vice City", "Los Santos", "San Fierro", "C");
            addQ(qList, "Gry", "Najpopularniejsza gra MOBA?", "LoL", "CS", "FIFA", "SIMS", "A");
            addQ(qList, "Gry", "Broń Freemana w Half-Life?", "Miecz", "Pistolet", "Łom", "Topór", "C");
            addQ(qList, "Gry", "Z jakiej gry pochodzi 'Finish Him'?", "Tekken", "Mortal Kombat", "Street Fighter", "Doom", "B");
            addQ(qList, "Gry", "Przeciwnik Mario (żółw)?", "Koopa", "Bowser", "Goomba", "Toad", "B");
            addQ(qList, "Gry", "Świat w World of Warcraft?", "Azeroth", "Tamriel", "Pandora", "Ziemia", "A");
            addQ(qList, "Gry", "Konsola firmy Sony?", "Xbox", "Switch", "PlayStation", "Genesis", "C");
            addQ(qList, "Gry", "Studio od Wiedźmina?", "Ubisoft", "Rockstar", "CD Projekt Red", "EA", "C");
            addQ(qList, "Gry", "Główna postać 'Tomb Raider'?", "Jill", "Lara Croft", "Samus", "Aloy", "B");
            addQ(qList, "Gry", "Z jakiej gry pochodzi Kratos?", "God of War", "Souls", "Bloodborne", "Skyrim", "A");
            addQ(qList, "Gry", "Studio od 'League of Legends'?", "Valve", "Blizzard", "Riot Games", "Epic", "C");
            addQ(qList, "Gry", "Gra w Rapture?", "BioShock", "Fallout", "Dead Space", "Subnautica", "A");
            addQ(qList, "Gry", "Niebieski jeż Segi?", "Tails", "Sonic", "Knuckles", "Shadow", "B");
            addQ(qList, "Gry", "Najlepiej sprzedająca się gra świata?", "Tetris", "GTA V", "Minecraft", "Wii Sports", "C");
            addQ(qList, "Gry", "Główna postać 'Halo'?", "Master Chief", "Doomguy", "Marcus", "Duke", "A");
            addQ(qList, "Gry", "Język programowania w Minecraft?", "C++", "Java", "Python", "C#", "B");
            addQ(qList, "Gry", "Gra z 'Dust 2'?", "Valorant", "CS:GO", "Overwatch", "Siege", "B");
            addQ(qList, "Gry", "Konsola Nintendo z 2017?", "DS", "Wii", "Switch", "Cube", "C");
            addQ(qList, "Gry", "Zabójca z ukrytym ostrzem?", "Ezio", "Geralt", "Drake", "Snake", "A");
            addQ(qList, "Gry", "Postać z 'The Last of Us'?", "Joel", "Marcus", "Dante", "Arthur", "A");
            addQ(qList, "Gry", "Gra z budowaniem Simsów?", "Minecraft", "The Sims", "Valley", "Terraria", "B");
            addQ(qList, "Gry", "Z jakiej gry jest Pikachu?", "Digimon", "Pokemon", "Mario", "Zelda", "B");
            addQ(qList, "Gry", "Najemnik z Cyberpunka?", "V", "Johnny", "Jackie", "Dex", "A");
            addQ(qList, "Gry", "Wróg Master Chiefa?", "Ludzie", "Covenant", "Orki", "Zerg", "B");
            addQ(qList, "Gry", "Gra z piłką i autami?", "FIFA", "Rocket League", "Forza", "NFS", "B");
            addQ(qList, "Gry", "Główny wróg Batmana w Arkham?", "Joker", "Bane", "Penguin", "Riddler", "A");
            addQ(qList, "Gry", "Kraina w Skyrim?", "Morrowind", "Skyrim", "Cyrodiil", "Hammerfell", "B");

            // GEOGRAFIA (30)
            addQ(qList, "Geografia", "Stolica Francji?", "Lyon", "Marsylia", "Paryż", "Nicea", "C");
            addQ(qList, "Geografia", "Największy kontynent?", "Afryka", "Azja", "Europa", "Ameryka", "B");
            addQ(qList, "Geografia", "Najdłuższa rzeka świata?", "Amazonka", "Nil", "Wisła", "Dunaj", "B");
            addQ(qList, "Geografia", "Najwyższy szczyt świata?", "K2", "Rysy", "Mount Everest", "Mont Blanc", "C");
            addQ(qList, "Geografia", "Państwo z największą populacją?", "USA", "Chiny", "Indie", "Rosja", "C");
            addQ(qList, "Geografia", "Stolica Japonii?", "Kioto", "Osaka", "Tokio", "Nagoja", "C");
            addQ(qList, "Geografia", "Najgłębszy ocean?", "Atlantycki", "Indyjski", "Spokojny", "Arktyczny", "C");
            addQ(qList, "Geografia", "Największy kraj świata?", "Kanada", "USA", "Chiny", "Rosja", "D");
            addQ(qList, "Geografia", "Stolica Niemiec?", "Monachium", "Berlin", "Hamburg", "Frankfurt", "B");
            addQ(qList, "Geografia", "Rzeka w Warszawie?", "Odra", "Wisła", "Warta", "Bug", "B");
            addQ(qList, "Geografia", "Najmniejszy kontynent?", "Europa", "Australia", "Antarktyda", "Ameryka", "B");
            addQ(qList, "Geografia", "Stolica Włoch?", "Mediolan", "Rzym", "Neapol", "Florencja", "B");
            addQ(qList, "Geografia", "Kraj z piramidami?", "Sudan", "Egipt", "Libia", "Meksyk", "B");
            addQ(qList, "Geografia", "Stolica Hiszpanii?", "Barcelona", "Madryt", "Sewilla", "Walencja", "B");
            addQ(qList, "Geografia", "Kontynent z Brazylią?", "Ameryka Pn", "Ameryka Pd", "Afryka", "Azja", "B");
            addQ(qList, "Geografia", "Najwyższy szczyt Polski?", "Giewont", "Śnieżka", "Rysy", "Kasprowy", "C");
            addQ(qList, "Geografia", "Stolica USA?", "Nowy Jork", "Waszyngton", "LA", "Chicago", "B");
            addQ(qList, "Geografia", "Kraj Wikingów?", "Szwecja", "Norwegia", "Dania", "Islandia", "B");
            addQ(qList, "Geografia", "Morze nad Polską?", "Bałtyckie", "Północne", "Czarne", "Śródziemne", "A");
            addQ(qList, "Geografia", "Stolica Grecji?", "Saloniki", "Ateny", "Patra", "Heraklion", "B");
            addQ(qList, "Geografia", "Waluta w Japonii?", "Juan", "Won", "Jen", "Dolar", "C");
            addQ(qList, "Geografia", "Największa pustynia?", "Gobi", "Sahara", "Atakama", "Kalahari", "B");
            addQ(qList, "Geografia", "Stolica Kanady?", "Toronto", "Ottawa", "Vancouver", "Montreal", "B");
            addQ(qList, "Geografia", "Gdzie leży Londyn?", "Irlandia", "Anglia", "Szkocja", "Walia", "B");
            addQ(qList, "Geografia", "Kraj z Kangurami?", "Nowa Zelandia", "Australia", "Indonezja", "RPA", "B");
            addQ(qList, "Geografia", "Największa wyspa?", "Kuba", "Islandia", "Grenlandia", "Borneo", "C");
            addQ(qList, "Geografia", "Stolica Austrii?", "Linz", "Salzburg", "Wiedeń", "Graz", "C");
            addQ(qList, "Geografia", "Rzeka w Egipcie?", "Amazonka", "Nil", "Kongo", "Ganges", "B");
            addQ(qList, "Geografia", "Największe jezioro świata?", "Górne", "Wiktoria", "Kaspijskie", "Bajkał", "C");
            addQ(qList, "Geografia", "Góra Fudżi jest w?", "Chinach", "Japonii", "Nepalu", "Indiach", "B");

            // INFORMATYKA (30)
            addQ(qList, "Informatyka", "Skrót HTML?", "High Text", "HyperText Markup Language", "Hyperlink", "Hard", "B");
            addQ(qList, "Informatyka", "Twórca Linuxa?", "Gates", "Jobs", "Torvalds", "Zuckerberg", "C");
            addQ(qList, "Informatyka", "Pamięć operacyjna?", "HDD", "SSD", "RAM", "CPU", "C");
            addQ(qList, "Informatyka", "Język stylów?", "Java", "Python", "CSS", "C++", "C");
            addQ(qList, "Informatyka", "Bezpieczny protokół?", "HTTP", "HTTPS", "FTP", "SSH", "B");
            addQ(qList, "Informatyka", "Mózg komputera?", "GPU", "CPU", "RAM", "Zasilacz", "B");
            addQ(qList, "Informatyka", "Ile bitów w bajcie?", "4", "8", "16", "32", "B");
            addQ(qList, "Informatyka", "Twórca Facebooka?", "Musk", "Jobs", "Zuckerberg", "Bezos", "C");
            addQ(qList, "Informatyka", "System Apple na PC?", "Windows", "iOS", "macOS", "Linux", "C");
            addQ(qList, "Informatyka", "Błąd w programie?", "Bug", "Wirus", "Luka", "Crash", "A");
            addQ(qList, "Informatyka", "Skrót klawiszowy Kopiuj?", "Ctrl+C", "Ctrl+V", "Ctrl+X", "Ctrl+Z", "A");
            addQ(qList, "Informatyka", "Skrót klawiszowy Wklej?", "Ctrl+C", "Ctrl+V", "Ctrl+Z", "Ctrl+X", "B");
            addQ(qList, "Informatyka", "Co robi Ctrl+Z?", "Kopiuje", "Cofa", "Zapisuje", "Usuwa", "B");
            addQ(qList, "Informatyka", "Język z wężem?", "C#", "Ruby", "Python", "PHP", "C");
            addQ(qList, "Informatyka", "Najmniejsza jednostka?", "Bajt", "Kilobajt", "Bit", "Megabit", "C");
            addQ(qList, "Informatyka", "Skrót od dysku?", "HDD", "RAM", "ROM", "GPU", "A");
            addQ(qList, "Informatyka", "Firma od Ryzenów?", "Intel", "Nvidia", "AMD", "Apple", "C");
            addQ(qList, "Informatyka", "Symbol @ to?", "Małpa", "A", "At", "Kółko", "A");
            addQ(qList, "Informatyka", "Sieć globalna?", "LAN", "MAN", "Internet", "WLAN", "C");
            addQ(qList, "Informatyka", "Rozszerzenie grafiki?", "txt", "exe", "jpg", "mp3", "C");
            addQ(qList, "Informatyka", "Kto stworzył iPhone?", "Samsung", "Apple", "Nokia", "Sony", "B");
            addQ(qList, "Informatyka", "Urządzenie wyjściowe?", "Monitor", "Mysz", "Skaner", "Klawiatura", "A");
            addQ(qList, "Informatyka", "System Google?", "Android", "iOS", "Windows", "Symbian", "A");
            addQ(qList, "Informatyka", "Darmowe biuro?", "Office", "LibreOffice", "Photoshop", "Steam", "B");
            addQ(qList, "Informatyka", "Gdzie usunięte pliki?", "Chmura", "Kosz", "RAM", "Pulpit", "B");
            addQ(qList, "Informatyka", "WWW to?", "World Wide Web", "Web Work", "World Web", "Wrestling", "A");
            addQ(qList, "Informatyka", "Skrót URL?", "Locator", "Link", "List", "Level", "A");
            addQ(qList, "Informatyka", "Szybki dysk?", "HDD", "SSD", "CD", "DVD", "B");
            addQ(qList, "Informatyka", "Przeglądarka Google?", "Safari", "Edge", "Chrome", "Firefox", "C");
            addQ(qList, "Informatyka", "Procesor Apple?", "M1/M2", "Intel i9", "Ryzen 9", "Snapdragon", "A");

            // HISTORIA (30)
            addQ(qList, "Historia", "Chrzest Polski?", "966", "1000", "1410", "1918", "A");
            addQ(qList, "Historia", "Pierwszy król?", "Mieszko", "Chrobry", "Łokietek", "Wielki", "B");
            addQ(qList, "Historia", "II Wojna Światowa?", "1914", "1918", "1939", "1945", "C");
            addQ(qList, "Historia", "Odkrycie Ameryki?", "Magellan", "Gama", "Kolumb", "Cook", "C");
            addQ(qList, "Historia", "Grunwald?", "1300", "1410", "1510", "1610", "B");
            addQ(qList, "Historia", "Pierwszy prezydent USA?", "Lincoln", "Roosevelt", "Washington", "Kennedy", "C");
            addQ(qList, "Historia", "Mur Berliński upadł?", "1980", "1985", "1989", "1991", "C");
            addQ(qList, "Historia", "Wódz Rzymu?", "August", "Neron", "Cezar", "Trajan", "C");
            addQ(qList, "Historia", "Niepodległość Polski?", "1795", "1914", "1918", "1945", "C");
            addQ(qList, "Historia", "Autorka Skłodowska?", "Fizyka", "Chemia", "Oba", "Matma", "C");
            addQ(qList, "Historia", "Demokracja powstała w?", "Rzymie", "Grecji", "Egipcie", "Persji", "B");
            addQ(qList, "Historia", "Zjazd w Gnieźnie?", "966", "1000", "1025", "1100", "B");
            addQ(qList, "Historia", "Przywódca Solidarności?", "Wojtyła", "Wałęsa", "Jaruzelski", "Kuroń", "B");
            addQ(qList, "Historia", "Pismo Egipcjan?", "Alfabet", "Hieroglify", "Klinowe", "Łacina", "B");
            addQ(qList, "Historia", "Wiedeń 1683?", "Sobieski", "Batory", "Waza", "August", "A");
            addQ(qList, "Historia", "Powstanie Warszawskie?", "1939", "1943", "1944", "1945", "C");
            addQ(qList, "Historia", "Atak ZSRR na Polskę?", "1 wrz", "17 wrz", "1 paź", "11 lis", "B");
            addQ(qList, "Historia", "Napoleon był z?", "Włoch", "Niemiec", "Francji", "Anglii", "C");
            addQ(qList, "Historia", "Pierwsza stolica?", "Kraków", "Gniezno", "Warszawa", "Poznań", "B");
            addQ(qList, "Historia", "I Wojna Światowa?", "1905", "1914", "1918", "1939", "B");
            addQ(qList, "Historia", "Piramidy są w?", "Meksyku", "Egipcie", "Chinach", "Peru", "B");
            addQ(qList, "Historia", "Pompeje zniszczył?", "Etna", "Wezuwiusz", "Fudżi", "Popo", "B");
            addQ(qList, "Historia", "Wojtyła został Papieżem?", "1970", "1975", "1978", "1981", "C");
            addQ(qList, "Historia", "Bitwa pod Wiedniem to?", "Odsiecz", "Potop", "Zjazd", "Hołd", "A");
            addQ(qList, "Historia", "Dynastia przed Jagiellonami?", "Piastowie", "Wazowie", "Sasi", "Burboni", "A");
            addQ(qList, "Historia", "Zabójstwo Cezara?", "Idy Marcowe", "Majowe", "Grudniowe", "Styczniowe", "A");
            addQ(qList, "Historia", "Stan wojenny w Polsce?", "1980", "1981", "1982", "1983", "B");
            addQ(qList, "Historia", "Konstytucja 3 Maja?", "1772", "1791", "1793", "1795", "B");
            addQ(qList, "Historia", "Kto 'wstrzymał Słońce'?", "Heweliusz", "Kopernik", "Einstein", "Newton", "B");
            addQ(qList, "Historia", "Upadek Cesarstwa Rzymskiego?", "476", "1000", "1453", "1492", "A");

            questionRepository.saveAll(qList);
            System.out.println("Dodano " + qList.size() + " pytań do bazy.");
        }
    }

    private void addQ(List<Question> list, String cat, String con, String a, String b, String c, String d, String correct) {
        Question q = new Question();
        q.setCategory(cat);
        q.setContent(con);
        q.setOptionA(a);
        q.setOptionB(b);
        q.setOptionC(c);
        q.setOptionD(d);
        q.setCorrectAnswer(correct);
        list.add(q);
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        return "Quiz/categories";
    }

    @GetMapping("/solve/{category}")
    public String solve(@PathVariable String category, Model model) {
        List<Question> questions = category.equals("Wiedza Ogólna")
                ? questionRepository.findAll()
                : questionRepository.findByCategory(category);

        if (questions.isEmpty()) {
            System.out.println("BRAK PYTAŃ DLA KATEGORII: " + category);
        }

        Collections.shuffle(questions);
        model.addAttribute("questions", questions.subList(0, Math.min(questions.size(), 10)));
        model.addAttribute("category", category);
        return "Quiz/solve";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam Map<String, String> allParams, Model model) {
        int score = 0;
        int total = 0;
        for (String key : allParams.keySet()) {
            if (key.startsWith("q_")) {
                total++;
                Long qId = Long.parseLong(key.substring(2));
                String answer = allParams.get(key);
                Question q = questionRepository.findById(qId).orElse(null);
                if (q != null && q.getCorrectAnswer().equals(answer)) {
                    score++;
                }
            }
        }
        model.addAttribute("score", score);
        model.addAttribute("total", total);
        return "Quiz/result";
    }

    @PostMapping("/saveScore")
    public String saveScore(@RequestParam String username, @RequestParam int score) {
        Ranking ranking = rankingRepository.findByUsername(username).orElse(new Ranking());
        ranking.setUsername(username);
        ranking.setTotalScore(ranking.getTotalScore() + score);
        rankingRepository.save(ranking);
        return "redirect:/Quiz/ranking";
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        List<Ranking> list = rankingRepository.findAll();
        list.sort((a, b) -> b.getTotalScore() - a.getTotalScore());
        model.addAttribute("rankings", list);
        return "Quiz/ranking";
    }
}