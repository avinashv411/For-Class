==============================================================
| HTTP Method | Related Servlet Method                        |
==============================================================
| 1. HEAD		protected void doHead(HttpServletRequest req, 
			                         HttpServletResponse resp)
	            throws ServletException, IOException
-----------------------------------------------------------------
| 2. TRACE	    protected void doTrace(HttpServletRequest req, 
			                         HttpServletResponse resp)
	            throws ServletException, IOException	
-----------------------------------------------------------------
| 3. PUT		protected void doPut(HttpServletRequest req, 
			                         HttpServletResponse resp)
	            throws ServletException, IOException
-----------------------------------------------------------------
| 4. DELETE		protected void doDelete(HttpServletRequest req, 
			                          HttpServletResponse resp)
	            throws ServletException, IOException
-----------------------------------------------------------------
| 5. OPTIONS	protected void doOptions(HttpServletRequest req, 
			                          HttpServletResponse resp)
	            throws ServletException, IOException
-----------------------------------------------------------------
| 6. POST  	    protected void doPost(HttpServletRequest req, 
			                          HttpServletResponse resp)
	            throws ServletException, IOException
-----------------------------------------------------------------
| 7. GET  	    protected void doGet(HttpServletRequest req, 
			                         HttpServletResponse resp)
	            throws ServletException, IOException
-----------------------------------------------------------------
| 8. CONNECT    NO Implementation
-----------------------------------------------------------------
 