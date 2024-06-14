public class Main {
    public static void main(String[] args) {
        Cliente jose = new Cliente("José Carlos", "11111111111");
        Cliente clara = new Cliente("Clara Vitória", "22222222222");

        Conta constaPoupancaJose = new ContaPoupanca(jose);
        Conta constaPoupancaClara = new ContaPoupanca(clara);

        constaPoupancaJose.depositar(500);
        constaPoupancaClara.depositar(100);

        try {
            constaPoupancaJose.transferir(1, constaPoupancaClara);
        }catch (ValorSaqueInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }


        System.out.println(constaPoupancaJose);
        System.out.println(constaPoupancaClara);
    }
}