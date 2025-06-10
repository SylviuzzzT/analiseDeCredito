package com.bank.demo.domain.model;

import java.util.Objects;

public class CPF {
    private final String numero;

    public CPF(String numero) {
        String cpfLimpo = numero.replaceAll("[^\\d]", "");

        if (!isValid(cpfLimpo)) {
            throw new IllegalArgumentException("CPF inválido: " + numero);
        }

        this.numero = cpfLimpo;
    }

    private boolean isValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int soma1 = 0, soma2 = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                soma1 += digito * (10 - i);
                soma2 += digito * (11 - i);
            }

            int d1 = 11 - (soma1 % 11);
            d1 = (d1 >= 10) ? 0 : d1;

            soma2 += d1 * 2;
            int d2 = 11 - (soma2 % 11);
            d2 = (d2 >= 10) ? 0 : d2;

            return d1 == Character.getNumericValue(cpf.charAt(9)) &&
                    d2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    public String getNumero() {
        return numero;
    }

    public String getFormatado() {
        return numero.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    @Override
    public String toString() {
        return getFormatado();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPF)) return false;
        CPF cpf = (CPF) o;
        return numero.equals(cpf.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
