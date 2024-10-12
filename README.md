CREATE TABLE Players (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name VARCHAR(30),
    team VARCHAR(30)
);


insert into Players values (default, 'Cristiano Ronaldo', 'Real Madrid');
insert into Players values (default, 'Lionel Messi', 'Barcelona');

select * from Players;
