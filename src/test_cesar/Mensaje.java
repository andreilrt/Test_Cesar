package test_cesar;

import java.util.Scanner;

public class Mensaje {

    private String MensajeOriginal;
    private int Clave;
    private Scanner Input;

    public Mensaje() {
        MensajeOriginal = " ";
        Clave = 0;
        Input = new Scanner(System.in);
    }

    public String getMensajeOriginal() {
        return MensajeOriginal;
    }

    public void setMensajeOriginal(String MensajeOriginal) {
        this.MensajeOriginal = MensajeOriginal;
    }

    public int getClave() {
        return Clave;
    }

    public void setClave(int Clave) {
        this.Clave = Clave;
    }

    public boolean VerificarMensaje(int Opc) {
        if (this.getMensajeOriginal().length() > 7) {
            System.out.print("Su mensaje no cumple con los requisitos, Intentelo nuevamente: ");
            return true;
        }
        if (Opc == 1) {
            for (int c = 0; c < this.getMensajeOriginal().length(); c++) {
                if (this.getMensajeOriginal().charAt(c) > '9' || this.getMensajeOriginal().charAt(c) < '0') {
                    System.out.print("Su mensaje no cumple con los requisitos, Intentelo nuevamente: ");
                    return true;
                }
            }
        }
        if (Opc == 2) {
            for (int c = 0; c < this.getMensajeOriginal().length(); c++) {
                if (this.getMensajeOriginal().charAt(c) > 'z' || this.getMensajeOriginal().charAt(c) < 'a') {
                    System.out.print("Su mensaje no cumple con los requisitos, Intentelo nuevamente: ");
                    return true;
                }
            }
        }
        if (Opc == 3) {
            for (int c = 0; c < this.getMensajeOriginal().length(); c++) {
                if ((this.getMensajeOriginal().charAt(c) > '9' || this.getMensajeOriginal().charAt(c) < '0') && (this.getMensajeOriginal().charAt(c) > 'z' || this.getMensajeOriginal().charAt(c) < 'a')) {
                    System.out.print("Su mensaje no cumple con los requisitos, Intentelo nuevamente: ");
                    return true;
                }
            }
        }
        return false;
    }

    public void IngresarMensaje(int Opc) {
        boolean Control = true;
        System.out.print("Por favor ingrese el mensaje que quiere cifrar: ");
        while (Control) {
            this.setMensajeOriginal(Input.next());
            Control = this.VerificarMensaje(Opc);
        }
    }

    public boolean VerificarClave(int Opc) {
        if (Opc == 1) {
            if (this.getClave() > 10) {
                System.out.print("Su clave no cumple con los requisitos, Intentelo nuevamente: ");
                return true;
            }
        }
        if (Opc == 2) {
            if (this.getClave() > 26) {
                System.out.print("Su clave no cumple con los requisitos, Intentelo nuevamente: ");
                return true;
            }
        }
        if (Opc == 3) {
            if (this.getClave() > 36) {
                System.out.print("Su clave no cumple con los requisitos, Intentelo nuevamente: ");
                return true;
            }
        }
        return false;
    }

    public void IngresarClave(int Opc) {
        boolean Control = true;
        System.out.print("Ingrese que clave quiere usar para su codificacion Cesar: ");
        while (Control) {
            this.setClave(Input.nextInt());
            Control = this.VerificarClave(Opc);
        }
    }
}
