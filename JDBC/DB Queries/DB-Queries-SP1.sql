delimiter $
create procedure getAllStudents()
begin
	select * from students_info;
end$

delimiter ;

call getAllStudents();