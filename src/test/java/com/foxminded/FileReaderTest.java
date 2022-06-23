package com.foxminded;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FileReaderTest {

    private final FileReader fileReader = new FileReader();

    @Test
    void givenFileName_whenRead_thenContentStrings() {
        List<String> actual = fileReader.readFile("abbreviations.txt");
        List<String> expected = new ArrayList<>();
        expected.add("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER");
        expected.add("SVF_Sebastian Vettel_FERRARI");
        expected.add("LHM_Lewis Hamilton_MERCEDES");
        expected.add("KRF_Kimi Raikkonen_FERRARI");
        expected.add("VBM_Valtteri Bottas_MERCEDES");
        expected.add("EOF_Esteban Ocon_FORCE INDIA MERCEDES");
        expected.add("FAM_Fernando Alonso_MCLAREN RENAULT");
        expected.add("CSR_Carlos Sainz_RENAULT");
        expected.add("SPF_Sergio Perez_FORCE INDIA MERCEDES");
        expected.add("PGS_Pierre Gasly_SCUDERIA TORO ROSSO HONDA");
        expected.add("NHR_Nico Hulkenberg_RENAULT");
        expected.add("SVM_Stoffel Vandoorne_MCLAREN RENAULT");
        expected.add("SSW_Sergey Sirotkin_WILLIAMS MERCEDES");
        expected.add("CLS_Charles Leclerc_SAUBER FERRARI");
        expected.add("RGH_Romain Grosjean_HAAS FERRARI");
        expected.add("BHS_Brendon Hartley_SCUDERIA TORO ROSSO HONDA");
        expected.add("MES_Marcus Ericsson_SAUBER FERRARI");
        expected.add("LSW_Lance Stroll_WILLIAMS MERCEDES");
        expected.add("KMH_Kevin Magnussen_HAAS FERRARI");

        assertEquals(actual, expected);
    }
}
