
/**
 * This class tests the code for Lab4: Exercise2. It creates a GeographyQuiz,
 * adding elements from an input file to an unordered list, then calling them up
 * randomly to provide questions and answers for the game. Remember that different lists add elements in FiLo or LiFo.
 * It expands upon a framework provided by Srini (Dr. Srini Sampalli). Modified by Rob from previous version.
 */

//import Labs.Lab4Fall2020.List; //package to be commented out

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GeographyQuiz {
	public static void main(String[] args) throws IOException {
		// initialize Scanner to capture user input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		Scanner in = new Scanner(System.in);

		File file = new File(filename);
		Scanner inputFile = new Scanner(file);

		//set up list and country & capital object
		ArrayList<CountryCapital> countriesAndCapitals = new ArrayList<CountryCapital>(); //ArrayList
		CountryCapital countryCap = null; //object

		// capture file information from user and read file
		// initialize List to store data from the text file
		while(inputFile.hasNext()) {
			//country
			String country = inputFile.nextLine();
			//capital
			String capital = inputFile.nextLine();
			countryCap = new CountryCapital(country, capital);
			countriesAndCapitals.add(countryCap);
		}

		inputFile.close();

		Random r = new Random(); //random number generator
		double score = 0;
		double totalQuestions = 0;

		System.out.println("Welcome to the Country-Capital Quiz\n" +
				"Play?");

		String command;
		int randomNumber;
		while (keyboard.hasNextLine()) { //while there is a new input
			command = keyboard.nextLine(); //input a command such as play or no
			if (command.equals("play")) {
				randomNumber = r.nextInt(countriesAndCapitals.size());//cap number at list size
				//help to summon a random Question
				int randomNumbertoDetermine = r.nextInt(countriesAndCapitals.size());
				totalQuestions++;

				if (randomNumbertoDetermine % 2 == 0) { //if it is even then ask a capital Q
					System.out.println("What is the capital of " + countriesAndCapitals.get(randomNumber).getCountry());

					//take in the answer
					String answer = in.nextLine();

					//if the answer is the same as the capital partnered with country
					if (answer.equals(countriesAndCapitals.get(randomNumber).getCapital())) {
						System.out.println("Correct, \nPlay?");
						score++; //increase score
					} else { //is not correct
						System.out.println("Incorrect. The correct answer is " +
								countriesAndCapitals.get(randomNumber).getCapital()
								+ " \nPlay?");
					}

				} else { //it is odd and ask a Country Q
					System.out.println("What is the Country has " + countriesAndCapitals.get(randomNumber).getCapital() +
							" as it's capital?");

					//take in the answer
					String answer = in.nextLine();
					//is the answer the same as the country partnered with the capital
					if (answer.equals(countriesAndCapitals.get(randomNumber).getCountry())) {
						System.out.println("Correct, \nPlay?");
						score++; //increase score
					} else {
						System.out.println("Incorrect. The correct answer is " +
								countriesAndCapitals.get(randomNumber).getCountry()
								+ " \nPlay?");
					}
				}

			} else { //anything but play will trigger this
				System.out.println("Game over.");
				double percentage = (score / totalQuestions)*100;
				System.out.print("Game Stats: \nQuestions played: " + totalQuestions
						+ "\nCorrect answers: " + score + "\nScore: " + percentage +"%");
			}
		}
	}
}