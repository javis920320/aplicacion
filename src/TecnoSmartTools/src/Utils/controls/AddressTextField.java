package Utils.controls;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class AddressTextField extends PlaceholderText {

    private String[][] elems;
    // private Color pink = new Color(255,153,0);
    private Color pink = new Color(254, 212, 129);
    //private Color pink = new Color(254, 208, 208);
    private boolean valid = true;
    private String errorMessage = "";

    public AddressTextField() {
        super(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offs, str.toUpperCase(), a);
            }
        }, "", 0);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    setText(clearAddress(getText()));
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                setText(clearAddress(getText()));
            }
        });

        elems = new String[][]{
            {"Administración", "AD"},
            {"Aeropuerto", "AE"},
            {"Agrupación", "AG"},
            {"Altillo", "AL"},
            {"Apartamento", "AP"},
            {"Autopista", "AU"},
            {"Avenida", "AV"},
            // {"Avenida Calle", "AC"},
            // {"Avenida Carrera", "AK"},
            {"Barrio", "BR"},
            {"Bis", "BIS"},
            {"Bloque", "BQ"},
            {"Bodega", "BG"},
            //{"Bulevar", "BL"},
            {"Calle", "CL"},
            {"Carrera", "KR"},
            {"Carretera", "CT"},
            {"Casa", "CS"},
            {"Célula", "CU"},
            {"Centro Comercial", "CE"},
            {"Circular", "CQ"},
            {"Circunvalar", "CV"},
            {"Ciudadela", "CD"},
            {"Conjunto Residencial", "CO"},
            {"Consultorio", "CN"},
            {"Corregimiento", "CTO"},
            //{"Cuentas Corridas", "CC"},
            {"Deposito", "DP"},
            //{"Deposito Sótano", "DS"},
            {"Diagonal", "DG"},
            {"Edificio", "ED"},
            {"Entrada", "EN"},
            {"Esquina", "EQ"},
            {"Estación", "ES"},
            {"Este", "ESTE"},
            {"Etapa", "ET"},
            {"Exterior", "EX"},
            {"Finca", "FI"},
            {"Garaje", "GA"},
            {"Garaje Sótano", "GS"},
            {"Interior", "IN"},
            {"Kilómetro", "KM"},
            {"Local", "LC"},
            // {"Local Mezzanine", "LM"},
            {"Lote", "LT"},
            {"Manzana", "MZ"},
            // {"Mezzanine", "MN"},
            //  {"Módulo", "MD"},
            {"Norte", "NORTE"},
            {"Oeste", "OESTE"},
            {"Oficina", "OF"},
            {"Parque", "PQ"},
            {"Parqueadero", "PA"},
            {"Pasaje", "PJ"},
            {"Paseo", "PS"},
            {"Peatonal", "PT"},
            // {"Pent-House", "PN"},
            {"Piso", "PI"},
            {"Planta", "PL"},
            {"Portería", "PR"},
            {"Predio", "PD"},
            {"Puesto", "PU"},
            //{"Round Point (Glorieta)", "RP"},
            {"Sector", "SC"},
            // {"Semisótano", "SS"},
            {"Sótano", "SO"},
            // {"Suite", "ST"},
            // {"Supermanzana", "SM"},
            {"Sur", "SUR"},
            {"Terraza", "TZ"},
            {"Torre", "TO"},
            {"Transversal", "TV"},
            {"Troncal", "TC"},
            {"Unidad", "UN"},
            // {"Unidad Residencial", "UL"},
            {"Urbanización", "UR"},
            // {"Variante", "VT"},
            {"Vereda", "VD"},
            {"Vía", "VI"},
            {"Zona", "ZN"}
        };
    }

    @Override
    public String getText() {
        return clearAddress(super.getText());
    }

    @Override
    public void setText(String t) {
        String tc = clearAddress(t);
        super.setText(tc);
        valid = true;
        errorMessage = "";
        if (!tc.isEmpty()) {
            String[] parts = tc.split(" ");
            valid = true;
            errorMessage = "";
            for (int i = 0; i < parts.length && valid; i++) {
                String part = parts[i];
                if (part.length() > 1) {
                    if (!part.matches("[0-9]{1,}")) {
                        boolean found = false;
                        for (int j = 0; j < elems.length && !found; j++) {
                            if (elems[j][1].equals(part)) {
                                found = true;
                            }
                        }

                        if (!found) {
                            errorMessage = "La palabra " + part + " no es válida.";
                            valid = false;
                        }
                    }
                }
            }

            if (tc.length() <= 2 && valid) {
                errorMessage = "La dirección es demasiado corta.";
                valid = false;
            }

            if (!tc.matches("\\A[A-Z]{2}\\s.*") && valid) {
                errorMessage = "La dirección debe iniciar con más de una letra.";
                valid = false;
            }

            if (tc.matches(".*\\s[N]\\s.*") && valid) {
                errorMessage = "Recuerde que la dirección no debe llevar Nro, Num, #, etc.";
                valid = false;
            }

            if (tc.matches(".*\\s[C]\\s.*") && valid) {
                errorMessage = "Recuerde que la abreviatura para casa es CS y no C.";
                valid = false;
            }
        }
        this.setBackground(valid ? SystemColor.white : pink);
        fireActionPerformed();
    }

    public boolean hasText() {
        return !super.getText().trim().isEmpty();
    }

    public static String clearAddress(String dir) {
        if (dir == null) {
            return "";
        }
        dir = dir.toUpperCase();
        dir = Pattern.compile("[\\s]{2,}", Pattern.CASE_INSENSITIVE).matcher(dir).replaceAll(".").trim();
        Pattern p = Pattern.compile("[A-Z][0-9]|[0-9][A-Z]");
        Matcher mt = p.matcher(dir);

        while (mt.find()) {
            String p1 = dir.substring(0, mt.start() + 1);
            String p2 = dir.substring(mt.start() + 1);
            dir = p1 + " " + p2;
            mt = p.matcher(dir);
        }

        String[][] replacements = new String[][]{
            {"N0|#|NO|NUM|NUMERO|NRO", " "},
            {"CC", "CE"},
            /////////////////////////////////
            {"ADMINISTRACIÓN", "AD"},
            {"AEROPUERTO", "AE"},
            {"AGRUPACIÓN", "AG"},
            {"ALTILLO", "AL"},
            {"APARTAMENTO|APTO|APT", "AP"},//#
            {"AUTOPISTA", "AU"},
            {"AVENIDA|AVN", "AV"},//#
            //{"AVENIDA CALLE", "AC"},
            //{"AVENIDA CARRERA", "AK"},
            {"BARRIO|BRR", "BR"},
            {"BIS", "BIS"},
            {"BLOQUE|BL|BLQ|BQQ|BLO|BQO|BQQ", "BQ"},//#
            {"BODEGA", "BG"},
            //{"BULEVAR", "BL"},
            {"KRAA|KRA|KRRA|KRR|KRRA|KARRERA", "KR"},//#
            {"CR|CRA|CARRERA|CRRA|CRR|CRRA|CAR", "KR"},//#
            {"CARRETERA", "CT"},
            {"CALLE|CLE|CLLE|CAL|CLL", "CL"},//#
            {"CASA|CAS|CSA|CSS", "CS"},//#
            {"CELULA", "CU"},
            {"CENTRO COMERCIAL", "CE"},
            {"CIRCULAR", "CQ"},
            {"CIRCUNVALAR", "CV"},
            {"CIUDADELA", "CD"},
            {"CONJUNTO RESIDENCIAL", "CO"},
            {"CONSULTORIO", "CN"},
            {"CORREGIMIENTO|CORREG|CORREJIMIENTO", "CTO"},
            //{"CUENTAS CORRIDAS", "CC"},
            {"DEPOSITO", "DP"},
            //{"DEPOSITO SÓTANO", "DS"},
            {"DIAGONAL|DIAG|DGL|DGNAL|DGONAL|DGAL|DGNAL", "DG"},//#
            {"EDIFICIO", "ED"},
            {"ENTRADA", "EN"},
            {"ESQUINA", "EQ"},
            {"ESTACION", "ES"},
            {"ESTE", "ESTE"},
            {"ETAPA|ETP", "ET"},//#
            {"EXTERIOR", "EX"},
            {"FINCA", "FI"},
            {"GARAJE", "GA"},
            //{"GARAJE SÓTANO", "GS"},
            {"INTERIOR", "IN"},
            {"KILOMETRO", "KM"},
            {"LOCAL|LOCL", "LC"},
            //{"LOCAL MEZZANINE", "LM"},
            {"LOTE", "LT"},
            {"MANZANA|MZA|MAN|MANZ|MAZ", "MZ"},//#
            //{"MEZZANINE", "MN"},
            //{"MODULO", "MD"},
            {"NORTE", "NORTE"},
            {"OESTE", "OESTE"},
            {"OFICINA", "OF"},
            {"PARQUE", "PQ"},
            {"PARQUEADERO", "PA"},
            {"PASAJE", "PJ"},
            {"PASEO", "PS"},
            {"PEATONAL", "PT"},
            //{"PENT-HOUSE", "PN"},
            {"PISO", "PI"},
            {"PLANTA", "PL"},
            {"PORTERÍA", "PR"},
            {"PREDIO", "PD"},
            {"PUESTO", "PU"},
            //{"ROUND POINT (GLORIETA)", "RP"},
            {"SECTOR", "SC"},
            //{"SEMISÓTANO", "SS"},
            {"SOTANO", "SO"},
            //{"SUITE", "ST"},
            //{"SUPERMANZANA", "SM"},
            {"SUR", "SUR"},
            {"TERRAZA", "TZ"},
            {"TORRE|TORRES", "TO"},
            {"TRANSVERSAL|TRASVERSAL", "TV"},
            {"TRONCAL", "TC"},
            {"UNIDAD", "UN"},
            //{"UNIDAD RESIDENCIAL", "UL"},
            {"URBANIZACION|URB", "UR"},
            //{"VARIANTE", "VT"},
            {"VEREDA|VDA|VR|VD", "VD"},//#
            {"VIA", "VI"},
            {"ZONA", "ZN"},};


        dir = Pattern.compile("[^A-Z0-9Ñ]", Pattern.CASE_INSENSITIVE).matcher(dir).replaceAll(" ");
        for (int i = 0; i < replacements.length; i++) {
            dir = Pattern.compile("\\b(" + replacements[i][0] + ")\\b", Pattern.CASE_INSENSITIVE).matcher(dir).replaceAll(replacements[i][1]);
        }
        dir = Pattern.compile("[\\s]{2,}", Pattern.CASE_INSENSITIVE).matcher(dir).replaceAll(" ").trim();

        Matcher matcher = Pattern.compile("\\b[0]+(\\d{1,})\\b", Pattern.CASE_INSENSITIVE).matcher(dir);

        while (matcher.find()) {
            dir = matcher.replaceAll(matcher.group(1));
            matcher = Pattern.compile("\\b[0]+(\\d)\\b", Pattern.CASE_INSENSITIVE).matcher(dir);
        }

        return dir;
    }

    public boolean isAddressValid() {
        return valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
