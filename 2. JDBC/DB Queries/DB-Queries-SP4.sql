delimiter $$
create procedure studentupsert2
(in in_regno int,
 in in_fnm varchar(50),
 in in_mnm varchar(50),
 in in_lnm varchar(50),
 in in_gfnm varchar(50),
 in in_gmnm varchar(50),
 in in_glnm varchar(50),
 in in_isadmin varchar(1),
  in in_password varchar(50))
begin
	declare regno_count int;
	
    select count(*) into regno_count
    from students_info
    where regno = in_regno;

    if regno_count>0 then
		
		update students_info
        set firstname = in_fnm,
            middlename = in_mnm,
            lastname = in_lnm
        where regno = in_regno;

		update guardian_info
        set gfirstname = in_gfnm,
            gmiddlename = in_gmnm,
            glastname = in_glnm
        where regno = in_regno;

		update students_otherinfo
        set password = in_password,
            isadmin = in_isadmin
        where regno = in_regno;

    else 

		insert into students_info 
        values (in_regno, in_fnm, in_mnm, in_lnm);

		insert into guardian_info 
        values (in_regno, in_gfnm, in_gmnm, in_glnm);

		insert into students_otherinfo
        values (in_regno, in_isadmin, in_password);
	
    end if;

end$$ 

delimiter ;


call studentupsert2(1, 'Praveen', 'NA', 'D', 'ABC', 'NA', 'XYZ', 'Y', 'qwerty');