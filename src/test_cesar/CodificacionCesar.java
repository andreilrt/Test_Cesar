package test_cesar;

import static java.lang.System.exit;
import java.util.Scanner;

public class CodificacionCesar {

    private Scanner Input;
    private int Opc;
    private Mensaje ObjMensaje;

    public CodificacionCesar() {
        Input = new Scanner(System.in);
        Opc = 0;
        ObjMensaje = new Mensaje();
    }

    public int getOpc() {
        return Opc;
    }

    public void setOpc(int Opc) {
        this.Opc = Opc;
    }

    public void Menu() {
        System.out.println("\nIngrese la opcion que desee");
        System.out.println("Digite 1 si quiere codificar un mensaje con solo numeros");
        System.out.println("Digite 2 si quiere codificar un mensaje con solo caracteres");
        System.out.println("Digite 3 si quiere codificar un mensaje con numeros y caracteres");
        System.out.println("Digite 4 si quiere salir");
        System.out.println("RECUERDE QUE LA LONGITUD MAXIMA DE SU MENSAJE ES 7\n");
        this.setOpc(Input.nextInt());
    }

    public void Algoritmo() {
        char MensajeNuevo[] = this.ObjMensaje.getMensajeOriginal().toCharArray();
        if (this.getOpc() == 1) {
            for (int c = 0; c < this.ObjMensaje.getMensajeOriginal().length(); c++) {
                MensajeNuevo[c] = (char) ((int) this.ObjMensaje.getMensajeOriginal().charAt(c) + this.ObjMensaje.getClave());
                if (MensajeNuevo[c] > '9') {
                    MensajeNuevo[c] -= 10;
                }
            }
        }
        if (this.getOpc() == 2) {
            for (int c = 0; c < this.ObjMensaje.getMensajeOriginal().length(); c++) {
                MensajeNuevo[c] = (char) ((int) (this.ObjMensaje.getMensajeOriginal().charAt(c)) + this.ObjMensaje.getClave());
                if (MensajeNuevo[c] > 'z') {
                    MensajeNuevo[c] -= 26;
                }
            }
        }
        if (this.getOpc() == 3) {
            for (int c = 0; c < this.ObjMensaje.getMensajeOriginal().length(); c++) {
                MensajeNuevo[c] = (char) ((int) (this.ObjMensaje.getMensajeOriginal().charAt(c)) + this.ObjMensaje.getClave());
                if (MensajeNuevo[c] > '9' && MensajeNuevo[c] < 'a') {
                    MensajeNuevo[c] += 39;
                }
                if (MensajeNuevo[c] > 'z') {
                    MensajeNuevo[c] -= 75;
                }
            }
        }
        if (this.getOpc() == 4) {
            exit(0);
        }
        System.out.println("La codificacion Cesar de: " + this.ObjMensaje.getMensajeOriginal() + " es  -->  " + String.valueOf(MensajeNuevo));
    }

    public void Proceso() {
        boolean Control = true;
        System.out.println("Bienvenido al programa que realiza la codificación Cesar\n");
        while (Control) {
            this.Menu();
            this.ObjMensaje.IngresarMensaje(this.getOpc());
            this.ObjMensaje.IngresarClave(this.getOpc());
            this.Algoritmo();
        }
    }
}
