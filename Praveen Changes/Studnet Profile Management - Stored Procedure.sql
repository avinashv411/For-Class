
delimiter @
create procedure studentProfileManagement(
	in input_regno int,
	in input_fnm varchar(30),
	in input_mnm varchar(30),
	in input_lnm varchar(30),
	in input_gfn varchar(30),
	in input_gmn varchar(30),
	in input_gln varchar(30),
	in input_isadmin varchar(30),
	in input_password varchar(30),
	in input_action varchar(20)
)
begin
  if input_action='update' then
   
    update student_info si,gaurdian_info gi,students_otherinfo soi set si.firstName=input_fnm,       si.middleName=input_mnm,si.lastName=input_lnm,gi.GfirstName=input_gfn,gi.GmiddleName=input_gmn, gi.GlastName=input_gln, soi.isAdmin=input_isadmin, soi.password=input_password 
  where si.regno=gi.regno and gi.regno=soi.regno and soi.regno=input_regno;
 else if input_action='delete' then
  delete from  student_info where regno=input_regno;
 delete from  gaurdian_info where regno=input_regno;
 delete from  students_otherinfo where regno=input_regno;
else 
 insert into student_info values(input_regno,input_fnm,input_mnm,input_lnm);
 insert into gaurdian_info values(input_regno,input_gfn,input_gmn,input_gln);
 insert into students_otherinfo values(input_regno,input_isadmin,input_password);
end if;
end if;
end @
delimiter ;













































