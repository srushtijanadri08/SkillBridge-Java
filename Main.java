
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> skills = new ArrayList<>();
        ArrayList<Integer> progress = new ArrayList<>();

        int choice = 0;

        while (choice != 5) {

            System.out.println("\nWelcome to SkillBridge!");
            System.out.println("1. Add Skills");
            System.out.println("2. View all skills");
            System.out.println("3. Update skill progress");
            System.out.println("4. View overall progress");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter skill name: ");
                    String skillName = sc.nextLine();

                    skills.add(skillName);
                    progress.add(0);

                    System.out.println("Skill added: " + skillName);
                    break;

                case 2:
                    if (skills.size() == 0) {
                        System.out.println("No skills added yet!");
                    } else {
                        System.out.println("Your skills:");

                        for (int i = 0; i < skills.size(); i++) {
                            System.out.println(
                                skills.get(i) + " - " + progress.get(i) + "%"
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter skill name: ");
                    String searchSkill = sc.nextLine();

                    int index = skills.indexOf(searchSkill);

                    if (index == -1) {
                        System.out.println("Skill not found!");
                    } else {
                        System.out.print("Enter new progress percentage: ");
                        int newProgress = sc.nextInt();
                        sc.nextLine();

                        if (newProgress >= 0 && newProgress <= 100) {
                            progress.set(index, newProgress);
                            System.out.println("Progress updated successfully!");
                        } else {
                            System.out.println(
                                "Invalid progress! Enter a value between 0 and 100."
                            );
                        }
                    }
                    break;

                case 4:
                    if (skills.size() == 0) {
                        System.out.println("No skills added yet!");
                    } else {
                        int total = 0;

                        for (int i = 0; i < progress.size(); i++) {
                            total = total + progress.get(i);
                        }

                        int average = total / skills.size();

                        System.out.println("Overall progress: " + average + "%");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using SkillBridge!");
                    break;

                default:
                    System.out.println("Invalid choice! Please choose 1 to 5.");
            }
        }

        sc.close();
    }
}
