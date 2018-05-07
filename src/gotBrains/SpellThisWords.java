package gotBrains;

import java.util.LinkedList;

public class SpellThisWords {
	String[] wordsEasy = { "Sun", "Son", "Ball", "Wood", "Fond", "Nine", "Home", "Girl", "Fish", "Hell", "Five", "Hope",
			"Wife", "King", "Wifi", "Hair", "City", "Math", "Desk", "Foot", "Cool", "Body", "Golf", "Asia", "Work",
			"Lady", "Cake", "Band", "High", "Corn", "Word", "Good", "Gold", "Pink", "Oven", "Four", "Bath", "Yard",
			"Zero", "Cube", "Book", "Card", "Bomb", "Sock", "Lava", "Worm", "Nova", "Quit", "Ugly", "Rice", "World",
			"Pizza", "Water", "Month", "Eyes", "Area", "Music", "Glow", "Woman", "Party", "Peace", "Tiger", "Dead",
			"House", "July", "Watch", "Clock", "Lock", "June", "Santa", "Club", "Bank", "Fork", "Iris", "Cell", "Luck",
			"Blood", "Light", "India", "Power", "Soap", "Drum", "Peak", "Puppy", "Phone", "Queen", "Army", "Bond",
			"Knife", "Magic", "Black", "Data", "Truth", "Fake", "Gang", "Dirty", "Fruit", "Panda", "Radio", "Jazz",
			"Puma", "Prop", "Taxi", "Lung", "Pork", "Dirt", "Clue", "Copy", "Bash", "Yoga", "Text", "Crow", "Pray",
			"Size", "Next", "Oval", "Pro", "Hack", "Diss", "Fold", "Fury", "Sofa", "Numb", "Joke", "Eggs", "Comb",
			"Whip", "Calf", "Monk", "Tomb", "Navy", "Apex", "Twin", "Pump", "Hulk", "Bulk", "Swim", "Dumb", "Pill",
			"Lens", "Quiz", "Geek", "Halo", "Howl", "Mime", "Debt", "Pulp", "Term", "Feud", "Rich" };

	String[] wordsMedium = { "Hello", "Purple", "Twelve", "Samsung", "Heaven", "Banana", "Africa", "People", "Snitch",
			"Pumpkin", "Perfect", "Freedom", "Nothing", "History", "Amazing", "Welcome", "Turtle", "Dolphin", "Justice",
			"System", "Mother", "Spring", "Pirate", "Autumn", "Summer", "Season", "Memory", "Bottle", "Couple",
			"Cookie", "Guitar", "Police", "Bullet", "Soccer", "Hungry", "Murder", "Turkey", "Killer", "Number",
			"Spirit", "Dragon", "Shadow", "Peanut", "Zombie", "Puzzle", "Vision", "Target", "Lizard", "Cheese",
			"Rocket", "Health", "Legend", "Subway", "Donkey", "Clever", "Public", "Europe", "Cactus", "Window",
			"Square", "Galaxy", "League", "Genius", "Helium", "Uranus", "Object", "Motion", "Volcano", "Rhythm",
			"Movies", "Cowboy", "Legacy", "Trophy", "Social", "Thunder", "Needle", "Boxing", "Pocket", "Jacket",
			"Villain", "Muscle", "Effect", "Accent", "Orphan", "Karate", "Victory", "Station", "Advice", "Charge",
			"Jaguar", "College", "Biscuit", "Central", "Contact", "Trigger", "Lyrical", "Present", "Warrior", "Society",
			"Sweater" };

	String[] wordsHard = { "Valkyire", "Football", "Strength", "February", "Building", "Relationship", "Calendar",
			"November", "Everything", "Basketball", "Technology", "Watermelon", "Champion", "Hospital", "Chocolate",
			"Friendship", "Medicine", "University", "Blackboard", "Whiteboard", "Jupiter", "Mountain", "Umbilical",
			"Computer", "Electric", "Doughnut", "Paradise", "Keyboard", "Dinosaur", "Aquarium", "Aardvark", "Australia",
			"Smoothie", "Arachnid", "Festival", "Campfire", "Training", "Lemonade", "Popsicle", "Broccoli", "Fraction",
			"Addition", "Anaconda", "Blackout", "Audience", "Pineapple", "Division", "Goldfish", "Colorful", "Geometry",
			"Nitrogen", "Fabulous", "Dumpster", "Ambulance", "Blizzard", "Eighteen", "Vegetable", "Crocodile",
			"Register", "Gasoline", "Exercise", "Question", "Bracelet", "Complain", "Antelope", "Nutrition", "Ambiance",
			"Breakfast", "Aerobics", "Pentagon", "Backpack", "Cylinder", "Location", "Juvenile", "Universe", "Prospect",
			"Whiskers", "Industry", "Wellness", "Conflict", "Celebrity", "Handsome", "Dynamite", "Mosquito", "Fortress",
			"District", "Companion", "Bathroom", "Humanity", "Donation", "Moonlight", "Aeroplane", "Particles",
			"Invention", "Milkshake", "Evolution", "Exception", "Autograph", "Champagne", "Authentic" };

	LinkedList<String> easyWords = new LinkedList<String>();
	LinkedList<String> mediumWords = new LinkedList<String>();
	LinkedList<String> hardWords = new LinkedList<String>();

	public SpellThisWords() {
		populateLists();
	}

	public void populateLists() {
		for (int i = 0; i < wordsEasy.length; i++) {
			easyWords.add(wordsEasy[i]);
		}
		for (int i = 0; i < wordsMedium.length; i++) {
			mediumWords.add(wordsMedium[i]);
		}
		for (int i = 0; i < wordsMedium.length; i++) {
			hardWords.add(wordsHard[i]);
		}
	}

	public LinkedList<String> getEasyWords() {
		return easyWords;
	}

	public LinkedList<String> getMediumWords() {
		return mediumWords;
	}

	public LinkedList<String> getHardWords() {
		return hardWords;
	}

}
