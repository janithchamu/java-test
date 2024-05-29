import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.IOException;


class Main {

    public static String[][] AddNewStudent(String ID_Name[][]){
        System.out.print("Enter Student ID   : " );
        Scanner input = new Scanner(System.in);
        String sId = input.nextLine();

        for(int i = 0 ; i<ID_Name.length; i++){
            if (ID_Name[i][0].equals(sId)) {
                System.out.println("The Student ID already exists");
                System.out.print("Enter Student ID   : " );
                sId = input.nextLine();
                i=0;
            }
        }
        String temp[][] = new String[ID_Name.length+1][4];
        for(int i =0 ; i<ID_Name.length;i++){
            temp[i]=ID_Name[i];
        }
        temp[temp.length-1][0]=sId;
        System.out.print("Enter Student Name : ");
        String sname = input.nextLine();
        temp[temp.length-1][1]=sname;
        ID_Name =temp;
        return ID_Name;
    }

    public static String[][] AddnewstudentwithMarks(String Details[][]){
        System.out.print("Enter Student ID   : " );
        Scanner input = new Scanner(System.in);
        String sId = input.nextLine();
        for(int i = 0 ; i<Details.length; i++){
            if (Details[i][0].equals(sId)) {
                System.out.println("The Student ID already exists\n");
                System.out.print("Enter Student ID   : " );
                sId = input.nextLine();
                i=0;
            }
        }
        String temp[][] = new String[Details.length+1][4];
        for(int i =0 ; i<Details.length;i++){
            temp[i]=Details[i];
        }
        temp[temp.length-1][0]=sId;

        System.out.print("Enter Student Name : ");
        String sname = input.nextLine();
        temp[temp.length-1][1]=sname;
        while ((true)) {
            System.out.print("\nProgramming Fundamental Marks    : ");
            int fmarks = input.nextInt();
            if((fmarks>0) &(fmarks<=100)) {
                temp[temp.length-1][2] = Integer.toString(fmarks);
                break;
            }
            else{
                System.out.println("Invalid Marks, Please Enter Valid Marks");
            }
        }
        while ((true)) {
            System.out.print("Database Mangment Systems Marks : ");
            int Dmarks = input.nextInt();
            if((Dmarks>0) &(Dmarks<=100)) {
                temp[temp.length - 1][3] = Integer.toString(Dmarks);
                break;
            }
            else{
                System.out.println("Invalid Marks, Please Enter Valid Marks\n");
            }
        }
        Details =temp;

        return Details;
    }

    public static String[][] AddMarks(String[][] Details){
        if(Details.length==0){
            System.out.println("No student records are Available");
            return Details;
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID   : " );
        String sId = input.nextLine();
        for(int i = 0 ; i<Details.length; i++){
            if (Details[i][0].equals(sId)) {
                System.out.println("Student Name       : "+Details[i][1]);
                if(Details[i][2]==null) {
                    while ((true)) {
                        System.out.print("\nProgramming Fundamental Marks    : ");
                        int fmarks = input.nextInt();
                        if ((fmarks > 0) & (fmarks <= 100)) {
                            Details[i][2] = Integer.toString(fmarks);
                            break;
                        } else {
                            System.out.println("Invalid Marks, Please Enter Valid Marks");
                        }
                    }
                    while ((true)) {
                        System.out.print("Database Managment Systems Marks : ");
                        int Dmarks = input.nextInt();
                        if ((Dmarks > 0) & (Dmarks <= 100)) {
                            Details[i][3] = Integer.toString(Dmarks);
                            break;
                        } else {
                            System.out.println("Invalid Marks, Please Enter Valid Marks\n");
                        }
                    }
                    System.out.println("Marks have been added.");
                }
                else {
                    System.out.println("This student's marks have been already added.\n" +
                            "If you want to update the marks, please use [5] Update marks option.");
                }
                break;
            }
            else if(i==(Details.length-1)) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
                char con = input.next().charAt(0);
                if(con=='n'){
                    break;
                }
                else{
                    Details=AddMarks(Details);
                }
            }
        }
        return Details;
    }

    public static String[][] UpdateStudentDetails(String[][] Details){
        if(Details.length==0){
            System.out.println("No student records are Available");
            return Details;
        }
        System.out.print("Enter Student ID   : " );
        Scanner input = new Scanner(System.in);
        String sId = input.nextLine();
        for(int i = 0 ; i<Details.length; i++){
            if (Details[i][0].equals(sId)) {
                System.out.println("Student Name       : "+Details[i][1]);
                System.out.print("Enter the student new name : ");
                Details[i][1]=input.nextLine();
                System.out.println("Student Details has been updated successfully");
                break;
            }
            else if(i==(Details.length-1)) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
                char con = input.next().charAt(0);
                if ((con=='n') || (con=='N')) {
                    break;
                }
                else{
                    Details=UpdateStudentDetails(Details);
                }
            }
        }
        return Details;
    }

    public static String[][] UpdateMarks(String Details[][]){
        if(Details.length==0){
            System.out.println("No student records are Available");
            return Details;
        }
        System.out.print("Enter Student ID   : " );
        Scanner input = new Scanner(System.in);
        String sId = input.nextLine();
        for(int i = 0 ; i<Details.length; i++){
            if (Details[i][0].equals(sId)) {
                System.out.println("Student Name       : "+Details[i][1]);
                if(Details[i][2]!=null) {
                    System.out.println("\nProgramming Fundamental Marks     : " + Details[i][2]);
                    System.out.println("Database Management System Marks  : " + Details[i][3]);
                    while ((true)) {
                        System.out.print("Enter new Programming Fundamental Marks     : ");
                        int fmarks = input.nextInt();
                        if((fmarks>0) &(fmarks<=100)) {
                            Details[i][2] = Integer.toString(fmarks);
                            break;
                        }
                        else{
                            System.out.println("Invalid Marks, Please Enter Valid Marks");
                        }
                    }
                    while ((true)) {
                        System.out.print("Enter new Database Management System Marks  : ");
                        int Dmarks = input.nextInt();
                        if((Dmarks>0) &(Dmarks<=100)) {
                            Details[i][3] = Integer.toString(Dmarks);
                            break;
                        }
                        else{
                            System.out.println("Invalid Marks, Please Enter Valid Marks");
                        }
                    }

                    System.out.println("Marks have been updated successfully");
                }
                else {
                    System.out.println("This student's marks yet to be added.");
                }
                break;
            }
            else if(i==Details.length-1)  {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
                char con = input.next().charAt(0);
                if ((con=='n') || (con=='N')) {
                    break;
                }
                else{
                    Details=UpdateMarks(Details);
                }
            }
        }
        return Details;
    }
    public static String[][] DeleteStudent(String Details[][]){
        if(Details.length==0){
            System.out.println("No student records are Available");
            return Details;
        }
        System.out.print("Enter Student ID   : " );
        Scanner input = new Scanner(System.in);
        String sId = input.nextLine();
        for(int i = 0 ; i<Details.length; i++){
            if (Details[i][0].equals(sId)) {
                String [][] temp = new String[Details.length-1][4];
                for(int j=0;j<i;j++){
                    temp[j]=Details[j];
                }
                for (int k=i+1;k<Details.length;k++){
                    temp[k-1]=Details[k];
                }
                Details=temp;
                System.out.println("Student has been Deleted successfully");
                break;
            }
            else if(i==(Details.length-1)) {
                System.out.print("Invalid Student ID, ");
            }
        }
        return Details;

    }
    public static String[][] PrintStudentDetails(String Details[][]){
        if(Details.length==0){
            System.out.println("No student records are Available");        /// if Details array is null, return just detail arrya
            return Details;
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID   : " );
        String sId = input.nextLine();
        for(int i = 0 ; i<Details.length; i++) {
            if (Details[i][0].equals(sId)) {
                if(Details[i][2]==null){
                    System.out.println("Marks yet to be added");
                    return Details;
                }
                break;
            }
            else if (i == (Details.length - 1)) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
                char con = input.next().charAt(0);
                if ((con=='n') || (con=='N')) {
                    break;
                } else {
                    Details = PrintStudentDetails(Details);
                    break;
                }
            }
        }
        String AllDetails[][]=new String[0][6];         // create array for fillter out the marks include student details from Details array, This allDetails arrya is also 2D array and 1D arrya size is 6,
        for(int i=0;i<Details.length;i++){
            if(Details[i][2]!=null){
                String [][]temp = new String[AllDetails.length+1][6];                        // get marks added student details from DEtails arrya and assign to Alldetails array
                for(int l=0;l<AllDetails.length;l++){
                    temp[l]=AllDetails[l];
                }
                temp[temp.length-1]=Details[i];
                AllDetails=temp;
            }
        }
        if(AllDetails.length==0){
            System.out.println("No student records are availabel with marks");
            return Details;
        }
        String [][] CalDetails=new String[AllDetails.length][6];
        for(int i=0 ; i<AllDetails.length;i++){
            int total = Integer.valueOf(AllDetails[i][2])+Integer.valueOf(AllDetails[i][3]);
            Double average = (total)/2.0;
            CalDetails[i][0]=AllDetails[i][0];
            CalDetails[i][1]=AllDetails[i][1];
            CalDetails[i][2]=AllDetails[i][2];
            CalDetails[i][3]=AllDetails[i][3];
            CalDetails[i][4]=Integer.toString(total);                             // while iterate through Alldetails Array calculate avg and total for each student and assign in to 1D array last two position
            CalDetails[i][5]=Double.toString(average);
        }
        String [][] Ranklist = new String[0][6];
        String [][] temp = CalDetails;
        int loops=0;
        while (true) {
            double max = Double.parseDouble(temp[0][5]);
            int maxIndex = 0;
            for (int i = 0; i < temp.length; i++) {
                if(max<Double.parseDouble(temp[i][5])){
                    max=Double.parseDouble(temp[i][5]);
                    maxIndex=i;
                }
            }
            String temp2[][] = new String[Ranklist.length+1][6];
            for(int i =0 ; i<Ranklist.length;i++){
                temp2[i]=Ranklist[i];
            }
            temp2[temp2.length-1]=temp[maxIndex];
            Ranklist=temp2;

            String [][] temp3 = new String[temp.length-1][6];
            for(int j=0;j<maxIndex;j++){
                temp3[j]=temp[j];
            }
            for (int k=maxIndex+1;k<temp.length;k++){
                temp3[k-1]=temp[k];
            }
            temp=temp3;
            loops+=1;
            if(loops==AllDetails.length){
                break;
            }

        }

        for(int i = 0 ; i<Ranklist.length; i++){
            if (Ranklist[i][0].equals(sId)) {
                System.out.println("Student Name       : "+Ranklist[i][1]);
                if(Ranklist[i][2]==null) {
                    // System.out.println("Marks yet to be added");
                }
                else {
                    System.out.println("+----------------------------------+------------+");
                    System.out.println("|Programming Fundamental Marks     |          "+Ranklist[i][2]+"|");
                    System.out.println("|Database Management Systems Marks |          "+Ranklist[i][3]+"|");
                    System.out.println("|Total Marks                       |         "+Ranklist[i][4]+"|");
                    System.out.println("|Avg. Marks                        |        "+Ranklist[i][5]+"|");
                    if(i==0){
                        System.out.println("|Rank                              |    1(First)|");
                    }
                    else if (i==1) {
                        System.out.println("|Rank                              |   2(Second)|");
                    }
                    else if(i==2){
                        System.out.println("|Rank                              |    3(Third)|");
                    }
                    else if(i==Ranklist.length-1){
                        System.out.println("|Rank                              |     "+(Ranklist.length)+"(Last)|");
                    }
                    else{
                        System.out.println("|Rank                              |           "+(i+1)+"|");
                    }
                    System.out.println("+----------------------------------+------------+");
                }
                break;
            }
            else if(i==((Ranklist.length)-1)) {
                System.out.print("Marks yet to be added, ");
                break;
            }
        }
        return Details;
    }
    public static String[][] PrintStudentsRank(String Details[][]){
        if(Details.length==0){
            System.out.println("No student records are Available");        /// if Details array is null, return just detail arrya
            return Details;
        }
        String AllDetails[][]=new String[0][6];         // create array for fillter out the marks include student details from Details array, This allDetails arrya is also 2D array and 1D arrya size is 6,
        for(int i=0;i<Details.length;i++){
            if(Details[i][2]!=null){
                String [][]temp = new String[AllDetails.length+1][6];                        // get marks added student details from DEtails arrya and assign to Alldetails array
                for(int l=0;l<AllDetails.length;l++){
                    temp[l]=AllDetails[l];
                }
                temp[temp.length-1]=Details[i];
                AllDetails=temp;
            }
        }
        if(AllDetails.length==0){
            System.out.println("No student records are availabel with marks");
            return Details;
        }
        String [][] CalDetails=new String[AllDetails.length][6];
        for(int i=0 ; i<AllDetails.length;i++){
            int total = Integer.valueOf(AllDetails[i][2])+Integer.valueOf(AllDetails[i][3]);
            Double average = (total)/2.0;
            CalDetails[i][0]=AllDetails[i][0];
            CalDetails[i][1]=AllDetails[i][1];
            CalDetails[i][2]=AllDetails[i][2];
            CalDetails[i][3]=AllDetails[i][3];
            CalDetails[i][4]=Integer.toString(total);                             // while iterate through Alldetails Array calculate avg and total for each student and assign in to 1D array last two position
            CalDetails[i][5]=Double.toString(average);
        }
        String [][] Ranklist = new String[0][6];
        String [][] temp = CalDetails;
        int loops=0;
        while (true) {
            double max = Double.parseDouble(temp[0][5]);
            int maxIndex = 0;
            for (int i = 0; i < temp.length; i++) {
                if(max<Double.parseDouble(temp[i][5])){
                    max=Double.parseDouble(temp[i][5]);
                    maxIndex=i;
                }
            }
            String temp2[][] = new String[Ranklist.length+1][6];
            for(int i =0 ; i<Ranklist.length;i++){
                temp2[i]=Ranklist[i];
            }
            temp2[temp2.length-1]=temp[maxIndex];
            Ranklist=temp2;

            String [][] temp3 = new String[temp.length-1][6];
            for(int j=0;j<maxIndex;j++){
                temp3[j]=temp[j];
            }
            for (int k=maxIndex+1;k<temp.length;k++){
                temp3[k-1]=temp[k];
            }
            temp=temp3;
            loops+=1;
            if(loops==AllDetails.length){
                break;
            }
        }
        System.out.println("+------+-----+--------------+------------+-----------+");
        System.out.println("|Rank  |ID   |Name          |Total Marks |Avg. Marks |");
        System.out.println("+------+-----+--------------+------------+-----------+");
        for(int i =0 ; i<Ranklist.length;i++){
            int namelength = Ranklist[i][1].length();
            int remain = 14-namelength;
            System.out.print("|"+(i+1)+"     |"+Ranklist[i][0]+ " |");
            System.out.print(Ranklist[i][1]);          // "        \t|       \t"+Ranklist[i][4]+ "|     \t"+Ranklist[i][5]+ "|");
            for(int k=0;k<remain;k++){
                System.out.print(" ");
            }
            int totallength=Ranklist[i][4].length();
            int remaintotal= 12-totallength;
            System.out.print("|");
            for(int k=0;k<remaintotal;k++){
                System.out.print(" ");
            }
            System.out.println(Ranklist[i][4]+ "|   \t"+Ranklist[i][5]+ "|");
        }

        System.out.println("+------+-----+--------------+------------+-----------+");
        return Details;
    }
    public  static String[][] BestProgrammingFundamental(String [][] Details){
        if(Details.length==0){
            System.out.println("No student records are Available");        /// if Details array is null, return just detail arrya
            return Details;
        }
        String AllDetails[][]=new String[0][4];         // create array for fillter out the marks include student details from Details array, This allDetails arrya is also 2D array and 1D arrya size is 6,
        for(int i=0;i<Details.length;i++){
            if(Details[i][2]!=null){
                String [][]temp = new String[AllDetails.length+1][6];                        // get marks added student details from DEtails arrya and assign to Alldetails array
                for(int l=0;l<AllDetails.length;l++){
                    temp[l]=AllDetails[l];
                }
                temp[temp.length-1]=Details[i];
                AllDetails=temp;
            }
        }
        if(AllDetails.length==0){
            System.out.println("No student records are availabel with marks");
            return Details;
        }
        String [][] Ranklist = new String[0][4];
        String [][] temp = AllDetails;
        int loops=0;
        while (true) {
            int max = Integer.parseInt(temp[0][2]);
            int maxIndex = 0;
            for (int i = 0; i < temp.length; i++) {
                if(max<Integer.parseInt(temp[i][2])){
                    max=Integer.parseInt(temp[i][2]);
                    maxIndex=i;
                }
            }
            String temp2[][] = new String[Ranklist.length+1][4];
            for(int i =0 ; i<Ranklist.length;i++){
                temp2[i]=Ranklist[i];
            }
            temp2[temp2.length-1]=temp[maxIndex];
            Ranklist=temp2;

            String [][] temp3 = new String[temp.length-1][4];
            for(int j=0;j<maxIndex;j++){
                temp3[j]=temp[j];
            }
            for (int k=maxIndex+1;k<temp.length;k++){
                temp3[k-1]=temp[k];
            }
            temp=temp3;
            loops+=1;
            if(loops==AllDetails.length){
                break;
            }
        }
        System.out.println("+-----+--------------+------------+-----------+");
        System.out.println("|ID   |Name          |PF Marks    |DBMS Marks |");
        System.out.println("+-----+--------------+------------+-----------+");
        for(int i =0 ; i<Ranklist.length;i++){
            int namelength = Ranklist[i][1].length();
            int remain = 14-namelength;
            System.out.print("|"+Ranklist[i][0]+ " |" ); //+Ranklist[i][1]+ "        \t|       \t"+Ranklist[i][2]+ "|     \t"+Ranklist[i][3]+ "|");
            System.out.print(Ranklist[i][1]);
            for(int k=0;k<remain;k++){
                System.out.print(" ");
            }
            System.out.println("|       \t"+Ranklist[i][2]+ "|     \t"+Ranklist[i][3]+ "|");

        }
        System.out.println("+-----+--------------+------------+-----------+");
        return Details;
    }
    public static String[][] BestDataBaseManagmentSystmes(String [][] Details){
        if(Details.length==0){
            System.out.println("No student records are Available");        /// if Details array is null, return just detail arrya
            return Details;
        }
        String AllDetails[][]=new String[0][4];         // create array for fillter out the marks include student details from Details array, This allDetails arrya is also 2D array and 1D arrya size is 6,
        for(int i=0;i<Details.length;i++){
            if(Details[i][2]!=null){
                String [][]temp = new String[AllDetails.length+1][6];                        // get marks added student details from DEtails arrya and assign to Alldetails array
                for(int l=0;l<AllDetails.length;l++){
                    temp[l]=AllDetails[l];
                }
                temp[temp.length-1]=Details[i];
                AllDetails=temp;
            }
        }
        if(AllDetails.length==0){
            System.out.println("No student records are availabel with marks");
            return Details;
        }
        String [][] Ranklist = new String[0][4];
        String [][] temp = AllDetails;
        int loops=0;
        while (true) {
            int max = Integer.parseInt(temp[0][3]);
            int maxIndex = 0;
            for (int i = 0; i < temp.length; i++) {
                if(max<Integer.parseInt(temp[i][3])){
                    max=Integer.parseInt(temp[i][3]);
                    maxIndex=i;
                }
            }
            String temp2[][] = new String[Ranklist.length+1][4];
            for(int i =0 ; i<Ranklist.length;i++){
                temp2[i]=Ranklist[i];
            }
            temp2[temp2.length-1]=temp[maxIndex];
            Ranklist=temp2;

            String [][] temp3 = new String[temp.length-1][4];
            for(int j=0;j<maxIndex;j++){
                temp3[j]=temp[j];
            }
            for (int k=maxIndex+1;k<temp.length;k++){
                temp3[k-1]=temp[k];
            }
            temp=temp3;
            loops+=1;
            if(loops==AllDetails.length){
                break;
            }
        }
        System.out.println("+-----+--------------+------------+-----------+");
        System.out.println("|ID   |Name          |DBMS Marks  |PF Marks   |");
        System.out.println("+-----+--------------+------------+-----------+");
        for(int i =0 ; i<Ranklist.length;i++){
            int namelength = Ranklist[i][1].length();
            int remain = 14-namelength;
            System.out.print("|"+Ranklist[i][0]+ " |" ); //+Ranklist[i][1]+ "        \t|       \t"+Ranklist[i][2]+ "|     \t"+Ranklist[i][3]+ "|");
            System.out.print(Ranklist[i][1]);
            for(int k=0;k<remain;k++){
                System.out.print(" ");
            }
            System.out.println("|       \t"+Ranklist[i][3]+ "|     \t"+Ranklist[i][2]+ "|");

        }
        System.out.println("+-----+--------------+------------+-----------+");
        return Details;
    }


    public static  void Mainwindow(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                     WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                        |");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("[1] Add New Student                         [2] Add New Student With Marks");
        System.out.println("[3] Add Marks                               [4] Update Student Details");
        System.out.println("[5] Update Marks                            [6] Delete Student");
        System.out.println("[7] Print Student Details                   [8] Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamentals        [10] Best in Database Management System");
    }

    public static int userinput(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter an option to continue > ");

        String uI =input.next();
        try{
            int UIV= Integer.parseInt(uI);
            return UIV;
        }catch (Exception e){

        }
        return 0;
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (final Exception e) {
            e.printStackTrace(); //Handle any exceptions.
        }
    }

    public static void main(String[] args) {

        String [][] Details = new String[0][4];
        Scanner input = new Scanner(System.in);
        while (true){

            Mainwindow();
            int UI=userinput();
            clearConsole();
            if(UI==1){

                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                               ADD NEW STUDENT                                      |");
                System.out.println("-------------------------------------------------------------------------------------");
                while(true) {
                    Details=AddNewStudent(Details);
                    System.out.print("Student has been added successfuly. Do you want to add a new student (Y/n) : ");
                    char con = input.next().charAt(0);
                    if((con=='n') || (con=='N')){
                        break;
                    }
                }
                clearConsole();
            }
            else if (UI==2){
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                          ADD NEW STUDENT WITH MARKS                                |");
                System.out.println("-------------------------------------------------------------------------------------");
                while(true) {
                    Details=AddnewstudentwithMarks(Details);
                    System.out.print("Student has been added successfuly. Do you want to add a new student (Y/n) : ");
                    char con = input.next().charAt(0);
                    if((con=='n') || (con=='N')){
                        break;
                    }
                }
                clearConsole();
            }
            else if (UI==3) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                                  ADD MARKS                                         |");
                System.out.println("-------------------------------------------------------------------------------------");
                while (true) {
                    Details = AddMarks(Details);
                    if(Details.length==0){
                        break;
                    }
                    else {
                        System.out.print("Do you want to add marks for another student (Y/n) : ");
                        char con = input.next().charAt(0);
                        if ((con=='n') || (con=='N')) {
                            break;
                        }
                    }
                }
                clearConsole();
            }
            else if (UI==4) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                          UPDATE STUDENT DETAILS                                    |");
                System.out.println("-------------------------------------------------------------------------------------");
                while (true) {
                    Details = UpdateStudentDetails(Details);
                    if(Details.length==0){
                        break;
                    }
                    else {
                        System.out.print("Do you want to Update another student details (Y/n) : ");
                        char con = input.next().charAt(0);
                        if ((con=='n') || (con=='N')) {
                            break;
                        }
                    }
                }
                clearConsole();
            }
            else if (UI==5) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                          UPDATE STUDENT MARKS                                    |");
                System.out.println("-------------------------------------------------------------------------------------");
                while (true) {
                    Details = UpdateMarks(Details);
                    if(Details.length==0){
                        break;
                    }
                    else {
                        System.out.print("Do you want to Update marks of another student (Y/n) : ");
                        char con = input.next().charAt(0);
                        if ((con=='n') || (con=='N')) {
                            break;
                        }
                    }
                }
                clearConsole();
            }
            else if (UI==6) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                                  DELETE STUDENT                                    |");
                System.out.println("-------------------------------------------------------------------------------------");
                while (true) {
                    Details = DeleteStudent(Details);
                    if(Details.length==0){
                        break;
                    }
                    else {
                        System.out.print("Do you want to Delete another student (Y/n) : ");
                        char con = input.next().charAt(0);
                        if ((con=='n') || (con=='N')) {
                            break;
                        }
                    }
                }
                clearConsole();

            }
            else if (UI==7) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                                PRINT STUDENT DETAILS                               |");
                System.out.println("-------------------------------------------------------------------------------------");
                while (true) {
                    Details = PrintStudentDetails(Details);
                    if(Details.length==0){
                        break;
                    }
                    else {
                        System.out.print("Do you want to Search another student Details (Y/n) : ");
                        char con = input.next().charAt(0);
                        if ((con=='n') || (con=='N')) {
                            break;
                        }
                    }
                }
                clearConsole();
            }
            else if (UI==8) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                                PRINT STUDENTS' RANK                                |");
                System.out.println("-------------------------------------------------------------------------------------");
                while (true) {
                    Details = PrintStudentsRank(Details);
                    if(Details.length==0){
                        break;
                    }
                    else {
                        System.out.print("Do you want to go back to main menu? (Y/n) : ");
                        char con = input.next().charAt(0);
                        if ((con == 'Y') ||(con=='y')) {
                            break;
                        }
                    }
                }
                clearConsole();
            }
            else if (UI==9) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                         BEST IN PROGRAMMING FUNDAMENTAL                            |");
                System.out.println("-------------------------------------------------------------------------------------");
                while (true) {
                    Details = BestProgrammingFundamental(Details);
                    if(Details.length==0){
                        break;
                    }
                    else {
                        System.out.print("Do you want to go back to main menu? (y/n) : ");
                        char con = input.next().charAt(0);
                        if ((con == 'Y') ||(con=='y')) {
                            break;
                        }
                    }
                }
                clearConsole();
            }
            else if (UI==10) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("|                         BEST IN DATABASE MANAGMENET SYSTMES                        |");
                System.out.println("-------------------------------------------------------------------------------------");
                while (true) {
                    Details = BestDataBaseManagmentSystmes(Details);
                    if(Details.length==0){
                        break;
                    }
                    else {
                        System.out.print("Do you want to go back to main menu? (y/n) : ");
                        char con = input.next().charAt(0);
                        if ((con == 'Y') ||(con=='y')){
                            break;
                        }
                    }
                }
                clearConsole();

            }
            else if (UI==0) {
                System.out.println("Invalid input type, Please enter number between 1-10");
            }
            else {
                System.out.println("Invalid input type, Please enter number between 1-10");
            }

        }
    }
}
