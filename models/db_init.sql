/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/5/15 8:20:54                            */
/*==============================================================*/


drop table if exists article;

drop table if exists blog;

drop table if exists commentx;

drop table if exists groupx;

drop table if exists map_user_article_collection;

drop table if exists map_user_blog_collection;

drop table if exists map_user_group_member;

drop table if exists map_user_plate_admin;

drop table if exists map_user_plate_collection;

drop table if exists map_user_post_collection;

drop table if exists map_user_user_following;

drop table if exists plate;

drop table if exists post;

drop table if exists userx;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   article_id           int not null auto_increment,
   creator_id           varchar(30),
   plate_id             int,
   group_id             int,
   article_title        varchar(150),
   article_content      varchar(3000),
   type                 varchar(10),
   create_date          datetime,
   update_date          datetime,
   primary key (article_id)
);

/*==============================================================*/
/* Table: blog                                                  */
/*==============================================================*/
create table blog
(
   blog_id              int not null auto_increment,
   creator_id           varchar(30),
   blog_title           varchar(150),
   blog_content         varchar(1500),
   create_date          datetime,
   update_date          datetime,
   primary key (blog_id)
);

alter table blog comment '博客';

/*==============================================================*/
/* Table: commentx                                              */
/*==============================================================*/
create table commentx
(
   comment_id           int not null auto_increment,
   object_id            int,
   comment_type         varchar(10),
   comment_content      varchar(1500),
   creator_id           varchar(30),
   reply_id             int,
   create_date          datetime,
   primary key (comment_id)
);

alter table commentx comment '回复/评论';

/*==============================================================*/
/* Table: groupx                                                */
/*==============================================================*/
create table groupx
(
   group_id             int not null auto_increment,
   group_name           varchar(90),
   owner_id             varchar(30),
   group_description    varchar(600),
   create_date          datetime,
   primary key (group_id)
);

alter table groupx comment '群组';

/*==============================================================*/
/* Table: map_user_article_collection                           */
/*==============================================================*/
create table map_user_article_collection
(
   user_id              varchar(30) not null,
   article_id           int not null,
   primary key (user_id, article_id)
);

alter table map_user_article_collection comment '映射_用户_文章_收藏
用户收藏的文章';

/*==============================================================*/
/* Table: map_user_blog_collection                              */
/*==============================================================*/
create table map_user_blog_collection
(
   user_id              varchar(30) not null,
   blog_id              int not null,
   primary key (user_id, blog_id)
);

alter table map_user_blog_collection comment '映射_用户_博客_收藏
用户收藏的博客';

/*==============================================================*/
/* Table: map_user_group_member                                 */
/*==============================================================*/
create table map_user_group_member
(
   user_id              varchar(30) not null,
   group_id             int not null,
   is_admin             bool,
   primary key (user_id, group_id)
);

alter table map_user_group_member comment '映射_用户_群组_成员
用户与群组间的多对多关系, 分为普通成员和管理员';

/*==============================================================*/
/* Table: map_user_plate_admin                                  */
/*==============================================================*/
create table map_user_plate_admin
(
   user_id              varchar(30) not null,
   plate_id             int not null,
   primary key (user_id, plate_id)
);

alter table map_user_plate_admin comment '映射_用户_板块_管理员
板块没有普通成员, 但是板块可以设置管理员';

/*==============================================================*/
/* Table: map_user_plate_collection                             */
/*==============================================================*/
create table map_user_plate_collection
(
   user_id              varchar(30) not null,
   plate_id             int not null,
   primary key (user_id, plate_id)
);

alter table map_user_plate_collection comment '映射_用户_板块_收藏
这个表存储用户收藏的板块';

/*==============================================================*/
/* Table: map_user_post_collection                              */
/*==============================================================*/
create table map_user_post_collection
(
   user_id              varchar(30) not null,
   post_id              int not null,
   primary key (post_id, user_id)
);

alter table map_user_post_collection comment '映射_用户_帖子_收藏
用户收藏的帖子';

/*==============================================================*/
/* Table: map_user_user_following                               */
/*==============================================================*/
create table map_user_user_following
(
   user_id_0            varchar(30) not null,
   user_id_1            varchar(30) not null,
   primary key (user_id_0, user_id_1)
);

alter table map_user_user_following comment '映射_用户_用户_关注
用户之间可以单向关注, 当两个用户之间存在两个相反的单向关注时, 称他们互相关注';

/*==============================================================*/
/* Table: plate                                                 */
/*==============================================================*/
create table plate
(
   plate_id             int not null auto_increment,
   plate_name           varchar(90),
   owner_id             varchar(30),
   plate_description    varchar(600),
   create_date          datetime,
   primary key (plate_id)
);

alter table plate comment '板块';

/*==============================================================*/
/* Table: post                                                  */
/*==============================================================*/
create table post
(
   post_id              int not null auto_increment,
   creator_id           varchar(30),
   plate_id             int,
   group_id             int,
   post_title           varchar(150),
   post_content         varchar(1500),
   create_date          datetime,
   update_date          datetime,
   primary key (post_id)
);

alter table post comment '帖子';

/*==============================================================*/
/* Table: userx                                                 */
/*==============================================================*/
create table userx
(
   user_id              varchar(30) not null,
   user_name            varchar(60),
   user_pwd             varchar(16),
   is_admin             bool,
   user_avatar_url      varchar(100),
   user_email           varchar(30),
   phone_number         varchar(20),
   user_gender          varchar(1),
   user_signature       varchar(90),
   register_date        datetime,
   primary key (user_id)
);

alter table userx comment '用户';

