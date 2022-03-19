package com.company;

public class Main {

    static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        agenda.cargrContactosFile();
        agenda.mostrar();
        agenda.addContacto();
        agenda.mostrar();
        agenda.actualizarContactosFile();
    }
}
