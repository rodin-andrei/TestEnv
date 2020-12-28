package in.arod.testEnv.core.network.network.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Programm {
    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket();
        socket.bind(new InetSocketAddress("127.0.0.17", 22222));
        socket.connect(new InetSocketAddress("127.0.0.1", 40000));
        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final OutputStream outputStream = socket.getOutputStream();
        for (int i = 0; i < 1; i++) {
            final byte[] ints = {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x1c, (byte) 0x00, (byte) 0x00,
                    (byte) 0x00, (byte) 0x02, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                    (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x36,
                    (byte) 0x39, (byte) 0x32, (byte) 0x39, (byte) 0x38, (byte) 0x37, (byte) 0x35, (byte) 0x31,
                    (byte) 0x00
            };

            outputStream.write(ints);
            outputStream.flush();
        }

//        new Thread(() -> {
//            try {
//                final int read = in.read();
//                System.out.println("Read " + read);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
