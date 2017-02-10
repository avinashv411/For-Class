delimiter $$
create procedure studentupsert
(in in_regno int,
 in in_fnm varchar(50),
 in in_mnm varchar(50),
 in in_lnm varchar(50) )
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

    else 

		insert into students_info 
        values (in_regno, in_fnm, in_mnm, in_lnm);
	
    end if;

end$$ 

delimiter ;

call studentupsert(10, 'Priyanka 123', 'NA 123', 'Chopra 123');

