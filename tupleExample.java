////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Author: Thomas Preston
//
////////////////////////////////////////////////////////////////////////////////////////////////////

// Imports
import java.util.Arrays;

// Tuples for returning 2 values at once
final class intArrayStringTuple {
    public int[] teamInfo; // These are what the type holds in its memory
    public String teamName;

    public intArrayStringTuple(int[] teamInfo, String teamName) { // This is a constructor meaning that when an assignment of this type is
                                                                  // made, this code will execute but requies these paramaters
        this.teamInfo = teamInfo;
        this.teamName = teamName;
    }
    
    public String toString() { // This allows the type to be printed "nicely" eg. instead of "intArrayStringTuple@7a81197d",
                               // we get "England: [5, 7, 9, 7, 2, 300]"
        return teamName + ": " + Arrays.toString(teamInfo);
    }
}

// Main Class
public class tupleExample {
    public static void main(String[] args) {                          // Pts, W, D, L, GD, Rat, etc. (based on input from random matches)
                                                                      // Currently Based on random numbers
        intArrayStringTuple England = new intArrayStringTuple(new int[] {5, 7, 9, 7, 2, 300}, "England");
        intArrayStringTuple Wales = new intArrayStringTuple(new int[] {4, 9, 10, 7, 7, 100}, "Wales");
        intArrayStringTuple Scotland = new intArrayStringTuple(new int[] {7, 10, 10, 0, 3, 700}, "Scotland");
        intArrayStringTuple Ireland = new intArrayStringTuple(new int[] {8, 6, 10, 8, 0, 800}, "Ireland");

        intArrayStringTuple[] teams = {England, Wales, Scotland, Ireland}; // Array of all teams
        
        // Use "England.teamInfo" to access the data (Pts, W,D,L, GD, Rat)
        // Use "England.teamName" to access the name of the team

        // i<(number of teams-1)
        // j<(number of team-i)
        for (int i=0; i<3; i++) { // Bubble Sort into Decending Order results in Ireland, Scotland, England, Wales in this case
            for (int j=0; j<(3-i); j++) {
                if (teams[j].teamInfo[0] < teams[j+1].teamInfo[0]) { // If the points from team1 (England) are less than points of team2 (Wales)
                    intArrayStringTuple temp = teams[j];
                    teams[j]= teams[j+1];
                    teams[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(teams)); // [Ireland: [8, 6, 10, 8, 0, 800], Scotland: [7, 10, 10, 0, 3, 700], England: [5, 7, 9, 7, 2, 300], Wales: [4, 9, 10, 7, 7, 100]]
    }
}