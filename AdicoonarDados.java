package pacote_novo;

import java.util.Scanner;

import com.db4o.ObjectContainer;
public class AdicoonarDados {
        public static void adicoonarDados(ObjectContainer db, Scanner entrada) {

                //String nomedelete = entrada.nextLine();


                System.out.println("escrevar um nome para ser add no banco de dados");
                System.out.println("====================================================");

                String nome = entrada.nextLine();


                System.out.println("====================================================");
                System.out.println("escreve a idade dessa pessoa");
                System.out.println("====================================================");
                String idade = entrada.nextLine();


                System.out.println("======================================================");
                System.out.println("escrevar o numero de matricular dessa pessoa");
                System.out.println("======================================================");
                String matricular = entrada.nextLine();


                System.out.println("=======================================================");
                System.out.println("escreva o nome do curso dessa pessoa");
                System.out.println("=======================================================");
                String curso = entrada.nextLine();

                System.out.println("parabem esse perfiu entrou no banco de dados");



                Palavras palavras = new Palavras(nome, idade, matricular, curso);
                db.store(palavras);


        }
}


