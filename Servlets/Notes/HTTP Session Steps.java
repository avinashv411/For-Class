/*
 * I. Create a HttpSession
 */
HttpSession session = req.getSession(true);

=================================================
/*
 * II. Validate the Session
 */
HttpSession session = req.getSession(false);
if(session==null) {
	//Invalid Session; Generate Login Page
}else{
	//Valid Session; Generate Proper Response
}

=================================================
/*
 * III. Invalidate Session
 */
HttpSession session =  req.getSession(false);
if(session!=null) {
	session.invalidate();
}
//Generate Login Page with Success Msg




