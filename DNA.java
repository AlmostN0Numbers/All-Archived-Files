//Reid Morin
//Lab 6 DNA
//PROGRAM READS AN INPUT FILE AND DISPLAYS DETAILS OF CERTAIN GENES
//December 10 2019

import java.util.*;
import java.io.*;
import java.text.*;

public class DNA {
   //Collection of static intergers used for calculating file output
	public static final int MNC = 5; 				
   public static final double CG = 30.0;			
   public static final int UN = 4; 			
   public static final int NPC = 3; 

		public static void main(String[] args) throws FileNotFoundException {
		String inputText = input();
		String outputText = output();
		Scanner DNA = new Scanner(new File(inputText));
		PrintStream out =  new PrintStream(new File(outputText));
		while(DNA.hasNextLine()) { 
			name(DNA.nextLine(), out); 
			String sequenceDNA = sequence(DNA.nextLine(), out); 
			int[] nuc_Count = nuc_Count(sequenceDNA, out);	
			double[] percentages = masses(nuc_Count, out);  																		
			String codonList = groupCodons(sequenceDNA, out); 
			proteinTest(codonList, percentages, out); 
		}
	}
	   //User input method
		public static String input() throws FileNotFoundException {
		System.out.println("This program reports information about DNA");
		System.out.println("nucleotides sequences that may encode proteins.");
		System.out.print("Input file name? ");
		Scanner input = new Scanner(System.in); 
    	String text = (input.next());
		return text;
	}
	   //Program creates a text file where output data is stored with the user creating a name
		public static String output() {
		System.out.print("Output file name? ");
		Scanner output = new Scanner(System.in); 
    	String text = (output.next());
		return text;
	}
	//Region print method
	public static void name(String name, PrintStream out) {	
		out.println("Region Name: " + name);
	}
	//Nucleotides print method calling algorithm as well
	public static String sequence(String sequenceDNA, PrintStream out) {
		sequenceDNA = sequenceDNA.toUpperCase();
		out.println("Nucleotides: " + sequenceDNA);
		return sequenceDNA; 
	}
	//Algorithm for nucleotides
	public static int[] nuc_Count(String sequenceDNA, PrintStream out) throws FileNotFoundException {
		int[] counts = new int[UN + 1]; 
		char[] codons = {'A', 'C', 'G', 'T', '-'};
		for(int i = 0; i < sequenceDNA.length(); i++) {
			char c = sequenceDNA.charAt(i);
			for(int j = 0; j < codons.length; j++) {
				if(c == codons[j]) {
					counts[j]++;
				}
			}
		}
		int[] counts_Short = Arrays.copyOf(counts, 4); 
		out.println("Nuc. Counts: " + Arrays.toString(counts_Short));
		return counts;
	}
	   //Algorith for mass
		public static double[] masses(int[] nuc_Count, PrintStream out) throws FileNotFoundException {
		double[] masses_Constant = {135.128, 111.103, 151.128, 125.107, 100.000}; //constant masses for 
		double[] masses_Nuc = new double[5];
		double totalMass = 0;
		for(int i = 0; i < 5; i++) { 
			masses_Nuc[i] = nuc_Count[i] * masses_Constant[i];
			totalMass += masses_Nuc[i];
		}		
		
		
		double[] percentages = convert_Percentage(masses_Nuc, totalMass); 
		double[] percentages2 = Arrays.copyOf(percentages, 4); 
		out.print("Total Mass%: " + Arrays.toString(percentages2) + " of ");
		out.printf("%.1f", totalMass);
		out.println();
		return percentages; 
	}
	//Formula for making intergers percent
	public static double[] convert_Percentage(double[] masses_Nuc, double totalMass) throws FileNotFoundException {
		double[] percentages = new double[5];
		for(int i = 0; i <=4; i++) {
			percentages[i] = Math.round((masses_Nuc[i] / totalMass * 100) * 10.0) / 10.0;
		}
		return percentages; 
	}
	//Algorithm for codons + print method
	public static String groupCodons(String sequenceDNA, PrintStream out) throws FileNotFoundException {
		String sequenceDNA2 = sequenceDNA.replace("-","");
		int length = sequenceDNA2.length() / NPC;
		String[] codons = new String[length];
		int j = 1; 
		for(int i = 0; i <= sequenceDNA2.length() - NPC; i = i + NPC) {
			String codon = sequenceDNA2.substring(i, NPC * j);
			codons[j - 1] = codon;
			j++;       
      }	
		String codonList = Arrays.toString(codons);
		out.println("Codons List: " + codonList);
		return codonList; 
	}
	//Method for checking if protien designation is valid
	public static void proteinTest(String codonList, double[] percentages, PrintStream out) {
			if (startTest(codonList) 
			&& stopTest(codonList) 
			&& mNCTest(codonList) 
			&& percentageTest(percentages)) { 
				out.println("Is Protein?: YES");
		} else {
			out.println("Is Protein?: NO");
		}
		out.println(); 
	}
	//start method
	public static boolean startTest(String codonList) {
		return(codonList.substring(1, 4).equals("ATG"));
	}
	//stop method
	public static boolean stopTest(String codonList) {
		String EndC  = codonList.substring(codonList.length() - 4, codonList.length() - 1);
      return (EndC.equals("TAA") || EndC.equals("TAG") || EndC.equals("TGA"));
	}
	
	public static boolean mNCTest(String codonList) {
		return(codonList.charAt(19) == ',');
	}
	
	public static boolean percentageTest(double[] percentages) {
		return(percentages[1] + percentages[2] >= 30.0);
	}
}