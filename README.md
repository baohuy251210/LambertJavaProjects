### File Input and Output
The program below use my .txt files as input and output files.
It will read 2 integers from the input and print out the larger integer to output until there's nothing left to read
```java
import java.io.*;
import java.util.*;
public class File {
        /**
         * @param args the command line arguments
         * @throws java.io.IOException
         */
        public static void main(String[] args) throws IOException {
                File input = new File("C:\\JavaText\\testin.txt");
                File output= new File("C:\\JavaText\\testou.txt");
                PrintWriter write = new PrintWriter(output);
                Scanner read = new Scanner(input);
                while (read.hasNext()){
                        int firstInt = read.nextInt();
                        int secInt = read.nextInt();
                        write.println(max(firstInt, secInt));
                }
                write.close();
        }
        static int max(int a, int b){
                return Math.max(a, b);
        }
        
}
```
##### Example Testcase:
###### testin.txt
```
3 4 
4 6
10 123
3 2
15 61
100 1000
```
###### testout.txt
```
4
6
123
3
61
1000
```
