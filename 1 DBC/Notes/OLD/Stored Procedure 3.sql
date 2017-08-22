Stored Procedure 3 :-
=======================
1. delimiter @

2.	create procedure studentUpSert
	(
	   IN input_regno INT,
	   IN input_fnm VARCHAR(50),
	   IN input_mnm VARCHAR(50),
	   IN input_lnm VARCHAR(50)
	 )    
	begin
		declare regno_count int;
		
		select count(*) into regno_count
		from students_info
		where regno = input_regno;
		
		if regno_count>0 then
		 update students_info
		 set firstname = input_fnm,
			middlename = input_mnm,
		  	lastname = input_lnm
		 where regno = input_regno;
		else
		 insert into students_info
		 values (input_regno, input_fnm, input_mnm, input_lnm);
		end if;
	end@

3. delimiter ;

4. call studentUpSert(10, 'AAA', 'BBB', 'CCC');











