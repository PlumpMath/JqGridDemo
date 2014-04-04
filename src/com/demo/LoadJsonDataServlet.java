package com.demo;


import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class LoadJsonDataServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
    public LoadJsonDataServlet() {
 
    }
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String postcode = request.getParameter("type") ;
  if(postcode == null || postcode.trim().length() == 0) postcode = "BS21 7RH";
  System.out.println("Type: " + postcode);
  List<Person> personList = new Data().getData(postcode);
 
     int totalNumberOfPages = 1;
     int currentPageNumber = 1;
     int totalNumberOfRecords = 8; // All in there are 8 records in our dummy data object
 
     JqGridData<Person> gridData = new JqGridData<Person>(totalNumberOfPages, currentPageNumber, totalNumberOfRecords, personList);
     System.out.println("Grid Data: " + gridData.getJsonString());
     response.getWriter().write(gridData.getJsonString());
 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
 }
}