import java.util.Scanner;
import java.util.Random;

public class HANGMAN_SUMMATIVE{
    public static void main (){
        Scanner sc = new Scanner(System.in);
        char begin; // holds 'Z'
       
        System.out.println("\t\t\t\tWelcome to Hangman!"); // start menu
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("\nPress 'Z' to begin.");
       
        do {
            begin = sc.next().charAt(0);
            if (begin == 'Z' || begin == 'z'){
                String word = getWord(); // generate random word
               
                System.out.println();
                for (int i = 0; i < word.length(); i++){
                    System.out.print("_"); // prints word for the first time
                }
                System.out.println();
                System.out.println("\nThe number of letters in the word is " + word.length() + ".");
                guessMenu(word); // sends the user to start guessing
            } 
        } while (begin != 'Z' && begin != 'z'); // continues to ask until user enters 'Z'
    }
   
    public static String getWord (){
        Random random = new Random();
        String word = null;
       
        final String[] words = {"About", "Above", "Abuse", "Accept", "Accident", "Accuse", "Across", "Activist", "Actor", "Administration", "Admit", "Adult", "Advertise", "Advise", "Affect", "Afraid", "After", "Again", "Against", "Agency", "Aggression", "Agree", "Agriculture", "Force", "Airplane", "Airport", "Album", "Alcohol", "Alive", "Almost", "Alone", "Along", "Already", "Although", "Always", "Ambassador", "Amend", "Ammunition", "Among", "Amount", "Anarchy", "Ancestor", "Ancient", "Anger", "Animal", "Anniversary", "Announce", "Another", "Answer", "Apologize", "Appeal", "Appear", "Appoint", "Approve", "Archeology", "Argue", "Around", "Arrest", "Arrive", "Artillery", "Assist", "Astronaut", "Astronomy", "Asylum", "Atmosphere", "Attach", "Attack", "Attempt", "Attend", "Attention", "Automobile", "Autumn", "Available", "Average", "Avoid", "Awake", "Award", "Balance", "Balloon", "Ballot", "Barrier", "Battle", "Beauty", "Because", "Become", "Before", "Begin", "Behavior", "Behind", "Believe", "Belong", "Below", "Betray", "Better", "Between", "Biology", "Black", "Blame", "Bleed", "Blind", "Block", "Blood", "Border", "Borrow", "Bottle", "Bottom", "Boycott", "Brain", "Brave", "Bread", "Break", "Breathe", "Bridge", "Brief", "Bright", "Bring", "Broadcast", "Brother", "Brown", "Budget", "Build", "Building", "Bullet", "Burst", "Business", "Cabinet", "Camera", "Campaign", "Cancel", "Cancer", "Candidate", "Capital", "Capture", "Career", "Careful", "Carry", "Catch", "Cause", "Ceasefire", "Celebrate", "Center", "Century", "Ceremony", "Chairman", "Champion", "Chance", "Change", "Charge", "Chase", "Cheat", "Cheer", "Chemicals", "Chemistry", "Chief", "Child", "Children", "Choose", "Circle", "Citizen", "Civilian", "Civil", "Rights", "Claim", "Clash", "Class", "Clean", "Clear", "Clergy", "Climate", "Climb", "Clock", "Close", "Cloth", "Clothes", "Cloud", "Coalition", "Coast", "Coffee", "Collapse", "Collect", "College", "Colony", "Color", "Combine", "Command", "Comment", "Committee", "Common", "Communicate", "Community", "Company", "Compare", "Compete", "Complete", "Complex", "Compromise", "Computer", "Concern", "Condemn", "Condition", "Conference", "Confirm", "Conflict", "Congratulate", "Congress", "Connect", "Conservative", "Consider", "Constitution", "Contact", "Contain", "Container", "Continent", "Continue", "Control", "Convention", "Cooperate", "Correct", "Corruption", "Cotton", "Count", "Country", "Court", "Cover", "Crash", "Create", "Creature", "Credit", "Crime", "Criminal", "Crisis", "Criticize", "Crops", "Cross", "Crowd", "Crush", "Culture", "Curfew", "Current", "Custom", "Customs", "Damage", "Dance", "Danger", "Daughter", "Debate", "Decide", "Declare", "Decrease", "Defeat", "Defend", "Deficit", "Define", "Degree", "Delay", "Delegate", "Demand", "Democracy", "Demonstrate", "Denounce", "Depend", "Deplore", "Deploy", "Depression", "Describe", "Desert", "Design", "Desire", "Destroy", "Detail", "Detain", "Develop", "Device", "Dictator", "Different", "Difficult", "Dinner", "Diplomat", "Direct", "Direction", "Disappear", "Disarm", "Disaster", "Discover", "Discrimination", "Discuss", "Disease", "Dismiss", "Dispute", "Dissident", "Distance", "Divide", "Doctor", "Document", "Dollar", "Donate", "Double", "Dream", "Drink", "Drive", "Drown", "During", "Early", "Earth", "Earthquake", "Ecology", "Economy", "Education", "Effect", "Effort", "Either", "Elect", "Electricity", "Embassy", "Embryo", "Emergency", "Emotion", "Employ", "Empty", "Enemy", "Energy", "Enforce", "Engine", "Engineer", "Enjoy", "Enough", "Enter", "Environment", "Equal", "Equipment", "Escape", "Especially", "Establish", "Estimate", "Ethnic", "Evaporate", "Event", "Every", "Evidence", "Exact", "Examine", "Example", "Excellent", "Except", "Exchange", "Excuse", "Execute", "Exercise", "Exile", "Exist", "Expand", "Expect", "Expel", "Experience", "Experiment", "Expert", "Explain", "Explode", "Explore", "Export", "Express", "Extend", "Extra", "Extraordinary", "Extreme", "Extremist", "Factory", "False", "Family", "Famous", "Father", "Favorite", "Federal", "Female", "Fence", "Fertile", "Field", "Fierce", "Fight", "Final", "Financial", "Finish", "Fireworks", "First", "Float", "Flood", "Floor", "Flower", "Fluid", "Follow", "Force", "Foreign", "Forest", "Forget", "Forgive", "Former", "Forward", "Freedom", "Freeze", "Fresh", "Friend", "Frighten", "Front", "Fruit", "Funeral", "Future", "Gather", "General", "Generation", "Genocide", "Gentle", "Glass", "Goods", "Govern", "Government", "Grain", "Grass", "Great", "Green", "Grind", "Ground", "Group", "Guarantee", "Guard", "Guerrilla", "Guide", "Guilty", "Happen", "Happy", "Harvest", "Headquarters", "Health", "Heavy", "Helicopter", "Hijack", "History", "Holiday", "Honest", "Honor", "Horrible", "Horse", "Hospital", "Hostage", "Hostile", "Hotel", "House", "However", "Human", "Humor", "Hunger", "Hurry", "Husband", "Identify", "Ignore", "Illegal", "Imagine", "Immediate", "Immigrant", "Import", "Important", "Improve", "Incident", "Incite", "Include", "Increase", "Independent", "Individual", "Industry", "Infect", "Inflation", "Influence", "Inform", "Information", "Inject", "Injure", "Innocent", "Insane", "Insect", "Inspect", "Instead", "Instrument", "Insult", "Intelligence", "Intelligent", "Intense", "Interest", "Interfere", "International", "Internet", "Intervene", "Invade", "Invent", "Invest", "Investigate", "Invite", "Involve", "Island", "Issue", "Jewel", "Joint", "Judge", "Justice", "Kidnap", "Knife", "Knowledge", "Labor", "Laboratory", "Language", "Large", "Laugh", "Launch", "Learn", "Leave", "Legal", "Legislature", "Letter", "Level", "Liberal", "Light", "Lightning", "Limit", "Liquid", "Listen", "Literature", "Little", "Local", "Lonely", "Loyal", "Machine", "Magazine", "Major", "Majority", "Manufacture", "March", "Market", "Marry", "Material", "Mathematics", "Matter", "Mayor", "Measure", "Media", "Medicine", "Member", "Memorial", "Memory", "Mental", "Message", "Metal", "Method", "Microscope", "Middle", "Militant", "Military", "Militia", "Mineral", "Minister", "Minor", "Minority", "Minute", "Missile", "Missing", "Mistake", "Model", "Moderate", "Modern", "Money", "Month", "Moral", "Morning", "Mother", "Motion", "Mountain", "Mourn", "Movement", "Movie", "Murder", "Music", "Mystery", "Narrow", "Nation", "Native", "Natural", "Nature", "Necessary", "Negotiate", "Neighbor", "Neither", "Neutral", "Never", "Night", "Noise", "Nominate", "Normal", "North", "Nothing", "Nowhere", "Nuclear", "Number", "Object", "Observe", "Occupy", "Ocean", "Offensive", "Offer", "Office", "Officer", "Official", "Often", "Operate", "Opinion", "Oppose", "Opposite", "Oppress", "Orbit", "Order", "Organize", "Other", "Overthrow", "Paint", "Paper", "Parachute", "Parade", "Pardon", "Parent", "Parliament", "Partner", "Party", "Passenger", "Passport", "Patient", "Peace", "People", "Percent", "Perfect", "Perform", "Period", "Permanent", "Permit", "Person", "Persuade", "Physical", "Physics", "Picture", "Piece", "Pilot", "Place", "Planet", "Plant", "Plastic", "Please", "Plenty", "Point", "Poison", "Police", "Policy", "Politics", "Pollute", "Popular", "Population", "Position", "Possess", "Possible", "Postpone", "Poverty", "Power", "Praise", "Predict", "Pregnant", "Present", "President", "Press", "Pressure", "Prevent", "Price", "Prison", "Private", "Prize", "Probably", "Problem", "Process", "Produce", "Profession", "Professor", "Profit", "Program", "Progress", "Project", "Promise", "Propaganda", "Property", "Propose", "Protect", "Protest", "Prove", "Provide", "Public", "Publication", "Publish", "Punish", "Purchase", "Purpose", "Quality", "Question", "Quick", "Quiet", "Radar", "Radiation", "Radio", "Railroad", "Raise", "Reach", "React", "Ready", "Realistic", "Reason", "Reasonable", "Rebel", "Receive", "Recent", "Recession", "Recognize", "Record", "Recover", "Reduce", "Reform", "Refugee", "Refuse", "Register", "Regret", "Reject", "Relations", "Release", "Religion", "Remain", "Remains", "Remember", "Remove", "Repair", "Repeat", "Report", "Represent", "Repress", "Request", "Require", "Rescue", "Research", "Resign", "Resist", "Resolution", "Resource", "Respect", "Responsible", "Restaurant", "Restrain", "Restrict", "Result", "Retire", "Return", "Revolt", "Right", "River", "Rocket", "Rough", "Round", "Rubber", "Rural", "Sabotage", "Sacrifice", "Sailor", "Satellite", "Satisfy", "School", "Science", "Search", "Season", "Second", "Secret", "Security", "Seeking", "Seize", "Senate", "Sense", "Sentence", "Separate", "Series", "Serious", "Serve", "Service", "Settle", "Several", "Severe", "Shake", "Shape", "Share", "Sharp", "Sheep", "Shell", "Shelter", "Shine", "Shock", "Shoot", "Short", "Should", "Shout", "Shrink", "Sickness", "Signal", "Silence", "Silver", "Similar", "Simple", "Since", "Single", "Sister", "Situation", "Skeleton", "Skill", "Slave", "Sleep", "Slide", "Small", "Smash", "Smell", "Smoke", "Smooth", "Social", "Soldier", "Solid", "Solve", "Sound", "South", "Space", "Speak", "Special", "Speech", "Speed", "Spend", "Spill", "Spirit", "Split", "Sport", "Spread", "Spring", "Square", "Stand", "Start", "Starve", "State", "Station", "Statue", "Steal", "Steam", "Steel", "Stick", "Still", "Stone", "Store", "Storm", "Story", "Stove", "Straight", "Strange", "Street", "Stretch", "Strike", "Strong", "Structure", "Struggle", "Study", "Stupid", "Subject", "Submarine", "Substance", "Substitute", "Subversion", "Succeed", "Sudden", "Suffer", "Sugar", "Suggest", "Suicide", "Summer", "Supervise", "Supply", "Support", "Suppose", "Suppress", "Surface", "Surplus", "Surprise", "Surrender", "Surround", "Survive", "Suspect", "Suspend", "Swallow", "Swear", "Sweet", "Sympathy", "System", "Target", "Taste", "Teach", "Technical", "Technology", "Telephone", "Telescope", "Television", "Temperature", "Temporary", "Tense", "Terrible", "Territory", "Terror", "Terrorist", "Thank", "Theater", "Theory", "There", "These", "Thick", "Thing", "Think", "Third", "Threaten", "Through", "Throw", "Tired", "Today", "Together", "Tomorrow", "Tonight", "Torture", "Total", "Touch", "Toward", "Trade", "Tradition", "Traffic", "Tragic", "Train", "Transport", "Transportation", "Travel", "Treason", "Treasure", "Treat", "Treatment", "Treaty", "Trial", "Tribe", "Trick", "Troops", "Trouble", "Truce", "Truck", "Trust", "Under", "Understand", "Unite", "Universe", "University", "Unless", "Until", "Urgent", "Usual", "Vacation", "Vaccine", "Valley", "Value", "Vegetable", "Vehicle", "Version", "Victim", "Victory", "Video", "Village", "Violate", "Violence", "Visit", "Voice", "Volcano", "Volunteer", "Wages", "Waste", "Watch", "Water", "Wealth", "Weapon", "Weather", "Weigh", "Welcome", "Wheat", "Wheel", "Where", "Whether", "Which", "While", "White", "Whole", "Willing", "Window", "Winter", "Withdraw", "Without", "Witness", "Woman", "Wonder", "Wonderful", "World", "Worry", "Worse", "Worth", "Wound", "Wreck", "Wreckage", "Write", "Wrong", "Yellow", "Yesterday", "Young"};
        word = words[random.nextInt(1001)]; // picks word from array
        // https://gist.github.com/alpha-tango/c3d2645817cf4af2aa45 - wordbank credit
       
        return word;
    }
   
    public static void guessMenu (String word){
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Note that you can quit at anytime by entering '1'.");
        System.out.println("Guess a letter.\n"); // first guess
        String guess = sc.nextLine();
        
        char newWord [] = new char [word.length()]; // stores current word
        char guessedLetters [] = new char [26]; // stores guessed letters
        int tries = 1; // stores # of tries
        boolean exists = checkGuess(word, guess, guessedLetters, tries); // checks if letter is right
        boolean GUESSED = false; // true = correctly guessed the word
       
        do {
            if (!exists) { // wrong guess
                System.out.println();
                guess = sc.nextLine(); // prompts user again
                tries++;
                exists = checkGuess(word, guess, guessedLetters, tries); // checks if char or string
            } else { // correct guess
                newWord = updateWord(word, guess, newWord, tries); // updates array
                System.out.println();
                System.out.println("The current word is now: "); // prints updated word
                for (int i = 0; i < newWord.length; i++){
                    if (newWord[i] == 0){
                        System.out.print("_");
                    } else {
                        System.out.print(newWord[i]);
                    }
                }
                System.out.println("\n");
                guess = sc.nextLine(); // prompts user again
                tries++;
                exists = checkGuess(word, guess, guessedLetters, tries); // checks if char or string
            }
        } while (!GUESSED); // runs while user has not successfully guessed word
    }
   
    public static boolean checkGuess (String word, String guess, char guessedLetters [], int tries){
        boolean exists = false;
        
        if (guess.equals("1")){ // checks if user wishes to quit
           quitOutput(word);
        }
        if (guess.length() == 1){ // if guess is char (AKA letter)
            if (!validChar(guess)){ // checks if guess is a letter
                System.out.println("Please enter a valid letter.");
                return exists;
            }
            if (previouslyGuessedLetter(guess, guessedLetters)){ // checks if letter has been previously guessed
                System.out.println("The letter '" + guess + "' has already been guessed.");
                return exists;
            }
            exists = checkLetter(word, guess, guessedLetters); // checks if letter exists in word
            if (exists){
               System.out.println("The letter '" + guess + "' is in the word.");
               return exists;
            } else {
                System.out.println("The letter '" + guess + "' is not in the word.");
                return exists;
            }
        } else { // if guess is string (AKA word)
            exists = checkWord(word, guess); // checks if guess = chosen word
            if (exists){ // if user guessed the right word
                victoryOutput(word, tries);
                return exists;
            } else {
                System.out.println("The word is not '" + guess + "'.");
                return exists; // if not, simply returns
            }  
        }
    }
    
    public static boolean validChar (String guess){
        char c = guess.charAt(0); // converts guess to char
        
        if (c < 'A' || c > 'Z' && c < 'a' || c > 'z'){ // checks if guess is a letter
            return false;
        }
        
        return true;
    }
    
    public static boolean previouslyGuessedLetter (String guess, char guessedLetters []){
        char cGuess = guess.charAt(0); // converts guess to char
        cGuess = Character.toLowerCase(cGuess); // converts to lowercase
        
        for (int i = 0; i < guessedLetters.length; i++){
            if (guessedLetters[i] == cGuess){
                return true;
            }
        } // goes through "guessed letters array"
        
        return false;
    }
   
    public static boolean checkLetter (String word, String guess, char guessedLetters []){
        char cGuess = guess.charAt(0); // converts guess to char
        cGuess = Character.toLowerCase(cGuess); // converts to lowercase
        
        for (int i = 0; i < guessedLetters.length; i++){
            if (guessedLetters[i] == 0){
               guessedLetters[i] = cGuess;
               break;
            }
        } // adds letter to the end of "already guessed letters array"

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            c = Character.toLowerCase(c); // converts to lowercase
            if (c == cGuess) {
                return true;
            }
        }
   
        return false;
    }

   
    public static boolean checkWord (String word, String guess){        
        String tempWord = "";
        String tempGuess = "";
       
        for (int i = 0; i < word.length(); i++){ // converts word to lowercase
            char c = word.charAt(i);
            c = Character.toLowerCase(c);
            tempWord = tempWord + c;
        }
        for (int i = 0; i < guess.length(); i++){ // converts guess to lowercase
            char c = guess.charAt(i);
            c = Character.toLowerCase(c);
            tempGuess = tempGuess + c;
        }
       
        if (tempWord.equals(tempGuess)){ // must use .equals to compare strings
            return true;
        }

        return false;
    }
   
    public static char [] updateWord (String word, String guess, char newWord [], int tries){
        char cGuess = guess.charAt(0); // converts guess to char
        cGuess = Character.toLowerCase(cGuess); // converts to lowercase

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            c = Character.toLowerCase(c); // converts to lowercase
            if (c == cGuess){
                if (i == 0){
                    cGuess = Character.toUpperCase(cGuess); // converts first letter to uppercase
                    newWord[i] = cGuess;
                    cGuess = Character.toLowerCase(cGuess); // back to lowercase
                } else {
                    newWord[i] = cGuess;
                }
            }
        }  
        
        String tempWord = ""; // checks if word has been completely guessed
        for (int i = 0; i < newWord.length; i++){
            tempWord = tempWord + newWord[i];
        }
        if (tempWord.equals(word)){ // must use .equals to compare strings
            victoryOutput(word, tries); // last letter has been guessed
        }
        
        return newWord;
    }
   
    public static void victoryOutput (String word, int tries){
        System.out.println();
        System.out.println("Congratulations! You have correctly guessed the word in " + tries + " tries.");
        System.out.println("The word was '" + word + "'.");
        System.exit(0); // quits program
    }
    
    public static void quitOutput (String word){
        System.out.println("The word was '" + word + "'.");
        System.exit(0); // quits program
    }
   
}