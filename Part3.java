/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package assignment;
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import java.util.Arrays;
import javax.swing.JOptionPane;
public class Part3 {
 
 private static String TaskName;
 private static int TaskNumber;
 private static String TaskDescription;
 private static String DeveloperDetails;
 private static int TaskDuration;
 private static String TaskID;
 //private static String TaskStatus;
 private static int taskcount;
 private static int tasks;
 private static int option; 
 private static int progress;
 private static int billHours;
 private static String []Developer;
 private static String []TaskNames;
 private static String []TaskIDs;
 private static int []TaskDurations;
 private static int []TaskStatus;
 private static int mostHours;
 
 
 
 /**
 * @param args the command line arguments
 */
 public static void main(String[] args) {
 // TODO code application logic here
 Welcome();
 AddTask();
 TotalHours();
 }
 public static void Welcome(){
 JOptionPane.showMessageDialog(null,"Welcome to EasyKanban" );
 }
 public static void AddTask(){
 do{
 option=Integer.parseInt(JOptionPane.showInputDialog( "\nSelect from the options 
below"+"\n1"+" "+"Add a task"+"\n2"+" "+"Show report"+"\n3"+" "+"Quit" ));
 switch(option){
 case 1:
 taskcount =Integer.parseInt(JOptionPane.showInputDialog(null,"How many tasks do you wish to 
record:"));
 //initalise Arrays
 Developer =new String[taskcount];
 TaskNames =new String[taskcount];
 TaskIDs =new String[taskcount];
 TaskStatus =new int[taskcount];
 TaskDurations =new int[taskcount];
 for(int i = 0;i < taskcount; i ++ ) {//for task count is less tne number of tasks
 
 if (tasks<taskcount)
 
 TaskName =(JOptionPane.showInputDialog(null,"Task Name:"));
 TaskNumber=i+1;
 JOptionPane.showMessageDialog(null,TaskNumber);
 
 TaskDescription =(JOptionPane.showInputDialog(null,"Task Description:"));
 checkTaskDescription();
 DeveloperDetails =(JOptionPane.showInputDialog(null,"Developer Details(Full Name):"));
 TaskDuration =Integer.parseInt(JOptionPane.showInputDialog(null,"Task Duration (inhours):"));
 createTaskID();
 progress=Integer.parseInt(JOptionPane.showInputDialog("Select from the options below"+"\n1 
To Do"+"\n2 Done"+"\n3 Doing"));
 switch(progress){
 case 1:
 JOptionPane.showMessageDialog(null,"To Do");
 break;
 case 2:
 JOptionPane.showMessageDialog(null,"Done");
 break;
 case 3:
 JOptionPane.showMessageDialog(null,"Doing");
 }
 
 //save input in array
 tasks = tasks + 1;
 Developer[tasks-1]=DeveloperDetails;
 TaskNames[tasks-1]=TaskName;
 TaskIDs[tasks-1]=TaskID;
 TaskDurations[tasks-1]=TaskDuration;
 TaskStatus[tasks-1]=progress;
 
 billHours += TaskDuration;
 printTaskDetails();
 DisplayReport();
 }
 break;
 
 case 2:
 JOptionPane.showMessageDialog(null,"Coming soon");
 JOptionPane.showMessageDialog(null,"Developers:\n"+Arrays.toString(Developer));
 JOptionPane.showMessageDialog(null,"Task Names:\n"+Arrays.toString(TaskNames));
 JOptionPane.showMessageDialog(null,"Task Status:\n"+Arrays.toString(TaskStatus));
 JOptionPane.showMessageDialog(null,"Task Duration:\n"+Arrays.toString(TaskDurations));
 // mostHours = TaskDuration;
 
 if (mostHours > TaskDuration) {
 //stores the task that with most hours
 mostHours = Math.max(mostHours, TaskDuration);
 JOptionPane.showMessageDialog(null,"Developer with longest Task.\n\n" +"\nDeveloper 
Details:"+ DeveloperDetails +"\nTask Duration:"+ mostHours);
 }
 //Search for tasks
 String TaskSearch = JOptionPane.showInputDialog(null,"Search for tasks:");
 if (Arrays.toString(TaskNames).contains(TaskSearch)){
 JOptionPane.showMessageDialog(null,TaskSearch + " found"); 
 }else {
 JOptionPane.showMessageDialog(null,TaskSearch + " not found");
 }
 
 //Search all tasks assigned to Developer
 String tasksforDev = JOptionPane.showInputDialog(null,"Developer Task search:");
 if (Arrays.toString(Developer).contains(tasksforDev)){
 JOptionPane.showMessageDialog(null,tasksforDev + " found"); 
 }else {
 JOptionPane.showMessageDialog(null,tasksforDev + " not found");
 }
 
 //Delete Task from array
 String RemovedTask = JOptionPane.showInputDialog(null,"Delete Task from array:");
 if (Arrays.toString(TaskNames).contains(RemovedTask)) {
 JOptionPane.showMessageDialog(null,"Entry "+RemovedTask + " successfully deleted"); 
 }else {
 JOptionPane.showMessageDialog(null,"Entry " +RemovedTask + " not deleted");
 } 
 break;
 case 3:
 JOptionPane.showMessageDialog(null,"Quit");
 break;
 default:
 JOptionPane.showMessageDialog(null,"Invalid response");
 
 }
 }while
 (option != 3);
}
 public static boolean checkTaskDescription(){
 
 if (TaskDescription.length() < 50)
 JOptionPane.showMessageDialog(null,"Task successfully captured");
 else
 JOptionPane.showMessageDialog(null,"Please enter a task description of less than 50 characters");
 return true;
 
 }
 public static void createTaskID(){
 
 String ID = TaskName;
 String[] part = ID.split("\\s"); // array to get each word by itself 
 
 for(int id = 0; id < part.length; id++){
 char l = part[id].charAt(0);//get first letter, first value of array is 0
 String L = String.valueOf(l).toUpperCase();//convert to upper case
 
 
 
 String Developer = DeveloperDetails;//last 3 Capital letters
 String J = DeveloperDetails.substring(DeveloperDetails.length()-3);
 JOptionPane.showMessageDialog(null,"TaskID:\n" + L + ":" + TaskNumber + ":" + J.toUpperCase());
 
}
 }
 public static void printTaskDetails(){
 String ID = TaskName;
 String[] part = ID.split("\\s"); // array to get each word by itself 
 
 for(int id = 0; id < part.length; id++){
 char l = part[id].charAt(0);//get first letter, first value of array is 0
 String L = String.valueOf(l).toUpperCase();//convert to upper case
 
 String Developer = DeveloperDetails;//last 3 Capital letters
 String J = DeveloperDetails.substring(DeveloperDetails.length()-3);
 
 String K = L + ":" + TaskNumber + ":" + J.toUpperCase();
 JOptionPane.showMessageDialog(null,"\nTask Status: " + progress + "\nDeveloper Details: " + 
DeveloperDetails+ "\nTask Number: " + TaskNumber + "\nTask Name: " + TaskName + "\nTask 
Description: " + TaskDescription + "\nTaskID: " + K + "\nTask Duration: " + TaskDuration);
 
}
 }
 public static void TotalHours(){
 JOptionPane.showMessageDialog(null,"Total hours spent on tasks:" + billHours); 
 }
 public static void DisplayReport(){
 System.out.println("\nTask Status: " + progress + "\nTask Name: " + TaskName + "\nDeveloper 
Details: " + DeveloperDetails+ "\nTask Number: " + TaskNumber + "\nTask Duration: " + 
TaskDuration);
 }
}
