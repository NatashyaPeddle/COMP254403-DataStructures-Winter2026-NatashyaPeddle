import java.io.File;
import java.util.Scanner;

public class NATASHYAPEDDLE_LAB3_Exercise3 {

    /* Implement a recursive method with calling signature find(path, filename) that reports all entries of the file
     system rooted at the given path having the given file name. Test the method with a real path, filename from your
      file system. Hint: Review use of the java.io.File class and the week 5 examples.
     */

/// USE: find(path, filename)


    public static void find(File path, String filename){ ///  creates method find which takes file path and string filename


        /// if theres no path then it doesnt continue
    if(!path.exists()){
        return;
    }
    /// checking - lists the path it checks
    System.out.println("CHECKING: "+ path.getAbsolutePath());

    /// if file matches target file name show in log ------------------------------------------------------
    if(path.getName().equals(filename)){ ///
        System.out.println("-----------------------------------------------------------------------------------------");
     System.out.println("PATH FOUND: " + path.getAbsolutePath());
        System.out.println("-----------------------------------------------------------------------------------------");
    }else {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("CHECKED: **NO MATCH**: " + path.getAbsolutePath());
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    /// if path is directory search children -------------------------------------------------------------------------------
        if (path.isDirectory()){  /// checks if path is a directory

             String [] children = path.list(); ///lists names of files/subdirectories in current directory

           if (children != null){ /// checks if it has children / is null
               for (String childTitle : children){ /// loops through every child in directory

                   File child = new File(path, childTitle); ///  creates new file object for children file

                   find(child, filename); ///calls find and searches for the child file object

               }
           }
        }
    }



/// MAIN---------------------------------------------------------------------------------

    public static void main(String[] args) {


        /// sets filepath start
        String startPath = "B:\\CENTENNIAL_COLLEGE\\2026\\REPOSITORIES\\COMP254403-DataStructures-Winter2026-NatashyaPeddle\\NatashyaPeddle_COMP254_Lab1\\NATASHYAPEDDLE_COMP254_Lab3\\src\\Exercise3FileSearchTest";

        /// sets the target file to search for
        String targetFile = "Exercise3FileSearchTest1.txt";

        File root = new File(startPath); /// creates object for the  starting directory

        /// if the directory/root doesnt exist then it prints an error message
        if(!root.exists()){
            System.out.println("NO DIRECTORY FOUND");
            return;
        }

        find(root, targetFile); ///Calls "find" method to check "root" (which is the starting directory ) for the target file

    }
}
