package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Class with multiple strings to autogenerate series
public class SeriesRandData {
    public String[] actors = {"Tom Hanks", "Meryl Streep", "Leonardo DiCaprio", "Jennifer Lawrence", "Brad Pitt", "Cate Blanchett", "Denzel Washington", "Kate Winslet", "Robert De Niro", "Natalie Portman", "Johnny Depp", "Julia Roberts", "Daniel Day-Lewis", "Charlize Theron", "Matt Damon", "Emma Stone", "Morgan Freeman", "Angelina Jolie", "George Clooney", "Viola Davis", "Tom Cruise", "Joaquin Phoenix", "Julianne Moore", "Christian Bale", "Nicole Kidman", "Al Pacino", "Scarlett Johansson", "Samuel L. Jackson", "Harrison Ford", "Anne Hathaway", "Dwayne Johnson", "Jennifer Aniston", "Mark Ruffalo", "Jessica Chastain", "Will Smith", "Emma Watson", "Sandra Bullock", "Chris Hemsworth", "Jennifer Lopez", "Hugh Jackman", "Amy Adams", "Ryan Gosling", "Cameron Diaz", "Jamie Foxx", "Gal Gadot", "Eddie Redmayne", "Margot Robbie", "Chris Evans", "Reese Witherspoon", "Matthew McConaughey"};
    public String[] categories = {"Action", "Adventure", "Animation", "Comedy", "Crime", "Drama", "Fantasy", "Historical", "Horror", "Mystery", "Romance", "Science Fiction", "Thriller", "Western", "Biography", "Documentary", "Family", "Musical", "War", "Sport", "Superhero", "Spy", "Noir", "Supernatural", "Suspense", "Political", "Psychological", "Coming of Age", "Disaster", "Apocalyptic", "Zombie", "Mockumentary", "Satire", "Slasher", "Courtroom Drama", "Heist", "Time Travel", "Cyberpunk", "Post-Apocalyptic", "Neo-Noir", "Space Opera", "Alien Invasion", "Period Drama", "Music", "Gangster"};
    public String[] countries = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Democratic Republic of the Congo", "Republic of the Congo", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
    public String[] directors = {"Steven Spielberg", "Martin Scorsese", "Christopher Nolan", "Quentin Tarantino", "David Fincher", "Alfred Hitchcock", "Stanley Kubrick", "Francis Ford Coppola", "James Cameron", "Ridley Scott", "Tim Burton", "Peter Jackson", "Woody Allen", "Clint Eastwood", "Coen Brothers", "Darren Aronofsky", "Hayao Miyazaki", "Akira Kurosawa", "Spike Lee", "Paul Thomas Anderson", "Wes Anderson", "Guillermo del Toro", "David Lynch", "Pedro Almodóvar", "Yasujiro Ozu", "Federico Fellini", "Ingmar Bergman", "Michael Bay", "Example Mc Example", "Steven Soderbergh", "David Cronenberg", "Guy Ritchie", "Danny Boyle", "Bong Joon-ho", "Roman Polanski", "Martin McDonagh", "George Lucas", "Greta Gerwig", "Denis Villeneuve", "Paul Verhoeven", "Christopher McQuarrie", "Terrence Malick", "Alejandro González Iñárritu", "Makoto Shinkai", "Judd Apatow", "Lars von Trier", "Gaspar Noé", "Sofia Coppola", "Robert Zemeckis"};
    public String[] languages = {"English", "Spanish", "Mandarin Chinese", "Hindi", "Arabic", "Bengali", "Portuguese", "Russian", "Japanese", "German", "Korean", "French", "Turkish", "Vietnamese", "Tamil", "Italian", "Urdu", "Indonesian", "Polish", "Ukrainian", "Persian", "Romanian", "Dutch", "Greek", "Hungarian", "Swedish", "Czech", "Thai", "Finnish", "Hebrew"};
    public String[] ratingSources = {"IMDb", "Rotten Tomatoes", "Metacritic", "The Movie Database (TMDb)", "Letterboxd", "Fandango", "IGN", "Empire", "Collider", "Filmweb", "IndieWire", "Screen Rant", "Variety", "The A.V. Club", "Entertainment Weekly", "Film Threat", "Roger Ebert", "CinemaBlend", "Sight & Sound", "The Guardian", "Film Comment", "Rolling Stone", "Total Film", "The Hollywood Reporter", "Film School Rejects"};
    public String[] writers = {"Aaron Sorkin", "Quentin Tarantino", "Christopher Nolan", "Martin Scorsese", "Steven Spielberg", "George Lucas", "Francis Ford Coppola", "David Fincher", "Wes Anderson", "Spike Lee", "Coen Brothers", "Hayao Miyazaki", "James Cameron", "Greta Gerwig", "Stanley Kubrick", "Alfred Hitchcock", "Ridley Scott", "Clint Eastwood", "Gillian Flynn", "Charlie Kaufman", "Paul Thomas Anderson", "David Lynch", "Nora Ephron", "Christopher McQuarrie", "Jordan Peele", "Paddy Chayefsky", "Billy Wilder", "Cameron Crowe", "Akira Kurosawa", "Darren Aronofsky", "John Hughes", "Frank Darabont", "Makoto Shinkai", "David Mamet", "Robert Towne", "Sidney Lumet", "Ethan Coen", "Joel Coen", "Yasujiro Ozu", "Ingmar Bergman", "Federico Fellini", "Charlie Chaplin", "Werner Herzog", "Orson Welles", "François Truffaut", "Jean-Luc Godard", "Pedro Almodóvar", "Wong Kar-wai", "Satoshi Kon", "Michael Haneke", "Gus Van Sant", "David Cronenberg", "Lars von Trier", "Alejandro González Iñárritu"};
    public String[] series = {"Breaking Bad", "Game of Thrones", "Friends", "Stranger Things", "The Crown", "The Office", "Money Heist", "The Mandalorian", "The Witcher", "Sherlock", "Black Mirror", "The Simpsons", "The Big Bang Theory", "The Queen's Gambit", "Narcos", "Dark", "Peaky Blinders", "Rick and Morty", "Better Call Saul", "The Haunting of Hill House", "Mindhunter", "Fargo", "The Handmaid's Tale", "Loquesea", "The Sopranos", "Loquesea 2", "Ran Out of Ideas", "Money", "The Witcher", "Black Mirror", "The Simpsons", "The Queen's Gambit", "Narcos", "Peaky Blinders", "Rick and Morty", "The Haunting of Hill House", "Mindhunter", "Fargo", "The Handmaid's Tale", "Lost", "The Sopranos", "Friends", "The Office", "Game of Thrones", "The Mandalorian", "Sherlock", "The Big Bang Theory", "Better Call Saul", "Breaking Bad", "Stranger Things", "The Crown"};
    public String[] contentRatings = {null, "TV-MA", "18+", "R18+", "18A", "16", "MA15+", "NC-17", "15", "R", "M18", "16+", "R21", "18", "G", "TV-Y", "TV-G", "E", "U", "PG", "TV-PG"};

    private String[] uniquify(String[] str) {
        Set<String> unique = new HashSet<>(Arrays.asList(str));
        return unique.toArray(new String[0]);
    }
    
    
    public SeriesRandData() {
        this.actors = uniquify(actors);
        this.categories = uniquify(categories);
        this.countries = uniquify(countries);
        this.directors = uniquify(directors);
        this.languages = uniquify(languages);
        this.ratingSources = uniquify(ratingSources);
        this.writers = uniquify(writers);
        this.series = uniquify(series);
        this.contentRatings = uniquify(contentRatings);
    }
}