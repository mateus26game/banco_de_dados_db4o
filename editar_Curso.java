package pacote_novo;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.Scanner;

public class editar_Curso {

    public static void Editar_Curso(ObjectContainer db, Scanner entrada){

        System.out.println("Digite o nome do perfil que você deseja editar:");
        String nomePerfil = entrada.nextLine();
        System.out.println("=========================================================");
        System.out.println("Digitar o nome do curso que vc que  ediat");
        System.out.println("=========================================================");
        String novo_curso = entrada.nextLine();


        ObjectSet<Palavras> result = db.queryByExample(new Palavras(nomePerfil, null, null, null));

        if (result.hasNext()) {
            Palavras perfil = result.next();


            perfil.setCurso(novo_curso);


            db.store(perfil);
            System.out.println("Perfil atualizado com sucesso.");

        } else {
            System.out.println("Perfil não encontrado no banco de dados.");
        }


    }

}
