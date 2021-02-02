public class Main{
  public static void main(String[] agrs){
    Interpret interpreter = new Interpret(">++++++++[<+++++++++>-]<.>++++[<+++++++>-]<+.+++++++..+++.>>++++++[<+++++++>-]<++.------------.>++++++[<+++++++++>-]<+.<.+++.------.--------.>>>++++[<++++++++>-]<+.");
    interpreter.traverse();
    System.out.println();
  }
}
