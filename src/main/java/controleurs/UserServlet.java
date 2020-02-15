/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import dal.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeles.*;

/**
 *
 * @author Fabien
 */
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String erreur; 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String demande, vueReponse;  
        vueReponse = "/login.jsp";
        erreur = null;

        try {
            demande = getDemande(request); 
            if(demande.equalsIgnoreCase("login.user")){
                vueReponse = lireUtilisateur(request); 
            }
            if(demande.equalsIgnoreCase("modifier.user")){
                vueReponse = modifierUtilisateur(request); 
            }
            if(demande.equalsIgnoreCase("enregistrer.user")){
                vueReponse = enregistrerUtilisateur(request); 
            }
        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            request.setAttribute("erreurR", erreur);
            RequestDispatcher dsp = request.getRequestDispatcher(vueReponse);
            dsp.forward(request, response);
        }
    }
    
    private String getDemande(HttpServletRequest request){
        String demande = request.getRequestURI(); 
        demande = demande.substring(demande.lastIndexOf("/") + 1); 
        return demande; 
    }
    
    private String lireUtilisateur(HttpServletRequest request)throws Exception{
        UserDao userDao; 
        User user; 
        String vueReponse = "/login.jsp"; 
        try {
            user = new User();                                          // Création d'un nouvel objet User
            user.setLogin(request.getParameter("login"));               // on enregistre les données du formulaire
            user.setPwd(request.getParameter("pwd"));                   // dans l'objet User
            userDao = new UserDao();                                    // Création d'un nouvel objet UserDao
            if(userDao.connecter(user)){                                // Si userDao se connecte avec User
                vueReponse = "/accueil.jsp";                            // changement de la pageReponse
                request.setAttribute("userR", user);                    // on met dans la request userR les valeurs de l'objet User
                HttpSession session = request.getSession(true);         // on ouvre une session
                session.setAttribute("userS", user);                    // on met dans la session userS les valeurs de l'objt User
                
                List<Categorie>lCategories;                             // on déclare une liste de Categorie
                CategorieDao categorieDao;                              // on déclare un objet de type CategorieDao
                categorieDao = new CategorieDao();                      // et on l'instancie
                lCategories = categorieDao.listeCategories();           // on rajoute dans la liste ce que return la methode 
                request.setAttribute("lstCategoriesR", lCategories);    // on ajoute dans une request lstCategoriesR la liste lCategories
            }
            else{
                erreur = "login ou mdp inconnus !"; 
            }
        } 
        catch (Exception e) {
            erreur = e.getMessage(); 
        }
        finally{
            return vueReponse; 
        }
        
    }

    private String modifierUtilisateur(HttpServletRequest request)throws Exception {

        String vueReponse; 
        
        try {
            vueReponse = "/login.jsp";                                                  // on defini la valeur de vueReponse
            HttpSession session = request.getSession(true);                             // on recupère la session
            User user = (User) session.getAttribute("userS");                           // on passe à l'objet User les valeurs de la session 
            request.setAttribute("userR", user);                                        // On crée la request userR avec les valeurs de User
            CategorieDao categorieDao = new CategorieDao();                             // on instancie un nouvel obet categorieDao
            request.setAttribute("lstCategoriesR", categorieDao.listeCategories());     // on place dans la request la liste fournie par categorieDao.listeCategories()
            request.setAttribute("titre", "Modifier un profil");                        // on applique à la request titre le titre
            vueReponse = "/profil.jsp";                                                 // on change la valeur de vueReponse
            return vueReponse;                                                          // on return la vueReponse
        } 
        catch (Exception e) {
            throw e; 
        }
    }
    
    private String enregistrerUtilisateur(HttpServletRequest request)throws Exception{
        try {
            User user = new User();                                 // on crée un nouvel objet User
            user.setLogin(request.getParameter("login"));           // on affecte les valeurs de login...
            user.setPwd(request.getParameter("pwd"));               // à l'objet user
            user.setNom(request.getParameter("nom"));               // que l'on a récupéré du formulaire
            user.setPrenom(request.getParameter("prenom"));         // 
            user.setAdresse(request.getParameter("adresse"));       // 
            
            String id = request.getParameter("lstCategories");      // on récupère l'id de la catégorie choisie
            user.setIdCategorie(Integer.parseInt(id));              // on le transtype en Int et on l'enregistre
            
            request.setAttribute("userR", user);                    // on crée une request avec les valeurs de user
            
            CategorieDao categorieDao = new CategorieDao();         // on crée un nouvel objert categorieDao pour appeller la méthode liste et la passer dans la request
            request.setAttribute("lstCategoriesR", categorieDao.listeCategories());
            
            HttpSession session = request.getSession(true);         // 
            session.setAttribute("userS", user);                    // on crée une session avec les valeurs de user
            return ("/accueil.jsp");                                // 
            
        } 
        catch (Exception e) {
            throw e; 
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
