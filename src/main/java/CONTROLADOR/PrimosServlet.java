package CONTROLADOR;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PrimosServlet")
public class PrimosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos los parámetros del rango inical que nosotros damos
        int inicio = Integer.parseInt(request.getParameter("inicio"));
        int fin = Integer.parseInt(request.getParameter("final"));

        // Calcular los números primos en el rango dado

        List<Integer> primos = new ArrayList<>();
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                primos.add(i);
            }
        }

        // Cuenta los números primos que haiga encontrado

        int cantidadPrimos = primos.size();

        // Envía los datos al JSP llamado resultado

        request.setAttribute("primos", primos);
        request.setAttribute("cantidadPrimos", cantidadPrimos);
        request.setAttribute("inicio", inicio);
        request.setAttribute("fin", fin);
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }

    // Método para verificar si un número es primo

    private boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
}


