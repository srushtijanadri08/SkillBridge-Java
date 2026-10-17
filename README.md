# SkillBridge-Java 🚀

A console-based Java application to manage learning goals and track skill progress.

## 📌 About the Project

SkillBridge is a beginner-friendly Java project that helps users maintain a list of skills they are learning, update their progress, and calculate their overall learning progress. It also saves skill information to a file so that data can be loaded the next time the application starts.

## ✨ Features

- **Add Skills:** Add new skills to your learning list.
- **Prevent Duplicates:** Avoid adding the same skill more than once, regardless of letter case.
- **View Skills:** Display all saved skills and their progress.
- **Update Progress:** Update progress from 0% to 100%.
- **Overall Progress:** Calculate the average progress across all skills.
- **Delete Skills:** Remove a skill and its associated progress.
- **File Persistence:** Save and load skill data using `skills.txt`.
- **Input Validation:** Handle invalid menu choices and progress values.

## 🛠️ Technologies Used

- Java
- Java Collections Framework (`ArrayList`)
- File Handling (`FileReader`, `FileWriter`, `BufferedReader`, `PrintWriter`)
- Exception Handling
- Git and GitHub

## ▶️ How to Run

### Prerequisites

Install the Java Development Kit (JDK) and make sure `java` and `javac` are available in your terminal.

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/srushtijanadri08/SkillBridge-Java.git
   ```

2. Open the project folder:

   ```bash
   cd SkillBridge-Java
   ```

3. Compile the program:

   ```bash
   javac Main.java
   ```

4. Run the application:

   ```bash
   java Main
   ```

## 📋 Menu Options

| Option | Action |
|---|---|
| 1 | Add Skills |
| 2 | View All Skills |
| 3 | Update Skill Progress |
| 4 | View Overall Progress |
| 5 | Delete a Skill |
| 6 | Save Skills |
| 7 | Exit |

## 💾 Data Storage

The application stores each skill and its progress in `skills.txt`. When the program starts, it loads the saved data automatically.

Example file content:

```text
Java|80
SQL|40
Python|20
```

The `skills.txt` file is created in the working directory when the application saves data. It is excluded from Git using `.gitignore`, so personal learning data is not included in the repository.

## 🎯 Learning Outcomes

This project helped me practise:

- Java methods and control flow
- Loops and switch statements
- `ArrayList` operations
- Searching and duplicate checking
- Input validation
- File reading and writing
- Exception handling
- Git and GitHub workflow

## 👩‍💻 Author

**Srushti Janadri**

GitHub: [@srushtijanadri08](https://github.com/srushtijanadri08)

---

*Built as a hands-on project to strengthen my Java programming fundamentals.*
