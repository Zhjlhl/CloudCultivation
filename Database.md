# 数据库

## 数据库E-R图
后续补充

## 数据库的选择
MySQL

## 数据库关系与命名
数据库名称 cloudcultivation  
```mysql
CREATE DATABASE cloudcultivation;
```
**粗体为主键，斜体为外键**  

---

***1.用户表***  
- 用户(ID,账户,名字,密码,性别,联系电话,邮编地址,余额)
user(**user_id**,user_account,user_name,user_password,user_gender,user_phone,user_zipcode，user_balance)  
- 主键: ID(user_id)
```mysql
CREATE TABLE user (
user_id INT NOT NULL AUTO_INCREMENT,
user_account VARCHAR(50) NOT NULL,
user_name VARCHAR(50) NOT NULL,
user_password VARCHAR(50) NOT NULL,
user_gender VARCHAR(10),
user_phone VARCHAR(20),
user_zipcode VARCHAR(10),
user_balance DECIMAL(10, 2),
PRIMARY KEY (user_id)
);
```

***2.商家表***  
- 商家(ID,账户,商家名称,密码,联系人,联系电话,描述,余额,保证金)  
merchant(**merchant_id**,merchant_account,merchant_name,merchant_password,merchant_contacts,merchant_phone,merchant_description,
merchant_balance,merchant_promise)  
- 主键: ID(merchant_id)
```mysql
CREATE TABLE merchant (
  merchant_id INT NOT NULL AUTO_INCREMENT,
  merchant_account VARCHAR(50) NOT NULL,
  merchant_name VARCHAR(50) NOT NULL,
  merchant_password VARCHAR(50) NOT NULL,
  merchant_contacts VARCHAR(50) NOT NULL,
  merchant_phone VARCHAR(20),
  merchant_description TEXT,
  merchant_balance DECIMAL(10, 2),
  merchant_promise DECIMAL(10, 2),
  PRIMARY KEY (merchant_id)
);
```

***3.客服表***  
- 客服(ID,账户,名字,昵称,性别,联系电话,描述,密码)  
service(**service_id**,service_account,service_name,service_nickname,service_gender,service_phone,service_description,service_password)  
- 主键: ID(service_id)
```mysql
CREATE TABLE service (
  service_id INT NOT NULL AUTO_INCREMENT,
  service_account VARCHAR(50) NOT NULL,
  service_name VARCHAR(50) NOT NULL,
  service_nickname VARCHAR(50) NOT NULL,
  service_gender VARCHAR(10),
  service_phone VARCHAR(20),
  service_description TEXT,
  service_password VARCHAR(50),
  PRIMARY KEY (service_id)
);
```

***4.管理员表***  
- 管理员(ID,账户,密码,联系电话,等级,描述)  
administrator(**administrator_id**,administrator_account,administrator_password,administrator_phone,administrator_type,administrator_description)  
- 主键: ID(administrator_id)
```mysql
CREATE TABLE administrator (
  administrator_id INT NOT NULL AUTO_INCREMENT,
  administrator_account VARCHAR(50) NOT NULL,
  administrator_password VARCHAR(50) NOT NULL,
  administrator_phone VARCHAR(20),
  administrator_type VARCHAR(50),
  administrator_description TEXT,
  PRIMARY KEY (administrator_id)
);
```

***5.动物植物表***  
- 动植物(ID,名字,类别,商家ID,价格,描述,生长周期,预计收益,数量,剩余数量,审核状态)  
goods(**goods_id**,goods_name,goods_type,*merchant_id*,goods_price,goods_description,goods_growth,
goods_yield,goods_amount,goods_remain,goods_check)  
- 主键:ID(goods_id)
- 外键:商家ID(merchant_id)
```mysql
CREATE TABLE goods (
  goods_id INT NOT NULL AUTO_INCREMENT,
  goods_name VARCHAR(50) NOT NULL,
  goods_type VARCHAR(50) NOT NULL,
  merchant_id INT,
  goods_price DECIMAL(10, 2),
  goods_description TEXT,
  goods_growth VARCHAR(255),
  goods_yield VARCHAR(255),
  goods_amount INT,
  goods_remain INT,
  goods_check VARCHAR(50),
  PRIMARY KEY (goods_id),
  FOREIGN KEY (merchant_id) REFERENCES merchant(merchant_id)
);
```

***6.饲料表***  
- 饲料(ID,名称,价格,数量,描述,商家ID,剩余饲料,审核状态)  
feed(**feed_id**,feed_name,feed_price,feed_amount,feed_description,*merchant_id*,feed_remain,
feed_check)
- 主键:ID(feed_id)
- 外键:商家ID(merchant_id)
```mysql
CREATE TABLE feed (
  feed_id INT NOT NULL AUTO_INCREMENT,
  feed_name VARCHAR(50) NOT NULL,
  feed_price DECIMAL(10, 2),
  feed_amount INT,
  feed_description TEXT,
  merchant_id INT,
  feed_remain INT,
  feed_check VARCHAR(50),
  PRIMARY KEY (feed_id),
  FOREIGN KEY (merchant_id) REFERENCES merchant (merchant_id)
);
```

***7.订单表***
- 订单(ID,用户ID,商家ID,动植物ID,备注,支付状态,支付金额,订单状态,订单评价,订单日期,保险状态,订单结束时间,
最终实际收益,动植物最终状态,昵称,上一次饲料)  
order(**orders_id**,*user_id*,*merchant_id*,*goods_id*,orders_description,orders_payment_state,
orders_amount,orders_state,orders_remark,orders_date,orders_insurance,orders_end_time,orders_end_yield,
orders_end_state,orders_nickname,orders_feed)
- 主键:ID(orders_id)
- 外键:用户ID(user_id),商家ID(merchant_id),动植物ID(goods_id)
```mysql
CREATE TABLE orders (
  orders_id INT NOT NULL AUTO_INCREMENT,
  user_id INT,
  merchant_id INT,
  goods_id INT,
  orders_description TEXT,
  orders_payment_state VARCHAR(50),
  orders_amount DECIMAL(10, 2),
  orders_state VARCHAR(50),
  orders_remark VARCHAR(255),
  orders_date DATETIME,
  orders_insurance VARCHAR(100),
  orders_end_time DATETIME,
  orders_end_yield DECIMAL(10,2),
  orders_end_state VARCHAR(255),
  orders_nickname VARCHAR(50),
  orders_feed VARCHAR(50),
  PRIMARY KEY (orders_id),
  FOREIGN KEY (user_id) REFERENCES user (user_id),
  FOREIGN KEY (merchant_id) REFERENCES merchant (merchant_id),
  FOREIGN KEY (goods_id) REFERENCES goods (goods_id)
);
```

***8.收获表***  
- 收获(ID,订单ID,收获日期,收获方式,快递,收益,收获状态,快递单号)  
harvest(**harvest_id**,*orders_id*,harvest_date,harvest_way,harvest_delivery,harvest_earnings,
harvest_state,harvest_number)
- 主键:ID(harvest_id)
- 外键:订单ID(orders_id)
```mysql
CREATE TABLE harvest (
  harvest_id INT NOT NULL AUTO_INCREMENT,
  orders_id INT,
  harvest_date DATETIME,
  harvest_way VARCHAR(50),
  harvest_delivery VARCHAR(255),
  harvest_earnings DECIMAL(10, 2),
  harvest_state VARCHAR(50),
  harvest_number VARCHAR(20),
  PRIMARY KEY (harvest_id),
  FOREIGN KEY (orders_id) REFERENCES orders (orders_id)
);
```

***9.饲养信息表***  
- 饲养信息(ID,订单ID,当日状态,图片地址,视频地址,日期,体重,审核状态)  
feeding(**feeding_id**,*orders_id*,feeding_state,feeding_photo,feeding_video,feeding_date,
feeding_weight,feeding_check)
- 主键:ID(feeding_id)
- 外键:订单ID(orders_id)
```mysql
CREATE TABLE feeding (
  feeding_id INT NOT NULL AUTO_INCREMENT,
  orders_id INT,
  feeding_state VARCHAR(50),
  feeding_photo VARCHAR(255),
  feeding_video VARCHAR(255),
  feeding_date DATETIME,
  feeding_weight double,
  feeding_check VARCHAR(50),
  PRIMARY KEY (feeding_id),
  FOREIGN KEY (orders_id) REFERENCES orders (orders_id)
);
```

***10.购买饲料表***
- 购买饲料(ID,订单ID,饲料ID,数量,备注,支付状态,支付金额,日期,剩余数量)  
buy(**buy_id**,*orders_id*,*feed_id*,buy_amount,buy_description,buy_payment_state,buy_payment_amount,buy_date,buy_remain)
- 主键:ID(buy_id)
- 外键:订单ID(orders_id),饲料ID(feed_id)
```mysql
CREATE TABLE buy (
  buy_id INT NOT NULL AUTO_INCREMENT,
  orders_id INT,
  feed_id INT,
  buy_amount INT,
  buy_description TEXT,
  buy_payment_state VARCHAR(50),
  buy_payment_amount DECIMAL(10, 2),
  buy_date DATETIME,
  buy_remain INT,
  PRIMARY KEY (buy_id),
  FOREIGN KEY (orders_id) REFERENCES orders (orders_id),
  FOREIGN KEY (feed_id) REFERENCES feed (feed_id)
);
```

***11.纠纷表***  
- 纠纷(ID,订单ID,客服ID,描述,状态,结果,处理金额,纠纷类别,时间,审核状态,投诉人)  
dispute(**dispute_id**,*orders_id*,*service_id*,dispute_description,dispute_state,dispute_result,
dispute_amount,dispute_type,dispute_date,dispute_check,dispute_man)
- 主键:ID(dispute_id)
- 外键:订单ID(orders_id),客服ID(service_id)
```mysql
CREATE TABLE dispute (
  dispute_id INT NOT NULL AUTO_INCREMENT,
  orders_id INT,
  service_id INT,
  dispute_description TEXT,
  dispute_state VARCHAR(50),
  dispute_result TEXT,
  dispute_amount DECIMAL(10, 2),
  dispute_type VARCHAR(50),
  dispute_date DATETIME,
  dispute_check VARCHAR(50),
  dispute_man VARCHAR(50),
  PRIMARY KEY (dispute_id),
  FOREIGN KEY (orders_id) REFERENCES orders (orders_id),
  FOREIGN KEY (service_id) REFERENCES service (service_id)
);
```

***12.用户商家聊天表***  
- 用户商家(,,,,,)
- 主键:

***13.客服商家聊天表***  
- 客服商家(,,,,,,,)
- 主键:

***14.客服用户聊天表***  
- 客服用户(,,,,,,,)
- 主键:


