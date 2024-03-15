package pacote_novo;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.Scanner;

public class editar_tudo {

    public static void Editar_tudo(ObjectContainer db, Scanner entrada){

        System.out.println("Digite o nome do perfil que você deseja editar:");
        String nomePerfil = entrada.nextLine();

        System.out.println("=========================================================");
        System.out.println("Digitar o novo nome");
        System.out.println("=========================================================");
        String novoNome = entrada.nextLine();

        System.out.println("=========================================================");
        System.out.println("Digitar o novo curso");
        System.out.println("=========================================================");
        String novo_curso = entrada.nextLine();

        System.out.println("=========================================================");
        System.out.println("Digitar a novo matricular");
        System.out.println("=========================================================");
        String novo_matricular = entrada.nextLine();

        System.out.println("=========================================================");
        System.out.println("Digitar a novo idade");
        System.out.println("=========================================================");
        String novaIdade = entrada.nextLine();


        ObjectSet<Palavras> result = db.queryByExample(new Palavras(nomePerfil, null, null, null));

        if (result.hasNext()) {
            Palavras perfil = result.next();

            perfil.setNome(novoNome);

            perfil.setCurso(novo_curso);

            perfil.setMatricular(novo_matricular);

            perfil.setIdade(novaIdade);


            db.store(perfil);
            System.out.println("Perfil atualizado com sucesso.");

        } else {
            System.out.println("Perfil não encontrado no banco de dados.");
        }


    }

}
