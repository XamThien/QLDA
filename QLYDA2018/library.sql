create database library default character set utf8;
use library;

Create table NHAN_VIEN (
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	USER_NAME VARCHAR(20)  NOT NULL,
    PASS VARCHAR(50) NOT NULL,
    PHONE VARCHAR(20) NOT NULL,
    NAME NVARCHAR(30) NOT NULL,
    ADDRESS NVARCHAR(50),
    STATUS BIT NOT NULL DEFAULT 1
);
INSERT INTO NHAN_VIEN (USER_NAME,PASS,PHONE,NAME,ADDRESS,STATUS) VALUES
	('huy','12345','01662108386','Trần Văn Huy','Hai bà TRưng',1),
    ('manh','12345','01662108386','Nguyễn Duy Mạnh','Thanh Xuân',1),
    ('thuy','12345','01662108386','Trần Thị Thủy','Đống Đa',1);
    SELECT * FROM NHAN_VIEN;
cREATE TABLE THE_LOAI (
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NAME NVARCHAR(30) NOT NULL,
    NOTE NVARCHAR(30),
    STATUS bit default 1
);
INSERT INTO THE_LOAI (NAME,NOTE) VALUES ('Truyện',''),('Tiểu Thuyết',''),('Khoa học',''),('Thơ',''),('Đại cương',''),('CNTT',''),
					('Cầu đường',''),('Vật liệu xây dựng',''),('Kinh tế',''),('Môi trường nước','');
select * from the_loai;
CREATE TABLE SACH(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME NVARCHAR(30) NOT NULL,
    THE_LOAI INT NOT NULL,
   
    SO_LUONG INT NOT NULL,
    SO_TRANG INT NOT NULL,
    NAM_XUAT_BAN INT NOT NULL,
    NHA_XUAT_BAN NVARCHAR(30) NOT NULL,
    TAC_GIA NVARCHAR(30) NOT NULL,
    TRANG_THAI BIT NOT NULL DEFAULT 1,
    GHI_CHU nvarchar(100) ,
    foreign key(THE_LOAI) references THE_LOAI(ID)
);
select * from Sach where TRANG_THAI =1;
INSERT INTO SACH (NAME,THE_LOAI,SO_LUONG,SO_TRANG,NAM_XUAT_BAN,NHA_XUAT_BAN,TAC_GIA,TRANG_THAI,GHI_CHU) values
				('Cô nan',1,123,234,2012,'Kim Đồng','Tokuda',1,''),
                ('An ninh mạng',6,100,234,2010,'Kim Đồng','MInh Long',1,''),
                ('Kết cấu bê tông',7,100,60,2010,'Kim Đồng','Vũ tự ân',1,'');
create table MUON_TRA(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    MSSV VARCHAR(20) NOT NULL,
    NAME_SV NVARCHAR(30) NOT NULL,
    LOP_SV VARCHAR(20) NOT NULL,
	STATUS bit default 1
);
INSERT INTO MUON_TRA (MSSV,NAME_SV,LOP_SV) VALUES
	('38259','Phạm Xuân Thủy','59pm1'),
    ('38259','Đặng tiến chiêu','59pm1');
    SELECT * FROM MUON_TRA;
create table CHI_TIET_MUON_TRA(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    MA_PHIEU_MUON_TRA INT NOT NULL,
	NGAY_MUON VARCHAR(10) NOT NULL,
	MA_SACH INT NOT NULL,
    SO_LUONG INT NOT NULL,
    XAC_NHAN_TRA BIT NOT NULL default 0,
    foreign key(MA_SACH) references SACH(ID),
    foreign key(MA_PHIEU_MUON_TRA) references MUON_TRA(ID)
);
INSERT INTO CHI_TIET_MUON_TRA (MA_PHIEU_MUON_TRA,NGAY_MUON,MA_SACH,SO_LUONG,XAC_NHAN_TRA) VALUES
	(1,'2018-5-18',1,2,0),
    (1,'2018-5-18',2,1,0);
    SELECT * FROM CHI_TIET_MUON_TRA;