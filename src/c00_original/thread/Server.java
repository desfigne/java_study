package thread;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 12345;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("📡 서버 실행 중... (포트: " + PORT + ")");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // 클라이언트 접속 대기
                System.out.println("✅ 클라이언트 연결됨: " + clientSocket.getInetAddress());

                // 클라이언트마다 별도 쓰레드로 처리
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    
    public ClientHandler(Socket socket) {
        this.socket = socket;
        System.out.println("ClientHandler 생성!!");
    }

    public void run() {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("서버에 연결되었습니다. 메시지를 입력하세요!");

        } catch (IOException e) {
            System.out.println("❌ 클라이언트 연결 종료");
        } finally {
            try { socket.close(); } catch (IOException ignored) {}
        }
    }
}
