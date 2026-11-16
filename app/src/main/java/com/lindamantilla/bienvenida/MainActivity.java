package com.lindamantilla.bienvenida;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

/**
 * Pantalla de bienvenida.
 * La interfaz está en res/layout/activity_main.xml; aquí solo va el comportamiento:
 * el botón "Entrar" y el cambio de idioma.
 */
public class MainActivity extends AppCompatActivity {

    /** Códigos de idioma, en el mismo orden que el arreglo "nombres_idiomas" de strings.xml. */
    private static final String[] CODIGOS_IDIOMA = {"es", "en", "fr", "de"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View raiz = findViewById(R.id.raiz);
        ajustarABarrasDelSistema(raiz);

        findViewById(R.id.boton_entrar).setOnClickListener(v ->
                Snackbar.make(raiz, R.string.mensaje_bienvenida, Snackbar.LENGTH_SHORT).show());

        findViewById(R.id.boton_idioma).setOnClickListener(v -> mostrarDialogoIdioma());
    }

    /** Evita que el título o los botones queden debajo de la barra de estado o del notch. */
    private void ajustarABarrasDelSistema(View raiz) {
        ViewCompat.setOnApplyWindowInsetsListener(raiz, (vista, insets) -> {
            Insets barras = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
            vista.setPadding(barras.left, barras.top, barras.right, barras.bottom);
            return insets;
        });
    }

    /** Muestra la lista de idiomas con el actual marcado. */
    private void mostrarDialogoIdioma() {
        new MaterialAlertDialogBuilder(this)
                .setTitle(R.string.elegir_idioma)
                .setSingleChoiceItems(R.array.nombres_idiomas, indiceIdiomaActual(),
                        (dialogo, posicion) -> {
                            dialogo.dismiss();
                            cambiarIdioma(CODIGOS_IDIOMA[posicion]);
                        })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    /**
     * Aplica el idioma a toda la app. AppCompat recrea la pantalla y guarda la elección,
     * así que se mantiene aunque se cierre la aplicación.
     */
    private void cambiarIdioma(String codigo) {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(codigo));
    }

    /** Posición del idioma que se está mostrando; español (0) si no es ninguno de los cuatro. */
    private int indiceIdiomaActual() {
        String actual = getResources().getConfiguration().getLocales().get(0).getLanguage();
        for (int i = 0; i < CODIGOS_IDIOMA.length; i++) {
            if (CODIGOS_IDIOMA[i].equals(actual)) {
                return i;
            }
        }
        return 0;
    }
}
