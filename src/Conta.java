import java.util.ArrayList;
import java.util.List;
public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;
        this.agencia = Conta.AGENCIA_PADRAO;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valorSaque){
        if (valorSaque <= 0){
            throw new ValorSaqueInvalidoException("Valor de saque inválido");
        }
        if (valorSaque >= this.saldo){
            saldo -= valorSaque;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
    }

    public void transferir(double valor, Conta contaDestino){
        if (this.saldo > valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }
}
