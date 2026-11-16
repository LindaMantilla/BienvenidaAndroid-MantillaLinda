# Bienvenida Android

Aplicación Android en Java con una pantalla de bienvenida que se adapta a cualquier tamaño y orientación de pantalla y está disponible en cuatro idiomas.

**Autora:** Linda Nickol Mantilla García — Licenciatura en Lenguas Extranjeras

## Qué cumple

| Requisito | Cómo se resolvió |
|---|---|
| Español (predeterminado), inglés, francés y alemán | Textos en `res/values`, `values-en`, `values-fr` y `values-de`. Si el teléfono está en otro idioma, se usa español. |
| Fondo Nine-patch redimensionable sin afectar al muñeco | `res/drawable-xhdpi/fondo_android.9.png`: solo se estiran el cielo (vertical) y las franjas a izquierda y derecha del muñeco (horizontal). |
| Interfaz correcta en cualquier pantalla y orientación | `ConstraintLayout` con posiciones en porcentaje, medidas distintas para tabletas (`values-sw600dp`) y rotación libre. |

Además, el botón **Idioma** permite cambiar el idioma desde la propia app; la elección se conserva al cerrarla.

## Cómo abrirlo

1. Clona el repositorio o descarga el código.
2. En Android Studio: **File > Open** y elige la carpeta `BienvenidaAndroid`.
3. Espera a que termine la sincronización de Gradle y pulsa **Run**.

Requisitos: Android Studio con Android Gradle Plugin 8.7 o superior, JDK 17 y Android SDK 35. Funciona desde Android 7.0 (API 24).

## Estructura

```
app/src/main/
├── AndroidManifest.xml
├── java/com/lindamantilla/bienvenida/MainActivity.java   comportamiento
└── res/
    ├── layout/activity_main.xml          interfaz
    ├── drawable-xhdpi/fondo_android.9.png  fondo Nine-patch
    ├── values/                           textos en español, colores, medidas, tema
    ├── values-en/ values-fr/ values-de/  traducciones
    ├── values-sw600dp/                   medidas para tabletas
    └── xml/locales_config.xml            idiomas soportados
```

## Cómo probarlo

- **Idiomas:** toca **Idioma** y elige otro, o cambia el idioma del teléfono.
- **Rotación:** gira el dispositivo; el muñeco conserva su forma y el texto sigue en el cielo.
- **Tamaños:** ejecútalo en un emulador de teléfono y en uno de tableta.

La imagen de fondo es la entregada en el enunciado de la actividad.
