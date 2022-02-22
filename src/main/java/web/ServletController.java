package web;

import data.ClientDaoJDBC;
import domain.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sabah Rahal
 */
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.editClient(request, response);
                    break;
                    
                case "delete":
                    this.deleteClient(request, response);
                    break;
                default:
                    this.defaultAction(request, response);
                    break;
            }
        } else {
            this.defaultAction(request, response);
        }
    }

    private void defaultAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Client> clients = new ClientDaoJDBC().list();
        System.out.println("client = " + clients);
        HttpSession session = request.getSession();
        session.setAttribute("clients", clients);
        session.setAttribute("totalClients", clients.size());
        session.setAttribute("totalBalance", this.calulateTotalBalance(clients));
        response.sendRedirect("clients.jsp");
    }

    private double calulateTotalBalance(List<Client> clients) {
        double totalBalance = 0;
        for (Client client : clients) {
            totalBalance += client.getBalance();
        }

        return totalBalance;
    }

    private void editClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperar idClient
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        Client client = new ClientDaoJDBC().searchById(new Client(idClient));
        request.setAttribute("client", client);
        String jspEdit = "/WEB-INF/pages/client/editClient.jsp";
        request.getRequestDispatcher(jspEdit).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "insert":
                    this.insertClient(request, response);
                    break;
                    
                case "modify":
                    this.modifyClient(request, response); 
                    break;
                    
                default:
                    this.defaultAction(request, response);
                    break;
            }
        } else {
            this.defaultAction(request, response);
        }
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperar valores del formulario agregar cliente
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        double balance = 0;
        String balanceString = request.getParameter("balance");
        if (balanceString != null && !"".equals(balanceString)) {
            balance = Double.parseDouble(balanceString);
        }

        //creamos el objeto client
        Client client = new Client(name, lastName, email, phone, balance);
        int modifiedRecords = new ClientDaoJDBC().insert(client);
        System.out.println("modifiedRecords = " + modifiedRecords);

        //redireccionamos 
        this.defaultAction(request, response);
    }
    
    private void modifyClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperar valores del formulario editar cliente
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        double balance = 0;
        String balanceString = request.getParameter("balance");
        if (balanceString != null && !"".equals(balanceString)) {
            balance = Double.parseDouble(balanceString);
        }

        //modificar el objeto client
        Client client = new Client(idClient ,name, lastName, email, phone, balance);
        int modifiedRecords = new ClientDaoJDBC().update(client);
        System.out.println("modifiedRecords = " + modifiedRecords);

        //redireccionamos 
        this.defaultAction(request, response);
    }
    
        private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperar valores del formulario editar cliente
        int idClient = Integer.parseInt(request.getParameter("idClient"));
        //eliminar el objeto client
        Client client = new Client(idClient);
        int modifiedRecords = new ClientDaoJDBC().delete(client);
        System.out.println("modifiedRecords = " + modifiedRecords);

        //redireccionamos 
        this.defaultAction(request, response);
    }
}
