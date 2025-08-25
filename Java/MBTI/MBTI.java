import java.util.Scanner;

public class MBTI {

    static String[] questions = {
        "1. You regularly make new friends.",
        "2. Complex and novel ideas excite you more than simple and straightforward ones.",
        "3. You usually feel more persuaded by what resonates emotionally with you than by factual arguments.",
        "4. Your living and working spaces are clean and organized.",
        "5. You usually stay calm, even under a lot of pressure.",
        "6. You prefer routines and clear plans over spontaneity.",
        "7. You prioritize and plan tasks effectively, often completing them well before the deadline.",
        "8. People’s stories and emotions speak louder to you than numbers or data.",
        "9. You like to use organizing tools like schedules and lists.",
        "10. Even a small mistake can cause you to doubt your overall abilities and knowledge.",
        "11. You feel comfortable just walking up to someone you find interesting and striking up a conversation.",
        "12. You are not too interested in discussions about various interpretations of creative works.",
        "13. You prioritize facts over people’s feelings when determining a course of action.",
        "14. You often allow the day to unfold without any schedule at all.",
        "15. You rarely worry about whether you make a good impression on people you meet.",
        "16. You enjoy participating in team-based activities.",
        "17. You enjoy experimenting with new and untested approaches.",
        "18. You prioritize being sensitive over being completely honest.",
        "19. You actively seek out new experiences and knowledge areas to explore.",
        "20. You are prone to worrying that things will take a turn for the worse."
    };

    static String[][] traits = {
        {"expend energy, enjoy groups", "conserve energy, enjoy one-on-one"},
        {"interpret literally", "look for meaning and possibilities"},
        {"logical, thinking, questioning", "empathetic, feeling, accommodating"},
        {"organized, orderly", "flexible, adaptable"},
        {"more outgoing, think out loud", "more reserved, think to yourself"},
        {"practical, realistic, experiential", "imaginative, innovative, theoretical"},
        {"candid, straight forward, frank", "tactful, kind, encouraging"},
        {"plan, schedule", "unplanned, spontaneous"},
        {"seek many tasks, public activities, interaction with others", "seek private, solitary activities with quiet to concentrate"},
        {"standard, usual, conventional", "different, novel, unique"},
        {"firm, tend to criticize, hold the line", "gentle, tend to appreciate, conciliate"},
        {"regulated, structured", "easy-going, 'live' and let live"},
        {"external, communicative, express yourself", "internal, reticent, keep to yourself"},
        {"focus on here-and-now", "look to the future, global perspective, big picture"},
        {"tough-minded, just", "tender-hearted, merciful"},
        {"preparation, plan ahead", "go with the flow, adapt as you go"},
        {"active, initiate", "reflective, deliberate"},
        {"facts, things, what is", "ideas, dreams, what could be, philosophical"},
        {"matter of fact, issue-oriented", "sensitive, people-oriented, compassionate"},
        {"control, govern", "latitude, freedom"}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n =-=-=-= WELCOME TO THE MYERS-BRIGGS TYPE INDICATOR =-=-=-= ");
        System.out.print("What is your name? ");
        String userName = input.nextLine();
        System.out.println("Welcome " + userName + " to our MBTI Test!");
        System.out.println("Please answer each question with A or B.\n");

        String[] responses = new String[questions.length];

        for (int questionNumber = 0; questionNumber < questions.length; questionNumber++) {
            String answer;
            while (true) {
                System.out.println(questions[questionNumber]);
                System.out.print("Your answer (A/B): ");
                answer = input.nextLine().trim().toUpperCase();

                if (answer.equals("A") || answer.equals("B")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter only A or B.\n");
                }
            }
            responses[questionNumber] = answer;
        }

        System.out.println("\nHello " + userName + ", You selected:\n");

        int[][] groups = {
            {0, 4, 8, 12, 16},
            {1, 5, 9, 13, 17},
            {2, 6, 10, 14, 18},
            {3, 7, 11, 15, 19}
        };

        String personality = "";

        for (int g = 0; g < groups.length; g++) {
            int countA = 0, countB = 0;
            for (int q : groups[g]) {
                if (responses[q].equals("A")) {
                    System.out.println("A. " + traits[q][0]);
                    countA++;
                } else {
                    System.out.println("B. " + traits[q][1]);
                    countB++;
                }
            }
            System.out.println("Number of A selected: " + countA);
            System.out.println("Number of B selected: " + countB + "\n");

            if (g == 0) personality += (countA >= countB) ? "E" : "I";
            if (g == 1) personality += (countA >= countB) ? "S" : "N";
            if (g == 2) personality += (countA >= countB) ? "T" : "F";
            if (g == 3) personality += (countA >= countB) ? "J" : "P";
        }

        System.out.println("Your personality type is: " + personality);
    }
}
