public class Conta {
    double saldo;

//  Se não for declarado um modifcador de acesso, ele fica como default.
//  A classe, atributo e método pode ser acessado apenas pelas classes dos mesmos pacotes
    double sacar(double valor) {
        this.saldo = valor;
        return this.saldo;
    }
}
