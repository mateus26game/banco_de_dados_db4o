package pacote_novo;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class ExibirDados {

    public  static void exibirDados(ObjectContainer db){
        System.out.println("==================================================");
        System.out.println("Recuperando e exibindo dados do banco de dados:");
        System.out.println("==================================================");

    ObjectSet<Palavras> resultados = db.queryByExample(Palavras.class);

    while (resultados.hasNext()) {
            Palavras palavras = resultados.next();
            System.out.println("Nome: " + palavras.getNome());
            System.out.println("Idade: " + palavras.getIdade());
            System.out.println("curso: " + palavras.getCurso());
            System.out.println("Matricular: " + palavras.getMatricular());
            System.out.println("-------------------------------");
        }

    }


}
