public class Main {
    public static void main(String[] args) {
        Cliente igo = new Cliente("Igo", "303.160.410-50");
        Cliente camila = new Cliente("camila", "572.430.090-77");

        Conta constaPoupancaIgo = new ContaPoupanca(igo);
        Conta constaPoupancaCamila = new ContaPoupanca(camila);

        constaPoupancaIgo.depositar(100);
        constaPoupancaCamila.depositar(50);

        try {
            constaPoupancaIgo.transferir(1, constaPoupancaCamila);
        }catch (ValorSaqueInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }


        System.out.println(constaPoupancaIgo);
        System.out.println(constaPoupancaCamila);
    }
}