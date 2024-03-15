package pacote_novo;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import javax.swing.*;
import java.util.Scanner;

public class tela {
    public static void main(String[] args) {
        int choice;
        String[] options = {"Criar", "Ler", "Atualizar", "Excluir", "Sair"};
        ObjectContainer db = Db4o.openFile("meubanco.dbon");
        do {
            choice = JOptionPane.showOptionDialog(null, "Escolha as opções", "Saindo do programa",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Criar
                    createEntry(db);
                    break;
                case 1: // Ler
                    readEntry(db);
                    break;
                case 2: // Atualizar
                    updateEntry(db);
                    break;
                case 3: // Excluir
                    deleteEntry(db);
                    break;
                case 4: // Sair
                    JOptionPane.showMessageDialog(null, "Exiting CRUD Interface");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        } while (choice != 4);
    }

    private static void createEntry(ObjectContainer db) {

        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        String idade = JOptionPane.showInputDialog("Digite seu Idade:");
        String curso = JOptionPane.showInputDialog("Digite seu Curso:");
        String matricular = JOptionPane.showInputDialog("Digite seu Matricula:");
        Palavras Palavras = new Palavras(nome, idade, matricular, curso);
        db.store(Palavras);
        JOptionPane.showMessageDialog(null, "Adicionado : ");
    }

    private static void readEntry(ObjectContainer db) {

            ObjectSet<Palavras> resultados = db.queryByExample(Palavras.class);

            while (resultados.hasNext()) {
                Palavras palavras = resultados.next();
                JOptionPane.showMessageDialog(null,"Nome:"+palavras.getNome()+ " \nIdade: "+palavras.getIdade()+" \nMatricular: "+palavras.getCurso()+" \nCurso: "+palavras.getMatricular());
            }
    }

    private static void updateEntry(ObjectContainer db) {

        String nomePerfil = JOptionPane.showInputDialog(null,"Digite o nome do perfil que você deseja editar:");

        String novo_curso = JOptionPane.showInputDialog(null,"Digitar o nome do curso que vc que  editar");

        ObjectSet<Palavras> result = db.queryByExample(new Palavras(nomePerfil, null, null, null));

        if (result.hasNext()) {
            Palavras perfil = result.next();

            perfil.setCurso(novo_curso);

            db.store(perfil);

            JOptionPane.showMessageDialog(null,"Perfil atualizado com sucesso.");

        } else {

            JOptionPane.showMessageDialog(null,"Perfil não encontrado no banco de dados.");
            JOptionPane.showMessageDialog(null, "Atualizado : ");
        }

    }

    private static void deleteEntry(ObjectContainer db) {

        String nomeDelete = JOptionPane.showInputDialog("Digite o nome a ser deletado");

        deletarPessoa(db, nomeDelete);
        JOptionPane.showMessageDialog(null, "Usuario deletado : ");
    }

    private static void deletarPessoa(ObjectContainer db, String nome) {
        ObjectSet<Palavras> resultados = db.queryByExample(new Palavras(nome, null, null, null));


        while (resultados.hasNext()) {
            Palavras palavras = resultados.next();
            db.delete(palavras);

        }


        db.commit();
    }
}