package hcltaskcontroller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcltaskdao.DBaccess;
import hcltaskmodel.DBFields;

@WebServlet(urlPatterns = "/UI")
public class servlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private DBaccess  Dao;

	    public void init() {
	        Dao = new DBaccess();
	    }
	    
	   
protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.getRequestDispatcher("/WEB-INF/views/UI.jsp"); 
    }


	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        String rName = request.getParameter("reciever_name");
	        int amount = new Integer(request.getParameter("amount"));
	        if(request.getParameter("transfer")!=null) {
	 		   DBFields fields = new DBFields(); 
	 		   int i=fields.payAmount();
	 		   intialise(fields);
	 		   fields.setBalance(i);
	 		   request.getRequestDispatcher("/WEB-INF/views/UI.jsp");
	 	   }
	        
	        DBFields fields = new DBFields();
	        fields.setReciever_name(rName);
	        fields.setAmount(amount);
	        

	        try {
	            Dao.insertData(fields);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        
	    }
	    
	private void intialise(DBFields d) {

		d.setAmount(5000);
	}

}
