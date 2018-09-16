// Fig. 17.3: FileDemonstration.java
// File class used to obtain file and directory information.

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileDemonstration2 {
    public static int totalSize = 0;
    public static File name;
    public static String path2;

    // public File name;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter file or directory name: ");
        analyzePath(input.nextLine());
    } // end main

    // display information about file user specifies
    public static void analyzePath(String path) {

        // create File object based on user input
        name = new File(path);
        path2 = path;


        if (name.exists()) // if name exists, output information about it
        {
            // display file (or directory) information

            if (name.isFile()) // Display file name and size
            {
                System.out.print("File: " + name.getName());
                System.out.println(" size = " + name.length());
                totalSize += name.length();
            }

            if (name.isDirectory()) // output directory listing
            {
                String[] directory = name.list();
                System.out.println("\n\nDirectory contents:\n");
                dirSize(directory); // call recursive method dirSize
   /*
            for ( String directoryName : directory )
               System.out.println( directoryName );
         } // end if
         */
            } // end outer if
            else // not file or directory, output error message
            {
                System.out.printf("%s %s", path, "does not exist.");
            } // end else

            System.out.println("Folder " + path + " size is " + totalSize);
        } // end method analyzePath

    } // end if

    public static void dirSize(String[] dir) {
        String str = path2;
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm a");

        for (String directoryName : dir) {
            //	String s = path2 + "\\";
            File dirName = new File(path2 + "\\" + directoryName);
            if (dirName.isFile()) {
                System.out.print(dateFormat.format(dirName.length()) + "\t\t");
                System.out.print(dirName.length() + "\t\t");
                System.out.println(dirName.getName());
                totalSize += dirName.length();

            }  // end of if
        } // end of for
    }   // end of method dirSize


} // end class FileDemonstration

/*************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/