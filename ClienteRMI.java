/**
 * Laboratorio 3  
 * Autores: Cristian Veggian e Bruno Keller
 * Ultima atualizacao: 09/05/2023
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void read(IMensagem stub) {
        Mensagem mensagem = new Mensagem("", "1");
        Mensagem resposta;
        try {
            resposta = stub.enviar(mensagem);
            System.out.println(resposta.getMensagem());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void write(String fortune, IMensagem stub) {
        Mensagem mensagem = new Mensagem(fortune, "2");
        try {
            Mensagem resposta = stub.enviar(mensagem);
            System.out.println(resposta.getMensagem());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1099);
            IMensagem stub = (IMensagem) registro.lookup("servidorFortunes");

            String opcao = "";
            Scanner leitura = new Scanner(System.in);

            do {
                System.out.println("\read");
                System.out.println("\write");
                System.out.println("\quit");
                System.out.print(">> ");
                opcao = leitura.next();
                switch (opcao) {
                    case "\read":
                        read(stub);
                        break;
                    case "\write":
                        System.out.print("Insira a sua fortuna: ");
                        String fortune = leitura.nextLine();
                        fortune = leitura.nextLine();
                        write(fortune, stub);
                        break;
                }
            } while (opcao != "\quit");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
