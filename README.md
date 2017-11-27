## Welcome to my codes library!!
-
### File Input and Output
The program below use my .txt files as input and output files.
It will read 2 integers from the input and print out the larger integer to output until there's nothing left to read.
```
throws IOException
```
is included because the file will not read from standard output of the program.
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
#### Example Testcase:
##### Test 1
testin.txt
```
3 4 
4 6
10 123
3 2
15 61
100 1000
```
testout.txt
```
4
6
123
3
61
1000
```
---
---
## Decimal to Hexadecimal 
Using .txt files as input and output. This program change the value from Decimal base to Hexadecimal base 

```java
import java.util.*;
import java.io.*;
public class DectoHex {

        /**
         * @param args the command line arguments
         * @throws java.io.IOException
         */
        public static void main(String[] args) throws IOException {
                File input = new File("C:\\JavaText\\testin.txt");
                File output = new File("C:\\JavaText\\testou.txt");
                Scanner read = new Scanner(input);
                PrintWriter cout = new PrintWriter(output);     
                 
                int dec = read.nextInt();
                String locate = "0123456789ABCDEF";
                String res = "";
                while (dec > 0){
                        res = locate.charAt(dec%16) + res;
                        dec /= 16;
                }
                cout.print(res);
                cout.close();
        }
        
}
```
#### Example testcases:
##### Test 1:
testin.txt
```
8
```
testout.txt
```
8
```
##### Test 2:
testin.txt
```
110
```
testout.txt
```
6E
```
