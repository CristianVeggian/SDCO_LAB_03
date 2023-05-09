/**
 * Laboratorio 3  
 * Autores: Cristian Veggian e Bruno Keller
 * Ultima atualizacao: 09/05/2023
 */
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IMensagem extends Remote {
    
    public Mensagem enviar(Mensagem mensagem) throws RemoteException;
    
}