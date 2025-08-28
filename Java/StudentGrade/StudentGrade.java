import java.util.Scanner;

public class StudentGradeApp {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfStudents = getNumber(input, "Enter number of students: ");
        int numberOfSubjects = getNumber(input, "Enter number of subjects: ");
        int[][] scores = collectScores(input, numberOfStudents, numberOfSubjects);
        displaySummary(scores, numberOfSubjects);

    }



    public static int getNumber(Scanner input, String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }



    public static int[][] collectScores(Scanner input, int students, int subjects) {
        int[][] scores = new int[students][subjects];
        for (int studentInStudents = 0; studentInStudents < students; studentInStudents++) {
            System.out.println("\nEntering scores for Student " + (studentInStudents + 1));
            for (int subjectInSubjects = 0; subjectInSubjects < subjects; subjectInSubjects++) {
                scores[studentInStudents][subjectInSubjects] = getValidScore(input, subjectInSubjects + 1);
            }
        }
        return scores;
    }



    public static int getValidScore(Scanner input, int subjectNumber) {
        int score;
        while (true) {
            System.out.print("Enter score for Subject " + subjectNumber + ": ");
            score = input.nextInt();
            if (score >= 0 && score <= 100) {
                return score;
            }
            System.out.println(" Invalid score, Score must be between 0 and 100.");
        }
    }




    public static void displaySummary(int[][] scores, int subjects) {
        System.out.println("\n================== EMMA CLASS SUMMARY ==================\n");
        System.out.print("STUDENT\t\t");
        for (int j = 0; j < subjects; j++) {
            System.out.print("SUB" + (j + 1) + "\t");
        }
        System.out.println("TOTAL\tAVERAGE\tPOS");

        int students = scores.length;
        int[] totals = new int[students];
        double[] averages = new double[students];

        for (int i = 0; i < students; i++) {
            int total = 0;
            for (int j = 0; j < subjects; j++) {
                total += scores[i][j];
            }
            totals[i] = total;
            averages[i] = (double) total / subjects;
        }

        int[] positions = new int[students];
        for (int i = 0; i < students; i++) {
            int pos = 1;
            for (int j = 0; j < students; j++) {
                if (totals[j] > totals[i]) {
                    pos++;
                }
            }
            positions[i] = pos;
        }

        for (int i = 0; i < students; i++) {
            System.out.print("Student " + (i + 1) + "\t");
            for (int j = 0; j < subjects; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.println(totals[i] + "\t" + String.format("%.2f", averages[i]) + "\t" + positions[i]);
        }

        System.out.println("---|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|---");
    }


}


