-- ----------------------------
-- 会员表
-- ----------------------------
drop table if exists t_member;
create table t_member (
                          member_id         bigint(20)      			not null	auto_increment    		   comment '会员id',
                          member_name       varchar(50)					not null           		   			   comment '会员姓名',
                          email         	varchar(50)     						default ''                 comment '邮箱',
                          mobile_no         varchar(30)     						default ''                 comment '手机号',
                          gender         	char(1)         						default 'F'                comment '性别 F女 M男',
                          recharge_balance  decimal(10,2)   						default 0.00               comment '充值余额',
                          give_balance      decimal(10,2)   						default 0.00               comment '赠送余额',
                          integral          int(10)     							default 0                  comment '积分',
                          `level`           char(2)         						default '00'               comment '等级',
                          label         	varchar(30)     						default ''                 comment '标签',
                          introducer		varchar(60)								default ''				   comment '介绍人',
                          remark			varchar(400)							default ''				   comment '备注',
                          last_custom_time 	datetime                    			  						   comment '最近消费时间',
                          del_member_id		bigint(20)								default 0				   comment '删除的member_id,用于唯一索引',
                          del_flag          char(1)         						default '0'                comment '删除标志（0代表存在 1代表删除）',
                          create_by         varchar(64)     						default 'system'           comment '创建者',
                          create_time 	    datetime                    			DEFAULT CURRENT_TIMESTAMP  comment '创建时间',
                          update_by         varchar(64)     						default 'system'           comment '更新者',
                          update_time       timestamp                   			default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '更新时间',
                          primary key (member_id) ,
                          UNIQUE key uk_member1(member_name,mobile_no,del_member_id)
) engine=innodb auto_increment=200 comment = '会员表';




-- ----------------------------
-- 项目表
-- ----------------------------
drop table if exists t_item;
create table t_item (
                        item_id           bigint(20)      			not null	auto_increment    		   comment '项目id',
                        item_name         varchar(200)				not null                			   comment '项目名称',
                        price         	decimal(10,2)     		    			default 0.00	           comment '价格',
                        discounted_price  decimal(10,2)      						default 0.00               comment '折扣价格',
                        description       varchar(320)         	    			default ''                 comment '描述',
                        del_item_id		bigint(20)								default 0				   comment '删除的item_id,用于唯一索引',
                        del_flag          char(1)         						default '0'                comment '删除标志（0代表存在 1代表删除）',
                        create_by         varchar(64)     						default 'system'           comment '创建者',
                        create_time 	    datetime                    			DEFAULT CURRENT_TIMESTAMP  comment '创建时间',
                        update_by         varchar(64)     						default 'system'           comment '更新者',
                        update_time       timestamp                   			default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '更新时间',
                        primary key (item_id),
                        UNIQUE key uk_item1(item_name,del_item_id)
) engine=innodb auto_increment=200 comment = '项目表';


-- ----------------------------
-- 余额充值记录表
-- ----------------------------
drop table if exists t_balance_recharge_record;
create table t_balance_recharge_record (
                                           balance_recharge_record_id      	bigint(20)      not null	auto_increment  			comment '余额充值记录id',
                                           member_id         				bigint(20)		not null                 				comment '会员id',
                                           recharge_amount         			decimal(10,2)   not null  	           	 				comment '充值金额',
                                           give_amount  						decimal(10,2)   			default 0.00             	comment '赠送金额',
                                           activity_name     				varchar(130)    			default ''               	comment '活动名称',
                                           recharge_time     				datetime        			default CURRENT_TIMESTAMP   comment '充值时间',
                                           pay_mode							char(1)						default '1'					comment '支付方式 1微信 2支付宝 3现金 9其他',
                                           remark							varchar(400)				default ''				    comment '备注',
                                           del_flag          				char(1)         			default '0'                 comment '删除标志（0代表存在 null代表删除）',
                                           create_by         				varchar(64)    				default 'system'            comment '创建者',
                                           create_time 	    				datetime        			DEFAULT CURRENT_TIMESTAMP   comment '创建时间',
                                           update_by         				varchar(64)     			default 'system'            comment '更新者',
                                           update_time       				timestamp       			default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '更新时间',
                                           primary key (balance_recharge_record_id),
                                           index idx_balance_recharge_record1(member_id)
) engine=innodb auto_increment=200 comment = '余额充值记录表';


-- ----------------------------
-- 次数充值记录表
-- ----------------------------
drop table if exists t_times_recharge_record;
create table t_times_recharge_record (
                                         times_recharge_record_id      	bigint(20)      not null	auto_increment  			comment '次数充值记录id',
                                         member_id         				bigint(20)		not null                 				comment '会员id',
                                         item_id           				bigint(20)      not null     							comment '项目id',
                                         recharge_times         			int(10)   		not null  	           	 				comment '充值次数',
                                         recharge_amount         			decimal(10,2)   not null  	           	 				comment '充值金额',
                                         give_amount  						decimal(10,2)   			default 0.00             	comment '赠送金额',
                                         activity_name     				varchar(130)    			default ''               	comment '活动名称',
                                         recharge_time     				datetime        			default CURRENT_TIMESTAMP   comment '充值时间',
                                         pay_mode							char(1)						default '1'					comment '支付方式 1微信 2支付宝 3现金 9其他',
                                         remark							varchar(400)				default ''				    comment '备注',
                                         del_flag          				char(1)         			default '0'                 comment '删除标志（0代表存在 null代表删除）',
                                         create_by         				varchar(64)     			default 'system'            comment '创建者',
                                         create_time 	    				datetime        			DEFAULT CURRENT_TIMESTAMP   comment '创建时间',
                                         update_by         				varchar(64)     			default 'system'            comment '更新者',
                                         update_time       				timestamp       			default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '更新时间',
                                         primary key (times_recharge_record_id),
                                         index idx_times_recharge_record1(member_id,item_id)
) engine=innodb auto_increment=200 comment = '次数充值记录表';


-- ----------------------------
-- 会员项目关联表
-- ----------------------------
drop table if exists t_member_item_rel;
create table t_member_item_rel (
                                   member_item_rel_id      		bigint(20)      not null	auto_increment  			comment '会员项目关联id',
                                   member_id         				bigint(20)		not null                 				comment '会员id',
                                   item_id           				bigint(20)      not null     							comment '项目id',
                                   times         					int(10)   		not null  	           	 				comment '充值次数',
                                   del_flag          				char(1)         			default '0'                 comment '删除标志（0代表存在 null代表删除）',
                                   create_by         				varchar(64)     			default 'system'            comment '创建者',
                                   create_time 	    				datetime        			DEFAULT CURRENT_TIMESTAMP   comment '创建时间',
                                   update_by         				varchar(64)     			default 'system'            comment '更新者',
                                   update_time       				timestamp       			default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '更新时间',
                                   primary key (member_item_rel_id),
                                   UNIQUE index uk_member_item_rel(member_id,item_id,del_flag)
) engine=innodb auto_increment=200 comment = '会员项目关联表';


-- ----------------------------
-- 余额消费记录表
-- ----------------------------
drop table if exists t_balance_consume_record;
create table t_balance_consume_record (
                                          balance_consume_record_id      	bigint(20)      not null	auto_increment  			comment '余额消费记录id',
                                          member_id         				bigint(20)		not null	default -1          		comment '会员id',
                                          item_id           				bigint(20)      not null     							comment '项目id',
                                          item_name         				varchar(200)	not null                    			comment '项目名称',
                                          consume_amount         			decimal(10,2)   not null  	           	 				comment '消费金额',
                                          balance_original  				decimal(10,2)   			default 0.00             	comment '原始余额',
                                          balance_after  					decimal(10,2)   			default 0.00             	comment '剩余余额',
                                          give_balance_original  			decimal(10,2)   			default 0.00             	comment '原始赠送余额',
                                          give_balance_after  				decimal(10,2)   			default 0.00             	comment '剩余赠送余额',
                                          consume_date     					date        				default (CURRENT_DATE)    	comment '消费日期',
                                          operator							varchar(60)					default ''					comment '操作人',
                                          enter_store_channel				char(2)						default ''					comment '进店渠道',
                                          introducer						varchar(60)					default ''					comment '介绍人',
                                          remark							varchar(400)				default ''				    comment '备注',
                                          del_flag          				char(1)         			default '0'                 comment '删除标志（0代表存在 null代表删除）',
                                          create_by         				varchar(64)     			default 'system'            comment '创建者',
                                          create_time 	    				datetime        			DEFAULT CURRENT_TIMESTAMP   comment '创建时间',
                                          update_by         				varchar(64)     			default 'system'            comment '更新者',
                                          update_time       				timestamp       			default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '更新时间',
                                          primary key (balance_consume_record_id),
                                          index idx_balance_consume_record1(member_id,item_id),
                                          index idx_balance_consume_record2(introducer)
) engine=innodb auto_increment=200 comment = '余额消费记录表';


-- ----------------------------
-- 次数消费记录表
-- ----------------------------
drop table if exists t_times_consume_record;
create table t_times_consume_record (
                                        times_consume_record_id      		bigint(20)      not null	auto_increment  			comment '次数消费记录id',
                                        member_id         				bigint(20)		not null 			        			comment '会员id',
                                        item_id           				bigint(20)      not null     							comment '项目id',
                                        item_name         				varchar(200)	not null                    			comment '项目名称',
                                        consume_times         			int(2)   		not null	default 1	    			comment '消费次数',
                                        times_original  					int(2)   								    			comment '原始次数',
                                        times_after  						int(2)   					             				comment '剩余次数',
                                        consume_date     					date        				default (CURRENT_DATE)    	comment '消费日期',
                                        operator							varchar(60)					default ''					comment '操作人',
                                        remark							varchar(400)				default ''				    comment '备注',
                                        del_flag          				char(1)         			default '0'                 comment '删除标志（0代表存在 null代表删除）',
                                        create_by         				varchar(64)     			default 'system'            comment '创建者',
                                        create_time 	    				datetime        			DEFAULT CURRENT_TIMESTAMP   comment '创建时间',
                                        update_by         				varchar(64)     			default 'system'            comment '更新者',
                                        update_time       				timestamp       			default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  comment '更新时间',
                                        primary key (times_consume_record_id),
                                        index idx_times_consume_record1(member_id,item_id)
) engine=innodb auto_increment=200 comment = '次数消费记录表';

