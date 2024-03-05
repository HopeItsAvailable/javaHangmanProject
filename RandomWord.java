/* Authors: Helen Zhang, Rachel Holdren, Francisco Carranza, Saniya Bhatnagar, Kathryn Yokoyama
*  File Name: RandomWord.java
*  Specification: This file holds the words, and methods to generate a random word and get the word array from the generated word.
*  For: CSE 110 9:05 AM- 9:55 AM Honors Project
*  Time Spent: 1 hour
*/

import java.lang.Math;
import java.util.*;

public class RandomWord
{ //word bank - array of words to be called on by random
	public static String[] wordBank = {"addition","advertisement", "abruptly", "adjustment",
			"apparatus", "absurd", "abyss", "affix", "askew", "avenue", "awkward", "axiom",
			"azure", "bagpipes", "bandwagon", "banjo", "beekeeper", "bikini", "blitz",
			"blizzard", "boggle", "bookworm", "boxcar", "boxful", "buffalo", "buffoon", "buxom",
			"buzzard", "buzzing", "buzzwords", "caliph", "cobweb", "comparison", "competition",
			"conscious", "cockiness", "croquet", "crypt", "cycle", "disavow", "dizzying", "duplex",
			"dwarves", "discussion", "division", "distribution", "embezzle", "equip", "espionage",
			"exodus", "expansion", "experience", "faking", "fishhook", "fixable", "fjord", "flapjack",
			"flopping", "fluffiness", "flyby", "foxglove", "frazzled", "frizzled", "foolish", "fuchsia",
			"funny", "gabby", "galaxy", "galvanize", "gazebo", "gizmo", "glowworm", "glyph", "gnarly",
			"gossip", "grogginess", "haiku", "haphazard", "hyphen", "icebox", "injury", "instrument",
			"insurance", "invention", "ivory", "ivy", "jackpot", "jaundice", "jawbreaker", "jaywalk",
			"jazziest", "jazzy", "jelly", "jigsaw", "jinx", "jiujitsu", "jockey", "jogging", "joking",
			"jovial", "joyful", "juicy", "jukebox", "jumbo", "kayak", "kazoo", "keyhole", "khaki",
			"kilobyte", "kiosk", "kiwifruit", "klutz", "knapsack", "larynx", "lengths", "lucky", 
			"luxury", "lymph", "marquis", "matrix", "megahertz", "microwave", "mystify", "nightclub",
			"nowadays", "numbskull", "nymph", "onyx", "ovary", "oxidize", "oxygen", "observation",
			"observatory", "organization", "ornament", "pajama", "peekaboo", "phlegm", "pixel", "pizazz",
			"pneumonia", "psyche", "puppy", "parallel", "parcel", "political", "probable", "punishment",
			"protection", "powerful", "puzzling", "quartz", "queue", "quixotic", "quiz", "quizzes",
			"quorum", "rhubarb", "rhythm", "repetition", "representative", "responsible",
			"rewarding", "rickshaw", "schnapps", "scratch", "snazzy", "sphinx", "spritz", "selection",
			"simplicity", "sneeze", "stationary", "squawk", "staff", "strength", "strengths",
			"stretch", "stronghold", "subway", "swivel", "syndrome", "thriftless", "thumbscrew",
			"topaz", "transparency", "tendency", "tomorrow", "transcendence", "transcript",
			"transgress", "transplant", "twelfth", "twelfths", "unknown", "unworthy", "unzip",
			"uptown", "vaporize", "voodoo", "violent", "voice", "vortex", "walkway", "waltz",
			"wave", "wavy", "waxy", "wellspring", "wheezy", "weather", "whiskey", "whizzing",
			"whomever", "wimpy", "witchcraft", "wizard", "wristwatch", "wyvern", "xylophone",
			"yoked", "youthful", "yummy", "yesterday", "zigzag", "zigzagging", "zipper", "zodiac",
			"zombie"};
	private static String word;
    private static int wordLength;
    private static char [] wordArray;

//generates a random index and calls a random word from the word bank
    public static String genWord()
    {
    	word = wordBank[(int) (Math.random() * wordBank.length)];
    	return word;
    }
    
//places the letters of the word into a word array to be used within the HangingMan.java class
    public static char[] getWordArray()
    {
        //generates word from genWord() method
    	genWord();
        wordLength = word.length();
    	wordArray = new char[wordLength];
        
        //loops to place each letter into the array of the word
        for (int i = 0; i < word.length(); i++)
        {
           wordArray[i] = word.charAt(i);
        }
        return wordArray;
    }
}
