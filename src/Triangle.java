import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1 - Triangle
 * Triangle
 * By starting at the top of the triangle and moving to adjacent 
 * numbers on the row below, the maximum total from top to bottom is 27.
        5
      9  6
    4   6  8
  0   7  1   5
 * I.e. 5 + 9 + 6 + 7 = 27.
 * Write a program in a language of your choice to find the maximum 
 * total from top to bottom in triangle.txt, a text file containing 
 * a triangle with 100 rows. Send your solution and resume to 
 * [123456 AT yodle dot com], replacing 123456 with the maximum 
 * sum for the triangle.
 * @author xiaonanwang
 *
 */
public class Triangle {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new FileReader("triangle.txt"));
    ArrayList<Integer> values = new ArrayList<Integer>();
    values.add(scanner.nextInt());
    int outer = 1;
    int result = Integer.MIN_VALUE;
    while(scanner.hasNext()){
      int inner = 0;
      ArrayList<Integer> tmp = new ArrayList<Integer>();
      while(scanner.hasNext() && inner <= outer){
        if (inner == 0 ){
          tmp.add(scanner.nextInt() + values.get(inner));
        } else if(inner == outer){
          tmp.add(scanner.nextInt() + values.get(inner - 1));
        } else {
          tmp.add(scanner.nextInt() + Math.max(values.get(inner - 1),values.get(inner)));
        }
        inner++;
      }
      values = tmp;
      outer++;
    }
    scanner.close();
    for(int i = 0 ; i < values.size();i++){
      if(result < values.get(i)){
        result = values.get(i);
      }
    }
    System.out.println(result);
  }
}
