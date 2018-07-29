package bingo.enhance.multithread.chapter4.SimpleHttpServer;

import bingo.enhance.multithread.chapter4.ThreadPool.DefaultThreadPool;
import bingo.enhance.multithread.chapter4.ThreadPool.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于线程池技术的HttpServer
 * Created by RedRain on 2018/7/29.
 */
public class SimpleHttpServer {
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<HttpRequestHandler>(1);
    static ServerSocket serverSocket;
    static String basePath = "F:\\pic";
    static int port = 8080;

    public static void main(String[] args) throws IOException {
        SimpleHttpServer.start();
    }

    private static void setBasePath(String basePath){
        if(basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()){
            SimpleHttpServer.basePath = basePath;
        }
    }

    private static void setPort(int port){
        if(port > 0){
            SimpleHttpServer.port = port;
        }
    }

    // 服务器启动方法
    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        if((socket = serverSocket.accept())!=null){
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close(); // ?
    }

    // 请求处理类
    static class HttpRequestHandler implements Runnable{
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                String filePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                if(filePath.endsWith("jpg") || filePath.endsWith("ico")){
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    if((i = in.read()) != -1){
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.print("HTTP/1.1 200 OK");
                    out.print("Server: Molly");
                    out.print("Content-Type: image/jpeg");
                    out.print("Content-Length: " + array.length);
                    out.print("");
                    socket.getOutputStream().write(array,0,array.length);
                }
                out.flush();
            }catch (Exception e){
                out.print("HTTP/1.1 500");
                out.print("");
                out.flush();
            }finally {
                close(br,in,reader,out,socket);
            }

        }
    }

    /**
     * 关闭流
     * @param closeables
     */
    private static void close(Closeable... closeables){
        if(closeables != null){
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
