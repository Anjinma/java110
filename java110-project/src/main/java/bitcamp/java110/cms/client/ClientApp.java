package bitcamp.java110.cms.client;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try (//autocloseable 구현한것만 올 수 있다.
                //서버 연결하기
                Socket socket = new Socket("localhost",8888);

                //서버에 데이터를 보내고/읽을 도구를 준비하기
                //통째로 리턴  outputStream
                //Decorator!!  한줄씩 리턴할 수 있는 데코!!  PrintStream
                PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

                //byte스트림을 char스트림으로 해주는 inputStreamReader
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ){
            out.println("HELLO");  out.flush();
            System.out.println(in.readLine());
            
            while (true) {
                String requestLine = prompt();
                out.println(requestLine);  out.flush();//서버에게 보내는 것.

                while(true) {
                    String responseLine = in.readLine() ;
                    System.out.println(responseLine);
                    if(responseLine.length()==0)
                        break;
                }
                if (requestLine.equals("EXIT")){
                    break;
                } 
            }
        }
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("입력> ");
        return keyIn.nextLine();
    }
}






















