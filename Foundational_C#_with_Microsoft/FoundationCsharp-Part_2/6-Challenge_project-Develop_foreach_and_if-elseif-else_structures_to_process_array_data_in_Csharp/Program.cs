/*
The Starter code project for this module is a C# console application that implements the following code features:

    Uses arrays to store student names and assignment scores.

    Uses a foreach statement to iterate through the student names as an outer program loop.

    Uses an if statement within the outer loop to identify the current student's name and access that student's assignment scores.

    Uses a foreach statement within the outer loop to iterate through the assignment scores array and sum the values.

    Uses an algorithm within the outer loop to calculate the average exam score for each student.

    Use an if-elseif-else construct within the outer loop to evaluate the average exam score and assign a letter grade automatically.

    Integrates extra credit scores when calculating the student's final score and letter grade as follows:
        Detects extra credit assignments based on the number of elements in the student's scores array.
        Applies a 10% weighting factor to extra credit assignments before adding extra credit scores to the sum of exam scores.

Your goal in this challenge is to implement the coding updates required to produce the teacher's requested score report.

The current score report lists the student's name followed by the calculated overall grade and letter grade. Here is the existing report format:

Student         Grade   Letter Grade

Sophia          95.6    A
Andrew          91.6    A-
Emma            89.2    B+
Logan           93      A

In addition to the student's final numeric score and letter grade, the teacher wants the updated report to include the exam score and the impact that extra credit work has on the student's final grade. The format of the updated score report should appear as follows:

Student         Exam Score      Overall Grade   Extra Credit

Sophia          92.2            95.88   A       92 (3.68 pts)
Andrew          89.6            91.38   A-      89 (1.78 pts)
Emma            85.6            90.94   A-      89 (5.34 pts)
Logan           91.2            93.12   A       96 (1.92 pts)

*/
// initialize variables - graded assignments
int examAssignments = 5;

string[] studentNames = new string[] { "Sophia", "Andrew", "Emma", "Logan" };

int[] sophiaScores = new int[] { 90, 86, 87, 98, 100, 94, 90 };
int[] andrewScores = new int[] { 92, 89, 81, 96, 90, 89 };
int[] emmaScores = new int[] { 90, 85, 87, 98, 68, 89, 89, 89 };
int[] loganScores = new int[] { 90, 95, 87, 88, 96, 96 };
int[] studentScores = new int[10];

string currentStudentLetterGrade = "";

// display the header row for scores/grades
Console.WriteLine("\nStudent\t\tExam Score\tOverall Grade\tExtra Credit\n");

/*
Outer foreach loop OPS:
1. iterate through student names 
2. assign a student's grades to the studentScores array
3. (nested foreach loop) calculate exam and extra credit totals 
4. calculate numeric and letter grade
5. write the score report information
*/
foreach (string name in studentNames)
{
    string currentStudent = name;

    if (currentStudent == "Sophia")
        studentScores = sophiaScores;
    else if (currentStudent == "Andrew")
        studentScores = andrewScores;
    else if (currentStudent == "Emma")
        studentScores = emmaScores;
    else if (currentStudent == "Logan")
        studentScores = loganScores;

    int gradedAssignments = 0;
    int gradedExtraCreditAssignments = 0;
    int totalExamScores = 0;
    int totalExtraCreditScores = 0;

    decimal currentStudentGrade = 0;
    decimal currentStudentExamScore = 0;
    decimal currentStudentExtraCreditScore = 0;

    /* 
    nested foreach loop OPS: 
    - sums the exam and extra credit scores
    - counts the extra credit assignments
    */
    foreach (int score in studentScores)
    {
        gradedAssignments += 1;
        if (gradedAssignments <= examAssignments)
        {
            totalExamScores = totalExamScores + score;
        }
        else
        {
            gradedExtraCreditAssignments += 1;
            totalExtraCreditScores += score;
        }
    }

    // Calculating scores
    currentStudentExamScore = (decimal)(totalExamScores) / examAssignments;
    currentStudentExtraCreditScore = (decimal)(totalExtraCreditScores) / gradedExtraCreditAssignments;
    currentStudentGrade = (decimal)((decimal)totalExamScores + ((decimal)totalExtraCreditScores / 10)) / examAssignments;

    // Assigning grades
    if (currentStudentGrade >= 97)
        currentStudentLetterGrade = "A+";
    else if (currentStudentGrade >= 93)
        currentStudentLetterGrade = "A";
    else if (currentStudentGrade >= 90)
        currentStudentLetterGrade = "A-";
    else if (currentStudentGrade >= 87)
        currentStudentLetterGrade = "B+";
    else if (currentStudentGrade >= 83)
        currentStudentLetterGrade = "B";
    else if (currentStudentGrade >= 80)
        currentStudentLetterGrade = "B-";
    else if (currentStudentGrade >= 77)
        currentStudentLetterGrade = "C+";
    else if (currentStudentGrade >= 73)
        currentStudentLetterGrade = "C";
    else if (currentStudentGrade >= 70)
        currentStudentLetterGrade = "C-";
    else if (currentStudentGrade >= 67)
        currentStudentLetterGrade = "D+";
    else if (currentStudentGrade >= 63)
        currentStudentLetterGrade = "D";
    else if (currentStudentGrade >= 60)
        currentStudentLetterGrade = "D-";
    else
        currentStudentLetterGrade = "F";

    // Printing student scores and grades
    Console.WriteLine($"{currentStudent}\t\t{currentStudentExamScore}\t\t{currentStudentGrade}\t{currentStudentLetterGrade}\t{currentStudentExtraCreditScore} ({(((decimal)totalExtraCreditScores / 10) / examAssignments)} pts)");
}

// required for running in VS Code (keeps the Output windows open to view results)
Console.WriteLine("\n\rPress the Enter key to continue");
Console.ReadLine();
