# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table inventory (
  id                        bigint not null,
  dealer_id                 varchar(255),
  stock                     varchar(255),
  year                      varchar(255),
  make                      varchar(255),
  model                     varchar(255),
  vin                       varchar(255),
  mileage                   varchar(255),
  retailprice               varchar(255),
  color                     varchar(255),
  transmission              varchar(255),
  options                   varchar(255),
  bodytype                  varchar(255),
  engine                    varchar(255),
  location                  varchar(255),
  vclass                    varchar(255),
  equipment                 varchar(255),
  downpayment               varchar(255),
  youpay                    varchar(255),
  constraint pk_inventory primary key (id))
;

create sequence inventory_seq;




# --- !Downs

drop table if exists inventory cascade;

drop sequence if exists inventory_seq;

