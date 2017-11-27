/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filé;

/**
 *
 * @author baohuy251210
 */
import java.io.*;
import java.util.*;
public class Filé {
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
