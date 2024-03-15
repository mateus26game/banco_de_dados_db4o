package pacote_novo;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.Scanner;

public class Delete {

    public static void delete(ObjectContainer db, Scanner entrada) {


            System.out.println("==================================");
            System.out.println("Digite o nome a ser deletado");
            System.out.println("==================================");

        System.out.println("Digite o nome da pessoa a ser deletada: ");
        String nomeDelete = entrada.nextLine();

        deletarPessoa(db, nomeDelete);


    }

    public static void deletarPessoa(ObjectContainer db, String nome) {

        ObjectSet<Palavras> resultados = db.queryByExample(new Palavras(nome, null, null, null));


        while (resultados.hasNext()) {
            Palavras palavras = resultados.next();
            db.delete(palavras);

        }


        db.commit();
    }

}