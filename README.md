# AI-Based Resume Analyzer

A beginner-friendly Java command-line project that analyzes a resume against a job description. It extracts common skills, calculates a job-match percentage, identifies missing skills, and generates an analysis report.

## Features

- Reads a resume from a `.txt` file
- Reads a job description from a `.txt` file
- Detects skills using a predefined skill dictionary
- Compares resume skills with job-required skills
- Calculates a match percentage
- Identifies missing skills
- Gives simple improvement suggestions
- Generates a text report
- Runs completely from the command line

## Technologies

- Java 17+
- Maven
- Java Collections Framework
- File I/O
- Regular-expression based text processing

## Project Structure

```text
AI-Based-Resume-Analyzer/
├── README.md
├── pom.xml
├── .gitignore
├── src/
│   └── main/
│       ├── java/com/resumeanalyzer/
│       │   ├── Main.java
│       │   ├── Resume.java
│       │   ├── ResumeParser.java
│       │   ├── JobDescription.java
│       │   ├── SkillMatcher.java
│       │   ├── ResumeAnalyzer.java
│       │   └── ReportGenerator.java
│       └── resources/
│           ├── resume.txt
│           └── job-description.txt
└── output/
    └── .gitkeep
```

## Requirements

Install:

1. JDK 17 or later
2. Apache Maven 3.8+

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

## Setup

Clone the public GitHub repository:

```bash
git clone https://github.com/{github-username}/{repo-name}.git
cd {repo-name}
```

No external API key or database is required.

## Run the Project

Build the project:

```bash
mvn clean package
```

Run the generated JAR:

```bash
java -jar target/ai-based-resume-analyzer-1.0.0.jar
```

Or run directly with Maven:

```bash
mvn exec:java
```

If your Maven installation does not have the exec plugin configured, use the JAR command above.

## Input Files

The sample files are:

- `src/main/resources/resume.txt`
- `src/main/resources/job-description.txt`

You can replace their content with your own plain-text resume and job description.

The application can also ask for custom file paths when started.

## How Matching Works

1. Resume text is loaded.
2. Job description text is loaded.
3. Text is normalized to lowercase.
4. The program checks a predefined list of common technical skills.
5. Skills found in the resume are stored in a set.
6. Skills required by the job description are stored in another set.
7. Common skills are treated as matched skills.
8. Missing required skills are identified.
9. Match percentage is calculated as:

```text
Match Percentage =
(Matched Required Skills / Total Required Skills) × 100
```

This is a rule-based text analysis project rather than a trained machine-learning model. The project name uses "AI-Based" because it automates resume analysis and skill-gap detection, but it does not claim to be a trained neural-network model.

## Example

For a resume containing:

```text
Java, Python, SQL, Git, Data Structures
```

and a job requiring:

```text
Java, SQL, Git, Spring Boot, REST API, MySQL
```

the program can report the matched and missing skills and calculate the percentage from the required skills it detected.

## Output

The result is displayed in the terminal and saved to:

```text
output/analysis-report.txt
```

## Future Scope

- PDF/DOCX resume extraction
- Natural-language processing
- TF-IDF or semantic similarity
- More advanced skill extraction
- Database storage
- Web interface
- Multiple job-description comparison
- Resume improvement recommendations

## Author

Akshat Bajpai

## License

This project is intended for educational use.
