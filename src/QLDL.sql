create database QUANLY_TOUR;
use QUANLY_TOUR;

create table Tour(
	MaTour int identity(1,1) not null primary key,
	Tentour nvarchar(max) not null,
	Anh nvarchar(max),
	ThoiGian nvarchar(max) not null,
	KhoiHanh datetime not null,
	VanChuyen nvarchar(100) not null,
	XuatPhat nvarchar(100) not null,
	Gia int not null,
	MoTa nvarchar(max) not null,
	SoChoCon int ,
)
select * from Tour;
drop table Tour;

create table TaiKhoan(
	MaTK int identity(1,1) not null primary key ,
	TaiKhoan nvarchar(100) not null,
	MatKhau varchar(100) not null,
	Email nvarchar(100) not null,
	SDT nvarchar(10) not null,
	VaiTro bit not null
)
select * from TaiKhoan;
drop TABLE TaiKhoan;

create table DatTour(
	MaKH int identity(1,1) not null primary key,
	MaTour int,
	TenTour nvarchar(max),
	MaTK int not null,
	HoTen nvarchar(100) not null,
	Email nvarchar(100) not null,
	SDT nvarchar(10) not null,
	DiaChi nvarchar(max) not null,
	GhiChu nvarchar(max),
	SLNguoiLon int check(SLNguoiLon>0),
	SLTreEm5_11 int,
	SLTreNho2_5 int,
	SLSoSinh int,
	PhuThuVisa bit,
	SLVisa int,
	PhuThuPhongDon bit,
	SLPhongDon int,
	Gia int not null,
	foreign key (MaTK) references TaiKhoan(MaTK),
	foreign key (MaTour) references Tour(MaTour)
)
select * from DatTour;
drop table DatTour;

create table KhachHang(
	MaTK int,
	HoTen nvarchar(100),
	Email nvarchar(100),
	SDT nvarchar(100),
	NgaySinh date
)
select * from KhachHang;
drop table KhachHang;

create table ChuyenBay(
	Id int,
	HangHK nvarchar(100),
	SoHieu nvarchar(100),
	KhoiHanh datetime,
	HaCanh datetime,
	Dich nvarchar(100),
)
select * from ChuyenBay;
drop table ChuyenBay;

create table VeBay(
	MaVe int not null,
	MaKH int not null,
	MaBay int not null,
	SoGhe nvarchar(100) not null,
	NgayBook datetime not null,
	gia int not null, 
)
select * from VeBay;
drop table VeBay;

create table ThanhToan(
	MaHD int not null, 
	MaVe int not null,
	NgayTT datetime,
	HTTT bit not null,
	gia int not null,
)
select * from ThanhToan;
drop table ThanhToan;

create table HangBay(
	MaMB int,
	TenHang nvarchar(100),
	QG nvarchar(100),
)
select * from HangBay;
drop table HangBay;

create table SanBay(
	
)

INSERT INTO TaiKhoan(TaiKhoan,MatKhau,Email,SDT,VaiTro) VALUES
('minh'  ,'123','minh@gmail.com'  ,'0123456789','True'),
('tung'  ,'123','tung@gmail.com'  ,'0123456789','True'),
('dung'  ,'123','dung@gmail.com'  ,'0123456789','True'),
('truong','123','truong@gmail.com','0123456789','True'),
('khoa'  ,'123','khoa@gmail.com'  ,'0123456789','True'),
('user'  ,'123','user@gmail.com'  ,'0123456789','False'),
('AnhDev','123','anhdev@gmail.com','0123456789','False'),
('dat'   ,'123','dat@gmail.com'   ,'0123456789','False');
go

INSERT INTO DatTour(MaTK,HoTen,Email,SDT,DiaChi,GhiChu,SLNguoiLon,SLTreEm5_11,SLTreNho2_5,SLSoSinh,PhuThuVisa,SLVisa,PhuThuPhongDon,SLPhongDon,Gia) VALUES
('1',N'Nguyễn Lê Thị Hồng Minh','minh@gmail.com'  ,'0123456789',N'88 Đồng Khởi'                                 ,' ','2',' ',' ',' ',' ',' ',' ',' ',' '),
('2',N'Lê Thanh Tùng'          ,'tung@gmail.com'  ,'0123456789',N'Hẻm 287, 289 Nguyễn Đình Chiểu'               ,' ','2',' ',' ',' ',' ',' ',' ',' ',' '),
('3',N'Trương Tuấn Dũng'       ,'dung@gmail.com'  ,'0123456789',N'51 Bà Lài, P8, Q6 '                           ,' ','2',' ',' ',' ',' ',' ',' ',' ',' '),
('4',N'Ngô Quang Trường'       ,'truong@gmail.com','0123456789',N'88 Đồng Khởi'                                 ,' ','2',' ',' ',' ',' ',' ',' ',' ',' '),
('5',N'Huỳnh Đăng Khoa'        ,'khoa@gmail.com'  ,'0123456789',N'Hẻm 63, 75/11 Bình Quới'                      ,' ','2',' ',' ',' ',' ',' ',' ',' ',' '),
('6',N'User'                   ,'user@gmail.com'  ,'0123456789',N'88 Đồng Khởi'                                 ,' ','2',' ',' ',' ',' ',' ',' ',' ',' '),
('7',N'AnhDev Quốc Đạt'        ,'anhdev@gmail.com','0123456789',N'88 Đồng Khởi'                                 ,' ','2',' ',' ',' ',' ',' ',' ',' ',' '),
('8',N'Lê Văn Đạt'             ,'dat@gmail.com'   ,'0123456789',N'Hẻm 61/27 Quang Trung, phường 10, quận Gò Vấp',' ','2',' ',' ',' ',' ',' ',' ',' ',' ');
go
 
SET IDENTITY_INSERT Tour ON;
INSERT INTO Tour(MaTour, Tentour, Anh, ThoiGian, KhoiHanh, VanChuyen, XuatPhat, Gia, MoTa, SoChoCon) VALUES 
('1', N'Du Lịch Đà Lạt'  , 'img', '3 Ngày 2 đêm', '01/01/2024', 'LoShip', 'TpHCM', '2300000', N'Bao gồm phí ăn uống', '0'),
('2', N'Du Lịch Đà Nẵng' , 'img', '2 Ngày 3 đêm', '01/01/2024', 'LoShip', 'TpHCM', '2300000', N'Bao gồm phí ăn uống', '0'),
('3', N'Du Lịch Cà Mau'  , 'img', '3 Ngày 2 đêm', '01/01/2024', 'LoShip', 'TpHCM', '2300000', N'Bao gồm phí ăn uống', '0'),
('4', N'Du Lịch Miền Tây', 'img', '7 Ngày 6 đêm', '01/01/2024', 'LoShip', 'TpHCM', '9300000', N'Bao gồm phí ăn uống', '0'),
('5', N'Du Lịch Phú Quốc', 'img', '7 Ngày 6 đêm', '01/01/2024', 'LoShip', 'TpHCM', '3500000', N'Bao gồm phí ăn uống', '0');
go