package com.framallo90;


import com.framallo90.Controller.LibrosController;
import com.framallo90.Model.Repository.LibrosRepository;
import com.framallo90.View.LibrosView;

public class Main {
    public static void main(String[] args) {
        LibrosView librosView = new LibrosView();
        LibrosRepository librosRepository = new LibrosRepository();
        LibrosController librosController = new LibrosController(librosRepository,librosView);

        librosController.menuLibro();
    }
}