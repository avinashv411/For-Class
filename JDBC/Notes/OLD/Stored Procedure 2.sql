Stored Procedure 2 :-
=======================
1. delimiter $

2. create procedure getStudentInfo(IN input_regno INT)    
	begin 
		select * from students_info
		where regno = input_regno;
	end$

3. delimiter ;

4. call getStudentInfo(1);




