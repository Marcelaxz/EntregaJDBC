package br.mack.ps2;

public class Usuario {
    private int n_conta;
    private double saldo;

    public void setN_conta(int n_conta) {
        this.n_conta = n_conta;
    }

    public int getN_conta() {
        return n_conta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "Número da Conta = " + n_conta +
                ", Saldo = " + saldo +
                '}';
    }
}
