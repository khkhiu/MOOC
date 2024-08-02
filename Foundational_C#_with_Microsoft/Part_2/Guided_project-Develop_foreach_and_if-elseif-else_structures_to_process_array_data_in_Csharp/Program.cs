/*
You're developing a Student Grading application that automates the calculation of grades for each student in a class. The parameters for your application are:

    Create a C# console application.

    Start with four students. Each student has five exam scores.

    Each exam score is an integer value, 0-100, where 100 represents 100% correct.

    A student's overall exam score is the average of their five exam scores.

    Criteria for extra credit assignments:
        Include extra credit assignment scores in the student's scores array.
        Extra credit assignments are worth 10% of an exam score (when calculating the final numeric grade).
        Add extra credit assignment scores to the student's total exam score before calculating the final numeric grade.

    Your application needs to automatically assign letter grades based on the calculated final score for each student.

    Your application needs to output/display each student’s name and formatted grade.

    Your application needs to support adding other students and scores with minimal impact to the code.

You've already completed an initial version of the application. The Starter code project for this Guided project module includes a Program.cs file that provides the following code features:

    The code declares variables used to define student names and individual exam scores for each student.
    The code includes the variables and algorithms used to sum the exam scores and calculate the average exam score for each student.
    The code includes a hard coded letter grade that the developer must apply manually.
    The code includes Console.WriteLine() statements to display the student grading report.

Your goal is to update the existing code to include the following features:

    Use arrays to store student names and assignment scores.

    Use a foreach statement to iterate through the student names as an outer program loop.

    Use an if statement within the outer loop to identify the current student name and access that student's assignment scores.

    Use a foreach statement within the outer loop to iterate through the assignment scores array and sum the values.

    Use an updated algorithm within the outer loop to calculate the average exam score for each student.

    Use an if-elseif-else construct within the outer loop to evaluate the average exam score and assign a letter grade automatically.

    Integrate extra credit scores when calculating the student's final score and letter grade as follows:
        Your code must detect extra credit assignments based on the number of elements in the student's scores array.
        Your code must apply the 10% weighting factor to extra credit assignments before adding extra credit scores to the sum of exam scores.

*/
// initialize variables - graded assignments
int examAssignments = 5;

int[] sophiaScores = new int[] { 90, 86, 87, 98, 100, 94, 90 };
int[] andrewScores = new int[] { 92, 89, 81, 96, 90, 89 };
int[] emmaScores = new int[] { 90, 85, 87, 98, 68, 89, 89, 89 };
int[] loganScores = new int[] { 90, 95, 87, 88, 96, 96 };
int[] beckyScores = new int[] { 92, 91, 90, 91, 92, 92, 92 };
int[] chrisScores = new int[] { 84, 86, 88, 90, 92, 94, 96, 98 };
int[] ericScores = new int[] { 80, 90, 100, 80, 90, 100, 80, 90 };
int[] gregorScores = new int[] { 91, 91, 91, 91, 91, 91, 91 };    

// Adding student names to the array
string[] studentNames = new string[] { "Sophia", "Andrew", "Emma", "Logan", "Becky", "Chris", "Eric", "Gregor" };
int[] studentScores = new int[10];
string currentStudentLetterGrade = "";

// Write the Report Header to the console
Console.WriteLine("Student\t\tGrade\n");

// Printing student scores
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
    else if (currentStudent == "Becky")
        studentScores = beckyScores;
    else if (currentStudent == "Chris")
        studentScores = chrisScores;
    else if (currentStudent == "Eric")
        studentScores = ericScores;
    else if (currentStudent == "Gregor")
        studentScores = gregorScores;
    else
        continue;

    // initialize/reset the sum of scored assignments
    int sumAssignmentScores = 0;
    // initialize/reset the calculated average of exam + extra credit scores
    decimal currentStudentGrade = 0;
    // initialize/reset a counter for the number of assignment 
    int gradedAssignments = 0;

    // loop through the scores array and complete calculations for currentStudent
    foreach (int score in studentScores)
    {
        // increment the assignment counter
        gradedAssignments += 1;
        if (gradedAssignments <= examAssignments)
            // add the exam score to the sum
            sumAssignmentScores += score;
        else
            // add the extra credit points to the sum - bonus points equal to 10% of an exam score
            sumAssignmentScores += score / 10;
    }

    // Calculating student grades
    currentStudentGrade = (decimal)(sumAssignmentScores) / examAssignments;
    // Assigning student grades
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

    //Console.WriteLine("Student\t\tGrade\tLetter Grade\n");
    Console.WriteLine($"{currentStudent}\t\t{currentStudentGrade}\t{currentStudentLetterGrade}");
}

// required for running in VS Code (keeps the Output windows open to view results)
Console.WriteLine("\n\rPress the Enter key to continue");
Console.ReadLine();