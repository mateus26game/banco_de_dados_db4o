package pacote_novo;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

import java.util.Scanner;

import static pacote_novo.Delete.delete;

public class menu {

    public static void main(String[]args) {

        Scanner entrada = new Scanner(System.in);

        ObjectContainer db = Db4o.openFile("meubanco.dbon");

        int numero;


        do {
            System.out.println("====================================================");
            System.out.println("             Escolha uma das opções:");
            System.out.println("====================================================");
            System.out.println("1 - adicironar um nome ao banco de dados ");
            System.out.println("2 - Recuperando e exibindo dados do banco de dados:");
            System.out.println("3 - deletar uma pessoar do banco de dados:");
            System.out.println("4 - editar uma pessoar do banco de dados:");
            System.out.println("5 - sair do banco de dados");
            System.out.println("====================================================");
            System.out.print("Digite o número da opção desejada: ");

            numero = Integer.parseInt(entrada.nextLine());

            switch (numero) {
                case 1:
                    System.out.println("====================================================");

                        AdicoonarDados.adicoonarDados(db, entrada);
                    break;

                case 2:

                    ExibirDados.exibirDados(db);
                    break;

                case 3:

                    delete(db, entrada);
                    break;

                case 4:
                   menu_opcao_editar.Menu_pcao_editar(db,entrada);

                    break;
                case 5 :

                    System.out.println("===========================================");
                    System.out.println("vc saiu do banco de dados");
                    System.out.println("===========================================");
                    System.exit(0);
                default:
                    System.out.println("======================================");
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println("======================================");

            }


        } while (numero != 0);


    }

}
