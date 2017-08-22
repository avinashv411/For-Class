Stored Procedure 1 :-
=======================
1. delimiter &

2. 	drop procedure if exists getAllStudents;
	create procedure getAllStudents()
	begin
		select * from students_info;
	end&

3. delimiter ;

4. call getAllStudents();