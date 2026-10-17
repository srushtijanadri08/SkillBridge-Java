import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> skills = new ArrayList<>();
    static ArrayList<Integer> progress = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "skills.txt";

    public static void main(String[] args) {

        loadSkills();

        int choice = 0;

        while (choice != 7) {

            System.out.println("\nWelcome to SkillBridge!");
            System.out.println("1. Add Skills");
            System.out.println("2. View All Skills");
            System.out.println("3. Update Skill Progress");
            System.out.println("4. View Overall Progress");
            System.out.println("5. Delete a Skill");
            System.out.println("6. Save Skills");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 7.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addSkill();
                    break;

                case 2:
                    viewSkills();
                    break;

                case 3:
                    updateProgress();
                    break;

                case 4:
                    viewOverallProgress();
                    break;

                case 5:
                    deleteSkill();
                    break;

                case 6:
                    saveSkills();
                    break;

                case 7:
                    saveSkills();
                    System.out.println("Thank you for using SkillBridge!");
                    break;

                default:
                    System.out.println("Invalid choice! Choose 1 to 7.");
            }
        }

        sc.close();
    }

    // Feature 1: Add a skill without duplicates
    static void addSkill() {

        System.out.print("Enter skill name: ");
        String skillName = sc.nextLine().trim();

        if (skillName.isEmpty()) {
            System.out.println("Skill name cannot be empty!");
            return;
        }

        for (String skill : skills) {
            if (skill.equalsIgnoreCase(skillName)) {
                System.out.println("Skill already exists!");
                return;
            }
        }

        skills.add(skillName);
        progress.add(0);

        saveSkills();

        System.out.println("Skill added: " + skillName);
    }

    // Feature: View all skills
    static void viewSkills() {

        if (skills.isEmpty()) {
            System.out.println("No skills added yet!");
            return;
        }

        System.out.println("\nYour skills:");

        for (int i = 0; i < skills.size(); i++) {
            System.out.println(
                (i + 1) + ". " + skills.get(i)
                + " - " + progress.get(i) + "%"
            );
        }
    }

    // Feature: Update progress
    static void updateProgress() {

        System.out.print("Enter skill name: ");
        String searchSkill = sc.nextLine().trim();

        int index = -1;

        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).equalsIgnoreCase(searchSkill)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Skill not found!");
            return;
        }

        System.out.print("Enter progress (0-100): ");

        if (!sc.hasNextInt()) {
            System.out.println("Please enter a valid whole number!");
            sc.nextLine();
            return;
        }

        int newProgress = sc.nextInt();
        sc.nextLine();

        if (newProgress < 0 || newProgress > 100) {
            System.out.println("Progress must be between 0 and 100!");
            return;
        }

        progress.set(index, newProgress);

        saveSkills();

        System.out.println("Progress updated successfully!");
    }

    // Feature: Calculate overall progress
    static void viewOverallProgress() {

        if (skills.isEmpty()) {
            System.out.println("No skills added yet!");
            return;
        }

        int total = 0;

        for (int value : progress) {
            total = total + value;
        }

        double average = (double) total / skills.size();

        System.out.printf("Overall progress: %.2f%%%n", average);
    }

    // Feature 2: Delete a skill and its progress
    static void deleteSkill() {

        if (skills.isEmpty()) {
            System.out.println("No skills available to delete!");
            return;
        }

        viewSkills();

        System.out.print("Enter skill name to delete: ");
        String searchSkill = sc.nextLine().trim();

        int index = -1;

        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).equalsIgnoreCase(searchSkill)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Skill not found!");
            return;
        }

        String deletedSkill = skills.remove(index);
        progress.remove(index);

        saveSkills();

        System.out.println("Deleted skill: " + deletedSkill);
    }

    // Feature 3: Save skills and progress to a file
    static void saveSkills() {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(FILE_NAME))) {

            for (int i = 0; i < skills.size(); i++) {
                writer.println(skills.get(i) + "|" + progress.get(i));
            }

        } catch (IOException e) {
            System.out.println("Could not save skills to file.");
        }
    }

    // Feature 3: Load saved skills when the program starts
    static void loadSkills() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|", -1);

                if (parts.length != 2) {
                    continue;
                }

                String skillName = parts[0];
                int skillProgress;

                try {
                    skillProgress = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    continue;
                }

                if (skillName.trim().isEmpty()
                        || skillProgress < 0
                        || skillProgress > 100) {
                    continue;
                }

                boolean duplicate = false;

                for (String skill : skills) {
                    if (skill.equalsIgnoreCase(skillName)) {
                        duplicate = true;
                        break;
                    }
                }

                if (!duplicate) {
                    skills.add(skillName);
                    progress.add(skillProgress);
                }
            }

        } catch (IOException e) {
            System.out.println("Could not load saved skills.");
        }
    }
}
