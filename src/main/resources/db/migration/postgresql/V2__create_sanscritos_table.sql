create sequence sanscrito_id_seq start with 1 increment by 100;

create table sanscritos (
    id bigint DEFAULT nextval('sanscrito_id_seq') not null,
    nome varchar(1024) not null,
    primary key (id)
);
