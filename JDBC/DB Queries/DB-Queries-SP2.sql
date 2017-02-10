delimiter &
create procedure 
getStudentInfo (in in_regno int)
begin
	select * from students_info
    where regno = in_regno;
end&

delimiter ;

call getStudentInfo(5);
