import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       // inicialização dos dados da conta
        String nome = "Augusto da Silva Ferreira";
        String tipoConta = "Corrente";
        double saldo = 1500.00;
        boolean loop = false;

        while (!loop) {
            System.out.println("\n**********************************************************");
            System.out.println("\nNome:               " + nome);
            System.out.println("Tipo conta:         " + tipoConta);
            System.out.println("Saldo:              " + saldo);
            System.out.println("\n**********************************************************");

            System.out.println("\n OPERAÇÕES");
            System.out.println("""
                    1- Consultar Saldo
                    2- deposito de valor
                    3- Transferir Valor
                    4- Sair
                                    
                    Digite a opção desejada: """);
            Scanner teclado = new Scanner(System.in);

            // confrima se o valor digitado é valido
            if (teclado.hasNextInt()) {
                int escolha = teclado.nextInt();
                //caso a escolha seja 1, mostra o saldo
                if (escolha == 1) {

                    System.out.println("Saldo Atual: R$" + saldo);

                  // caso seja 2, começa processo de deposito
                } else if (escolha == 2) {

                    System.out.print("Digite o valor do depósito: R$");

                    if (teclado.hasNextDouble()) {

                        double valorDeposito = teclado.nextDouble();
                        saldo += valorDeposito;
                        System.out.println(String.format("""
                                Depostido concluído com sucesso!!
                                Saldo após depósito: R$%.2f""", saldo));

                    } else {

                        System.out.println("Valor inválido");
                    }
                  // Caso seja 3, começa processo de transferencia
                } else if (escolha == 3) {

                    System.out.print("Digite o valor da tranferencia: R$");

                    if (teclado.hasNextDouble()) {

                        double valorTranferencia = teclado.nextDouble();

                        if (valorTranferencia > saldo) {

                            System.out.println("Saldo insuficiente para esta tranferencia");

                        } else if (valorTranferencia <= saldo) {

                            saldo -= valorTranferencia;
                            System.out.println("Transferencia concluida com sucesso!!!");
                            System.out.println("Saldo após tranferencia: R$" + saldo);
                        }
                    } else {

                        System.out.println("Valor invalido");
                    }
                  // Caso seja 4, encerra aplicação
                } else if (escolha == 4) {

                    loop = true;

                } else if (escolha >= 5) {

                    System.out.println("Digite uma opção valida");

                }
            } else{

                System.out.println("Digite uma opção valida");
            }
        }
    }
}