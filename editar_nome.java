package pacote_novo;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.Scanner;

public class editar_nome {

    public static void Editar_nome(ObjectContainer db, Scanner entrada) {
        System.out.println("Digite o nome do perfil que você deseja editar:");
        String nomePerfil = entrada.nextLine();


        ObjectSet<Palavras> result = db.queryByExample(new Palavras(nomePerfil, null, null, null));
        if (result.hasNext()) {
            Palavras perfil = result.next();

            System.out.println("Novo nome para o perfil:");
            String novoNome = entrada.nextLine();

            perfil.setNome(novoNome);


            db.store(perfil);
            System.out.println("Perfil atualizado com sucesso.");
        } else {
            System.out.println("Perfil não encontrado no banco de dados.");
        }
    }
}
