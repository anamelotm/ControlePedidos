package com.br.chocolatePontoVirgula.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int codigo;

    protected Timestamp dataPedido;
    protected int codigoCliente;
    protected String enderecoEntrega;
    protected boolean situacao;
    protected double valorTotal;
    protected int quantidadeTotal;
    protected int percentualDesconto;



    public boolean isFechado() {
        return this.situacao;
    }

    public void aplicarDesconto() {
        if (!isFechado()) {
            valorTotal *= (1 - (this.percentualDesconto * 100));
        } else {
            System.out.println("Não foi possível aplicar o desconto");
        }
    }
}