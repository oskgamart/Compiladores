package com.ok;

import com.ok.duckLexer;
import com.ok.duckParser;
import com.ok.generacion.Cuadruplo;
import com.ok.semantica.DirectorioFunciones;
import com.ok.semantica.SemanticListener;
import com.ok.vm.VirtualMachine;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        File archivo = new File("src/main/resources/casos/test5.txt");
        CharStream input = CharStreams.fromReader(new FileReader(archivo));
        duckLexer lexer = new duckLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        duckParser parser = new duckParser(tokens);

        // Análisis sintáctico
        ParseTree tree = parser.programa();

        // Análisis semántico
        SemanticListener listener = new SemanticListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        List<Cuadruplo> cuadruplos = listener.getCuadruplos();
        DirectorioFunciones directorio = listener.getDirectorio();
        Map<Integer, Object> memoriaConstante = listener.getTablaConstantes();

        /* System.out.println("=== CUÁDRUPLOS ===");
        for (int i = 0; i < cuadruplos.size(); i++) {
            System.out.println(i + ": " + cuadruplos.get(i));
        } */

        System.out.println("\n=== EJECUCION ===");
        VirtualMachine vm = new VirtualMachine(cuadruplos, directorio, memoriaConstante);
        vm.run();
    }
}
