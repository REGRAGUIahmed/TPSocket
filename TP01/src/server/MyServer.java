package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss =new ServerSocket(1234);
		System.out.println("J'attend la connexion ...");
		Socket sock = ss.accept();
		System.out.println("Connexion d'un client"+sock.getRemoteSocketAddress());
		//Recevoir une chaine de caractère 
		InputStream is = sock.getInputStream();//Octet par octet
		
		InputStreamReader isr = new InputStreamReader(is);//chaque 4 octet represente un caractère
		BufferedReader br = new BufferedReader(isr);// construire une chaine de caractère
		String s = br.readLine();// Stocker la chaine de caractère dans le variable s
		System.out.println("j'ai réçu la chaine de caractère: "+s);
		// Envoyer une chaine de caractére
		OutputStream os = sock.getOutputStream();
		PrintWriter pw = new PrintWriter(os,true);
		pw.println("Bonjour Mr "+s);
		/*
		System.out.println("J'attend que le client envoi un octet!");
		int nb = is.read();
		System.out.println("j'ai reçu un nombre: "+nb);
		int res = nb*5;
		System.out.println("J'envoi la réponse: "+res);
		os.write(res);*/
		sock.close();//fermer la connexion 
	}

}
