package com.ok;

import com.ok.duckLexer;
import com.ok.duckParser;

import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        File folder = new File("src/main/resources/casos"); // carpeta con los casos .txt
        File[] archivos = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos de prueba.");
            return;
        }

        for (File archivo : Objects.requireNonNull(archivos)) {
            System.out.println("Analizando: " + archivo.getName());
            try {
                CharStream input = CharStreams.fromReader(new FileReader(archivo));
                duckLexer lexer = new duckLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                duckParser parser = new duckParser(tokens);

                parser.removeErrorListeners();
                parser.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer,
                                            Object offendingSymbol,
                                            int line, int charPositionInLine,
                                            String msg, RecognitionException e) {
                        throw new RuntimeException("Error de sintaxis en línea " + line + ":" + charPositionInLine + " -> " + msg);
                    }
                });

                parser.programa(); // o la regla de inicio de tu gramática
                System.out.println("ACEPTADO\n");
            } catch (Exception e) {
                System.out.println("RECHAZADO: " + e.getMessage() + "\n");
            }
        }
    }
}
