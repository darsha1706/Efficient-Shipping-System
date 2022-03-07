
use ess;
show tables;
desc admin;
desc transporter;
desc driver;
desc vehicle;
desc driver_vehicle;

desc customer;
desc item_detail;
desc auction_item;

desc bidder;
desc auction_item_bidder;
desc feedback_complaint;
desc payment;
desc estimated_price;
select * from admin;

drop table admin;

alter table estimated_price drop constraint FKi9sllimj7r6aym0xujydo0huu;
drop table estimated_price;

alter table feedback_complaint drop constraint FK5up4w8dwi70rqdxtmdpi3pw1;
alter table feedback_complaint drop constraint FKj8pc3km5atmhi8weh1vequ4g;
alter table feedback_complaint drop constraint FKtntmu27e58v2fr3kckdwgqwg5;
drop table feedback_complaint;

alter table payment drop constraint FKf3ext439ao06oy3iohkcmmt4s;
alter table payment drop constraint FKl9b78hxfcnmqw4kubmjxls8sc;
alter table payment drop constraint FKps99rqc6s1bpbdnl67hqfill9;
drop table payment;


alter table driver_vehicle drop constraint FK7wl5eilik9mlrvdr77i9ysbkn;
alter table driver_vehicle drop constraint FKawrysiyh18y55r3qc6h38sy52;
drop table driver_vehicle;
alter table driver drop constraint FKekbro5o5pkbn04bgawwkrttdr;
drop table driver;
alter table vehicle drop constraint FKo0qf0af7n8ix50f1rovhn510y;
drop table vehicle;


alter table auction_item_bidder drop constraint FK57mvle489buq6p7w19ub0j91r;
alter table auction_item_bidder drop constraint FK8p8n4jkkk2xa8v6iymp3wauvm;
drop table auction_item_bidder;
alter table bidder drop constraint FK2fdvuf8w3q31n7qukmsbrw4t4;
drop table bidder;
drop table transporter;
alter table auction_item drop constraint FK3h651c5iw4cntr825280nhijp;
alter table auction_item drop constraint FKbpi8rkp14rr2e7wpp6gfe3yq1;
drop table auction_item;
alter table item_detail drop constraint FK4sj7ldgi6flgn6u6j37cjl8bi;
drop table item_detail;
drop table customer;




