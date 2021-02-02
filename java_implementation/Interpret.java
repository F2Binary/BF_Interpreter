import java.util.Scanner;
public class Interpret{
  public byte[] tape;
  public int pointer;
  public char[] expression;
  Scanner scan;
  
  public Interpret(String expression){
    this.expression = expression.toCharArray();
    //Brainf*ck max memory 
    tape = new byte[30000];
    scan = new Scanner(System.in);
  }
  
  public void traverse(){
    //We will use this to manage unmatched brackets
    int bracketChecker = 0;
    for(int i = 0; i<expression.length;i++){
      //Match each character in expression with one of Brainf*ck's valid chars
      //Otherwise we can ignore it (ke we don't care about whitespace or any unknown chars.)
      switch(expression[i]){
      case '+':
        tape[pointer]++;
        break;
      case '-':
        tape[pointer]--;
        break;
      case '>':
        pointer++;
        break;
      case '<':
        pointer--;
        break;
      case '.':
        char temp = (char)tape[pointer];
        System.out.print(temp);
        break;
      case ',':
        System.out.println("Enter your character: ");
        tape[pointer] = (byte) scan.next().charAt(0);
        break;
      //Can use a stack to keep track of umatched brackets and test if provided
      //expression is valid. Otherwise this handles valid expressions.
      case '[':
        if(tape[pointer]==0){
          bracketChecker++;
          while(expression[i] != ']' || bracketChecker!= 0){
            i++;
            if(expression[i] == '['){
              bracketChecker++;
            }
            else if(expression[i] == ']'){
              bracketChecker--;
            }
        }
      }
      break;
      case ']':
        if(tape[pointer]!=0){
          bracketChecker++;
          while(expression[i] != '['|| bracketChecker != 0){
            i--;
            if(expression[i] == ']'){
              bracketChecker++;
            }
            else if(expression[i] == '['){
              bracketChecker--;
            }
        }
      }
      break;
    }
  }

  }
}
