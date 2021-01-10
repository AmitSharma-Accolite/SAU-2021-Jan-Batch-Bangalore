create database amit;
use amit;

-- drop database amit

/* 

 create table player_details that store details about the player like player name type 
 ( BT - Batsman , BL - Blower ) and TeamName have primary key playerId

*/


create table player_details ( player_id int primary key , player_name varchar(30) , type varchar(4),
								team_name varchar(30) );

/* 
   here rename of old column name of type into category  
   because while creating table i given but facing issue in below query so change here
   
*/

alter  table player_details rename column type to category;


-- desc player_details;

 /*
	create table match_details that conatin details summary of match like team1 , team2 
	team1 run score in team1_runs and wickets in team1_wickets
	team2 run score in team2_runs and wickets in team2_wickets
	who wins field , Date of the match , ground name , location in which country match played 
	primary key match_id field 
*/

create table match_details ( match_id int primary key , team1 varchar(30) not null, team2 varchar(30) not null,
                              team1_runs int , team2_runs int , team1_wickets int , team2_wickets int, wins varchar(20),
                              date_plays date, ground varchar(20) , country varchar(20));
                              
/*
  
   at the time of create table i took date data type for date_plays 
   here need to store not system date so change into varchar need  manually enter date 

*/ 

alter table match_details modify date_plays varchar(10);



/* 
   create table  player_record  to store runs , wicket of each player with player id and match id
   player id and match id here foregin key take referenece from player details table and
   match details table 
   
*/ 

create table player_record ( player_id int Not null , runs int, wicket int , match_id int Not null ,
primary key (player_id , match_id));

alter table player_record add foreign key (player_id) references player_details(player_id);
alter table player_record add foreign key (match_id) references match_details(match_id);


-- desc player_details;


/* 
 insert some data in  player details table 
*/

insert into player_details values ( 121 ,  'V kohli' ,   'BT' , 'India');
insert into player_details values ( 122 ,  'Na saini' ,  'BL' , 'India');
insert into player_details values ( 123 ,  'SS lyer' ,   'BT' , 'India');
insert into player_details values ( 124 ,  'R Ashwin' ,  'BL' , 'India');
insert into player_details values ( 125 ,  'S Dhawan' ,  'BT' , 'India');

insert into player_details values ( 231 ,  'MA Wood' ,   'BT' , 'England');
insert into player_details values ( 232 ,  'MM Ali' ,    'BT' , 'England');
insert into player_details values ( 233 ,  'T Banton' ,  'Bl' , 'England');
insert into player_details values ( 234 ,  'SM Curran' , 'BL' , 'England');

insert into player_details values ( 341 , 'Abd Shaf' ,  'BT' , 'Pakistan');
insert into player_details values ( 342 , 'Babar A' ,   'BT' , 'Pakistan');
insert into player_details values ( 343 , 'Yasir S' ,   'BL' , 'Pakistan');
insert into player_details values ( 344 , 'Zafar G' ,   'BL' , 'Pakistan');

insert into player_details values ( 412 ,  'T Bavuma' ,   'BT' , 'South Africa');
insert into player_details values ( 413 ,  'F Plessis' ,  'BT' , 'South Africa');
insert into player_details values ( 414 ,  'D Elgar' ,    'BL' , 'South Africa');
insert into player_details values ( 415 ,  'Q de Kock' ,  'BL' , 'South Africa');

insert into player_details values ( 511 ,   'SA Abbott' ,  'BT' , 'Australia');
insert into player_details values ( 512 ,   'AC Agar'   ,  'BT' , 'Australia');
insert into player_details values ( 513 ,   'AJ Tye'    ,  'BL' , 'Australia');
insert into player_details values ( 514 ,   'A Zampa'   ,  'BL' , 'Australia');


-- select * from player_details;


-- desc match_details;

/* 
 insert some data in desc match details  table 
*/
insert into match_details values ( 1 , 'India' , 'England' , 178 , 148 , 7 , 7 , 
									'India' , '2020-01-10','Delhi', 'India');
insert into match_details values ( 2 , 'Austraila' , 'India' , 199 , 209 , 6 , 5 , 
									'India' , '2020-01-12','Mumbai', 'India');
insert into match_details values ( 3 , 'Pakistan' , 'Austrila' , 102 , 145 , 5 , 6 , 
									'Austila' , '2020-01-13','Kolkata', 'India');   
insert into match_details values ( 4 , 'South Africa' , 'India' , 166 , 192 , 6, 4 , 
									'India' , '2020-01-14','Mohali', 'India');



-- select *from match_details;


/* 
insert some  values into player record table  with player id and match id 
*/

-- desc player_record;


insert into player_record values (121 , 30, 0 , 1);
insert into player_record values (122 , 11, 3 , 1);
insert into player_record values (123 , 45, 0 , 1);
insert into player_record values (124 , 23, 4 , 1);
insert into player_record values (125 , 69, 0 , 1);
insert into player_record values (231 , 25, 0 , 1);
insert into player_record values (232 , 67, 0 , 1);
insert into player_record values (233 , 34, 3 , 1);
insert into player_record values (234 , 22, 4 , 1);

insert into player_record values (511 , 89, 1 , 2);
insert into player_record values (512 , 100, 0 , 2);
insert into player_record values (513 , 10, 2 , 2);
insert into player_record values (514 ,  0, 3 , 2);
insert into player_record values (121 , 70, 0 , 2);
insert into player_record values (122 , 32, 4 , 2);
insert into player_record values (123 , 50, 0 , 2);
insert into player_record values (124 , 12, 1 , 2);
insert into player_record values (125 , 45, 0 , 2);

insert into player_record values (341 , 45, 0 , 3);
insert into player_record values (342 , 12, 0 , 3);
insert into player_record values (343 , 34, 2 , 3);
insert into player_record values (344 , 11, 3 , 3);
insert into player_record values (511 , 54, 0 , 3);
insert into player_record values (512 , 90, 0 , 3);
insert into player_record values (513 ,  1, 4 , 3);
insert into player_record values (514 ,  0, 2 , 3);

insert into player_record values (412 , 30, 0 , 4);
insert into player_record values (413 , 30, 0 , 4);
insert into player_record values (414 , 30, 0 , 4);
insert into player_record values (415 , 30, 0 , 4);
insert into player_record values (121 , 67, 2 , 4);
insert into player_record values (122 ,  1, 2 , 4);
insert into player_record values (123 , 34, 0 , 4);
insert into player_record values (124 ,  0, 2 , 4);
insert into player_record values (125 , 90, 0 , 4);


-- select *from player_record;



/* we have three tables 
1.  match_details conatin summary 
2.  player_details contain about player	
3. 
player_record conatin about runs and wicket 
with respect to match id we can conatin that record into different tables corresponding to each team 
but i thought that players of the team is fixed and number of matches is fixed in the tournament 
then Entry in player_record table is not more than approax 300 so no need of different table to repect to team
player_reord table conatin foregin key match_id and player_id that's take reference from match_details and 
player_details 
 */


-- desc player_record;
-- desc player_details;


/*  
Question : Fetch the top 5 batsmen who scored the maximum runs.

	
    Fetching top 5 Batsman with total run , player_id, player name , team  name , 
	category tells about blower or batsman but we can also skip category field here 
    
    only Batsmen of heighest run show not blower use condition category='BT' 
    BT ( Batsmen) 

 */
select  sum(pr.runs ) as Total_runs, pd.player_id , pd.player_name, pd.team_name,pd.category 
									from player_details as pd inner join player_record  as pr 
									on pr.player_id=pd.player_id group by player_id,pd.category 
                                    having pd.category ="BT" order by Total_runs desc LIMIT 5 ;

/*  
   Question : Fetch the top 5 bowlers who has taken the maximum wickets.
    Fetching top 5 Bolwer  with total wicket , player_id, player name , team  name , 
	category tells about blower or batsman but we can also skip category field  here 
    
	only Bolwer of heighest run show not blower use condition category='BT' 
    BL ( Bolwer ) 
 */
select  sum(pr.wicket ) as Total_wicket , pd.player_id , pd.player_name, pd.team_name,pd.category 
										  from player_details as pd inner join player_record  as pr 
                                          on pr.player_id=pd.player_id group by player_id,pd.category
                                          having pd.category ="BL" order by Total_wicket  desc LIMIT 5 ;
                                          


-- desc match_details;
/*
   Question :  Fetch the average score scored by each team considering the matches played. 

match details conatin team1 and team2 field like india v/s england here team1 is india and team 2 england 
but one more case like this austrila v/s india then here team1 is austrila and team 2 is india 

so india come in team1 field and team2 field respective runs also store so we need to compute runs 
of india come in the column of team1 and team2 both 

Here create two table  groupA and goupB with respect to team1 and team2 field 
merege both and calculate average of teams 

*/



create table groupA select team1 as team_name , sum(team1_runs) as runs , count(*) as Inning 
							from match_details group by team1;
create table groupB select team2 as team_name , sum(team2_runs) as runs , count(*) as Inning 
							from match_details group by team2;



-- desc groupA;
-- desc groupB;


insert ignore into groupA select * from groupB;

-- select *from groupA;
--  select *from groupB;


create table average_of_team select team_name, sum(runs) as Total_runs , sum(Inning) as Innings , 
							sum(runs)/sum(Inning) as average from groupA group by team_name 
                            order by average  asc;
/*
    Show table  that's store team name , total runs , number of match played , and average 
    
*/
select *from average_of_team;


drop  table groupA;
drop table groupB;

-- select * from average_of_team;
-- select * from player_record;
-- desc player_details;
-- desc average_of_team;


/*
 Question : Increase the scores of each batsmen in the team, which has the 
              least average computed in Step 6, by 10 runs.

 use subquery and increase 10 runs of each player of the team which have least average.

*/





update player_record set runs = runs + 10 where player_id in
						( select player_id from player_details where team_name = 
                        ( select team_name from average_of_team where average = 
                        (select min(average) from average_of_team ) 
                        ) 
                        );
                        
                        
/*

   here show table of update player records 
   least average team player runs updated by 10 
   
*/
                        
select * from player_record;
							
                            
-- desc match_details;


/* 
	Question : 	Create a procedure which takes country as the input and 
			    gives the highest score of the country up to date, as output
                
      inside the procuder use two tempory table tableA, tableB 
      merege both the table and find out max run score by the enter name of country 
      and store into heighest_score variable
      
      
*/

DELIMITER //
 drop procedure if exists heighest_score //
 drop table if exists tableA //
 drop table if exists tableB //
CREATE PROCEDURE heighest_score (IN country_name varchar(30) ,OUT score INT)
 BEGIN
create table tableA select team1 as team_name , team1_runs as runs  from match_details ;
create table tableB select team2 as team_name , team2_runs as runs   from match_details ;

insert ignore into tableA select * from tableB;
select max(runs) into score from tableA where team_name = country_name;
drop table tableA;
drop table tableB;
 END;
//
DELIMITER ;


call heighest_score('india',@heighest_score);
select @heighest_score;
                            
                            