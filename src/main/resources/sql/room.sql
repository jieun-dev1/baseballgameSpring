create table room
(
    id bigint AUTO_INCREMENT NOT NULL,
    roomId varchar(255),
    remainingCount smallint,
    answeredCount smallint,
    correctAnswer smallint,
    primary key(id)
) engine = innoDB;
    
