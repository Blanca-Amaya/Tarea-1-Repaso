package tarea.pkg1.repaso;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tarea1Repaso {

    static Scanner leer = new Scanner(System.in);
    static ArrayList<Inventario> inventario = new ArrayList<>();
    static ArrayList<Integer> pos = new ArrayList<>();

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        boolean resp = true;
        int confirmacion;
        while (resp) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea: \n 1. Inventario \n 2. Recursividad \n 3. Salir"));
            switch (opcion) {
                case 1 -> {
                    menuInventario();

                }
                case 2 -> {
                    menuRecursiva();
                }
                case 3 -> {
                    resp = false;
                }
            }

        }
    }

    public static void menuInventario() {
        boolean resp = true;
        while (resp) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea: \n 1. Agregar \n 2. Listar \n 3. Modificar \n 4. Eliminar \n 5. Vehiculo mas antiguo \n 6. Vehiculos de color rojo \n 7. Diferencia de años entre 2 vehiculos \n 8. Regresar al menu principal"));
            switch (opcion) {
                case 1 -> {
                    agregar();
                }
                case 2 -> {
                    listar();
                }
                case 3 -> {
                    modificar();
                }
                case 4 -> {
                    eliminar();
                }
                case 5 -> {
                    MasAntiguo();
                }
                case 6 -> {
                    ColorRojo();
                }
                case 7 -> {
                    DiferenciaAnios();
                }
                case 8 -> {
                    resp = false;
                }
            }
        }
    }

    public static void agregar() {
        if (inventario.size() >= 50) {
            JOptionPane.showMessageDialog(null, "Ha llegado al limite, solo 50 vehiculos pueden ser guardados en el inventorio");
        } else {
            String matricula = JOptionPane.showInputDialog("Ingrese la matricula: ");
            String marca = JOptionPane.showInputDialog("Ingrese la marca: ");
            String modelo = JOptionPane.showInputDialog("Ingrese la modelo: ");
            String color = JOptionPane.showInputDialog("Ingrese el color: ");
            int fabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricacion: "));
            int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio: "));
            Inventario nuevoVehiculo = new Inventario(matricula, marca, modelo, color, fabricacion, precio);
            inventario.add(nuevoVehiculo);
            JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente: \n" + nuevoVehiculo);
        }
    }

    public static void listar() {
        String lista = "--> Lista de los vehiculos: \n";
        for (int i = 0; i < inventario.size(); i++) {
            lista = lista + i + ") " + inventario.get(i) + "\n ";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    public static void modificar() {
        listarMatricula();
        String matricula = JOptionPane.showInputDialog("Ingrese la matricula del vehiculo:  ");
        int pos = buscar(matricula);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "No hay vehiculo con la matricula que se ingreso");
        }
        Inventario vehiculo = inventario.get(pos);
        String nvomatricula = JOptionPane.showInputDialog("Ingrese la nva matricula: ");
        String nvomarca = JOptionPane.showInputDialog("Ingrese la nva marca: ");
        String nvomodelo = JOptionPane.showInputDialog("Ingrese la nva modelo: ");
        String nvocolor = JOptionPane.showInputDialog("Ingrese el nva color: ");
        String nvofabricacion = JOptionPane.showInputDialog("Ingrese el año de nva fabricacion: ");
        String nvoprecio = JOptionPane.showInputDialog("Ingrese el nvo precio: ");
        if (!nvomatricula.isEmpty()) {
            vehiculo.setMatricula(nvomatricula);
        }
        if (!nvomarca.isEmpty()) {
            vehiculo.setMarca(nvomarca);
        }
        if (!nvomodelo.isEmpty()) {
            vehiculo.setModelo(nvomodelo);
        }
        if (!nvocolor.isEmpty()) {
            vehiculo.setColor(nvocolor);
        }
        if (!nvofabricacion.isEmpty()) {
            int fabricacio2 = Integer.parseInt(nvofabricacion);
            vehiculo.setFabricacion(fabricacio2);
        }
        if (!nvoprecio.isEmpty()) {
            int precio2 = Integer.parseInt(nvoprecio);
            vehiculo.setPrecio(precio2);
        }
        JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente");
    }

    public static int buscar(String matricula) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                return i;
            }
        }
        return -1;
    }

    public static void eliminar() {
        listarMatricula();
        String matricula = JOptionPane.showInputDialog("Ingrese la matricula del vehiculo:  ");
        int pos = buscar(matricula);
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "No hay vehiculo con la matricula que se ingreso");
        }
        inventario.remove(pos);
        JOptionPane.showMessageDialog(null, "Se ha eliminado el vehiculo del inventario");
    }

    public static void listarMatricula() {
        String lista = "--> Lista de mattriculas: \n";
        int cont = 1;
        for (int i = 0; i < inventario.size(); i++) {
            lista = lista + cont + ". " + inventario.get(i).getMatricula() + "\n ";
            cont++;
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    public static void MasAntiguo() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningun vehiculo en el inventario");
            return;
        }
        Inventario temp = inventario.get(0);
        for (int i = 1; i < inventario.size(); i++) {
            if (inventario.get(i).getFabricacion() < temp.getFabricacion()) {
                temp = inventario.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Mas antiguo: \n" + temp);
    }

    public static void ColorRojo() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningun vehiculo/color en el inventario");
            return;
        }
        ArrayList<Integer> pos = new ArrayList<>();
        int cont = 0;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getColor().toLowerCase().contains("rojo")) {
                cont++;
            }
        }
        pos.add(0, cont);
        JOptionPane.showMessageDialog(null, "Hay " + pos.get(0) + " de vehiculos color rojo");
    }

    public static void DiferenciaAnios() {
        listarMatricula();
        String matricula1 = JOptionPane.showInputDialog("Ingresa la matricula del primer vehiculo a comparar:  ");
        boolean verdad1 = false;
        int pos1 = buscar(matricula1);

        if (pos1 == -1) {
            JOptionPane.showMessageDialog(null, "No hay ningun vehiculo con esa matricula");
            return;
        }

        listarMatricula();
        String matricula2 = JOptionPane.showInputDialog("Ingresa la matricula del segundo vehiculo a comparar:  ");
        int pos2 = buscar(matricula2);

        if (pos2 == -1) {
            JOptionPane.showMessageDialog(null, "No hay ningun vehiculo con esa matricula");
            return;
        }

        int anio1 = inventario.get(pos1).getFabricacion();
        int anio2 = inventario.get(pos2).getFabricacion();
        int diferencia = 0;
        if (anio1 < anio2) {
            diferencia = anio2 - anio1;
        } else {
            diferencia = anio1 - anio2;
        }

        JOptionPane.showMessageDialog(null, "Diferencia de anios: " + diferencia);
    }

    public static void menuRecursiva() {
        boolean resp = true;
        while (resp) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea: \n 1. Numeros decimales a binarios \n 2. Maximo comun divisor \n 3. Serie de fibonacci \n 4. Busqueda Binaria \n 5. Regresar al menu principal"));
            switch (opcion) {
                case 1 -> {
                    int num = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el decimal: "));
                    String resp1 = binarios(num);
                    JOptionPane.showMessageDialog(null, "Decimales a binarios: " + resp1);

                }
                case 2 -> {
                    int mcd1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el primer número: "));
                    int mcd2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el segundo número: "));
                    int resp2 = MCD(mcd1, mcd2);
                    JOptionPane.showMessageDialog(null, "MCD: " + resp2);
                }
                case 3 -> {
                    int num3 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa termino de Fibonacci: "));
                    int resp3 = fibonacci(num3);
                    JOptionPane.showMessageDialog(null, "Resultado: " + resp3);

                }
                case 4 -> {
                    int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero que desea buscar: "));
                    int[] arregloNumeros = {2, 5, 8, 10, 12, 15};
                    String imprimir = "Arreglo: ";
                    for (int numero : arregloNumeros) {
                        imprimir += numero + " ";
                    }
                    int resp2 = busqueda(arregloNumeros, buscar, 0, arregloNumeros.length - 1);

                }
                case 5 -> {
                    resp = false;
                }
            }
        }
    }

    public static String binarios(int num) {
        if (num == 0) {
            return "0";
        } else if (num == 1) {
            return "1";
        } else {
            return binarios(num / 2 + num % 2);
        }
    }

    public static int fibonacci(int numero) {
        if (numero == 0) {
            return 0;
        } else if (numero == 1) {
            return 1;
        } else {
            return fibonacci(numero - 1) + fibonacci(numero - 2);
        }
    }

    public static int MCD(int mcd1, int mcd2) {
        if (mcd2 == 0) {
            return mcd1;
        } else {
            return MCD(mcd2, mcd1 % mcd2);
        }
    }

    public static int busqueda(int[] numeros, int objetivo, int inicio, int fin) {
        if (fin < inicio) {
            return -1;
        }
        int posMedia = (inicio + fin) / 2;
        if (objetivo < numeros[posMedia]) {
            return busqueda(numeros, objetivo, inicio, posMedia - 1);
        } else if (objetivo > numeros[posMedia]) {
            return busqueda(numeros, objetivo, posMedia + 1, fin);
        } else {
            return posMedia;
        }
    }
}
