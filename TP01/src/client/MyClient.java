package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) throws Exception {
		System.out.println("Je me connecte au serveur");
		Socket socket = new Socket("localhost",1234);
		
		OutputStream os = socket.getOutputStream();
		Scanner scanner = new Scanner (System.in);
		/* 
		 * saisir une chaine de caractère au clavier
		 */
		PrintWriter pw = new PrintWriter(os,true);
		System.out.println("Entrer votre nom");
				/*
				 * true : Envoyer la chaine directement 
				 * false : Stocker les chaines de caractère dans un Buffer
				 * puis les envoyer d'un seul coup à l'aide 
				 * pw.flush();
				 */
		
		
		String str = scanner.nextLine();
		pw.println(str);
		System.out.println("J'envoi la chaine "+str+" au serveur");
		System.out.println("J'attend la reponse de serveur!");
		
		// Recevoir une chaine de caractère
		InputStream is = socket.getInputStream();//Octet par octet
		InputStreamReader isr = new InputStreamReader(is);//chaque 4 octet represente un caractère
		BufferedReader br = new BufferedReader(isr);// construire une chaine de caractère
		String s = br.readLine();// Stocker la chaine de caractère dans le variable s
		
		System.out.println("la reponse de serveur est :"+s);
		/*
		 * Saisir un nombre au clavier
		 */
		/*
		System.out.println("Donner un nombre");
		int nb = scanner.nextInt();
		
		System.out.println("J'envoi le nombre "+nb+" au serveur");
		os.write(nb);
		System.out.println("J'attend la reponse de serveur!");
		int res = is.read();
		System.out.println("Response du serveur est: "+res);*/
		scanner.close();
		socket.close();
	}

}
