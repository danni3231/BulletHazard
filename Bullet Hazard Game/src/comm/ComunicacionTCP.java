package comm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ComunicacionTCP extends Thread{

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private OnMessageListener observer;
    private boolean conectado;

    public void run() {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Esperando...");
            this.conectado=false;
            this.socket = server.accept();
            System.out.println("Aceptado!");
            this.conectado=true;

            //Reader
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            this.reader = new BufferedReader(isr);

            //Writer
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            this.writer = new BufferedWriter(osw);

            while(true) {
                recibirMensaje();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Solicitar conexion
    public void esperarConexion(OnMessageListener observer){
        this.observer=observer;
        this.start();
    }

    //Mandar un mensaje
    public void mandarMensaje(String mensaje){
        new Thread(
                ()->{
                    try {
                        writer.write(mensaje+"\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    //Recibir mensaje
    public void recibirMensaje() throws IOException{
        String line = reader.readLine();
        observer.onMessage(line);
    }

    public void cerrarConexion(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isConectado() {
        return conectado;
    }
}