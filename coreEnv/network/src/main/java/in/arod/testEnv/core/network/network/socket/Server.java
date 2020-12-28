package in.arod.testEnv.core.network.network.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss=new ServerSocket(80);
        Socket s=ss.accept();//establishes connection
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());

        final String s2 = dis.readUTF();
        System.out.println(s2);
        final String s1 = "HTTP/1.1 200 OK\nServer: nginx\n" +
"Date: Wed, 25 Nov 2020 14:38:58 GMT\n" +
"Content-Type: text/html; charset=UTF-8\n" +
"Transfer-Encoding: chunked\n" +
"Connection: keep-alive\n" +
"Link: <http://in-fa.ru/wp-json/>; rel=\"https://api.w.org/\"\n" +
"Content-Encoding: gzip\n" +
"\n" +
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"ru-RU\" class=\"no-js\">\n" +
                    "\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\" />\n" +
                    "</head> <body> hello nicu </body></html>";
            dout.write(s1.getBytes("UTF-8"));
            dout.flush();
            s.close();
    }
}
