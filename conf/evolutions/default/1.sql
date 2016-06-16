# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  id                            bigint not null,
  ean                           varchar(255),
  name                          varchar(255),
  description                   varchar(255),
  picture                       varbinary(255),
  constraint pk_product primary key (id)
);
create sequence product_seq;

create table stock_item (
  quantity                      bigint
);

create table tag (
  id                            bigint,
  name                          varchar(255)
);

create table warehouse (
  name                          varchar(255)
);


# --- !Downs

drop table if exists product;
drop sequence if exists product_seq;

drop table if exists stock_item;

drop table if exists tag;

drop table if exists warehouse;

