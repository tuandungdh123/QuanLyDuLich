create database QUANLY_TOUR;
use QUANLY_TOUR;
go

select *
from TaiKhoan

create table TaiKhoan
(
    MaTK     int identity(1,1) not null primary key,
    TaiKhoan nvarchar(100) not null,
    MatKhau  varchar(100) not null,
    Email    nvarchar(100) not null,
    SDT      nvarchar(10) not null,
    VaiTro   bit          not null
) go
INSERT INTO TaiKhoan(TaiKhoan,MatKhau,Email,SDT,VaiTro) VALUES
('minh','123','minh@gmail.com','0123456789','True'),
('tung','123','tung@gmail.com','0123456789','True'),
('dung','123','dung@gmail.com','0123456789','True'),
('truong','123','truong@gmail.com','0123456789','True'),
('khoa','123','khoa@gmail.com','0123456789','True'),
('user','123','user@gmail.com','0123456789','False'),
('AnhDev','123','anhdev@gmail.com','0123456789','False'),
('dat','123','dat@gmail.com','0123456789','False')
select *
from TaiKhoan
drop TABLE TaiKhoan;
go
create table Tour
(
    MaTour    int identity(1,1) not null primary key,
    Tentour   nvarchar( max) not null,
    Anh       nvarchar( max),
	Loai nvarchar(max) not null,
    ThoiGian  nvarchar( max) not null,
    KhoiHanh  datetime not null,
    VanChuyen nvarchar(100) not null,
    XuatPhat  nvarchar(100) not null,
    Gia       int      not null,
    MoTa      nvarchar( max) not null,
    SoChoCon  int      not null
)
go
drop table Tour
go
create table DatTour
(
    MaKH           int identity(1,1) not null primary key,
    MaTour         int,
    TenTour        nvarchar( max),
    MaTK           int not null,
    HoTen          nvarchar(100) not null,
    Email          nvarchar(100) not null,
    SDT            nvarchar(10) not null,
    DiaChi         nvarchar( max) not null,
    GhiChu         nvarchar( max),
    SLNguoiLon     int check (SLNguoiLon > 0),
    SLTreEm5_11    int,
    SLTreNho2_5    int,
    SLSoSinh       int,
    PhuThuVisa     bit,
    SLVisa         int,
    PhuThuPhongDon bit,
    SLPhongDon     int,
    Gia            int not null,
    foreign key (MaTK) references TaiKhoan (MaTK),
    foreign key (MaTour) references Tour (MaTour)
)
go
drop table DatTour
go
select *
from DatTour
go
INSERT INTO DatTour(MaTK, HoTen, Email, SDT, DiaChi, GhiChu, SLNguoiLon, SLTreEm5_11, SLTreNho2_5, SLSoSinh, PhuThuVisa,
             SLVisa, PhuThuPhongDon, SLPhongDon, Gia)
VALUES
    ('1', N'Nguyễn Lê Thị Hồng Minh', 'minh@gmail.com', '0123456789', N'88 Đồng Khởi', N'Note', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2000000'),
    ('2', N'Lê Thanh Tùng', 'tung@gmail.com', '0123456789', N'Hẻm 287, 289 Nguyễn Đình Chiểu', N'Note', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2000000'),
    ('3', N'Trương Tuấn Dũng', 'dung@gmail.com', '0123456789', N'51 Bà Lài,P8,Q6', N'Note', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2000000'),
    ('4', N'Ngô Quang Trường', 'truong@gmail.com', '0123456789', N'88 Đồng Khởi', N'Note', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2000000'),
    ('5', N'Huỳnh Đăng Khoa', 'khoa@gmail.com', '0123456789', N'Hẻm 63, 75/11 Bình Quới', N'Note', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2000000'),
    ('6', N'User', 'user@gmail.com', '0123456789', N'88 Đồng Khởi', N'Note', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2000000'),
    ('7', N'AnhDev Quốc Đạt', 'anhdev@gmail.com', '0123456789', N'88 Đồng Khởi', N'Note', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2000000'),
    ('8', N'Lê Văn Đạt', 'dat@gmail.com', '0123456789', N'Hẻm 61/27 Quang Trung, phường10, quận Gò Vấp', N'Note', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2000000')
    
go
create table KhachSan(
	MaKS int identity(1,1) not null primary key,
	TenKS nvarchar(max) not null,
	Anh nvarchar(max) not null,
	ChatLuong nvarchar(max) not null,
	DichVu nvarchar(max)not null,
	DiaChi nvarchar(max) not null,
	SDT nvarchar(10) not null,
	Gia int not null,
	MoTa nvarchar(max),
	SLCho int not null
)
go
SET IDENTITY_INSERT Tour ON;
INSERT INTO Tour(MaTour, Tentour, Anh,Loai, ThoiGian, KhoiHanh, VanChuyen, XuatPhat, Gia, MoTa, SoChoCon) VALUES 
('1', N'Du Lịch Đà Lạt'  ,N'Sài Gòn', 'img', '3 Ngày 2 đêm', '01/01/2024', 'LoShip', 'TpHCM', '2300000', N'Bao gồm phí ăn uống', '0'),
('2', N'Du Lịch Đà Nẵng' ,N'Sài Gòn', 'img', '2 Ngày 3 đêm', '01/01/2024', 'LoShip', 'TpHCM', '2300000', N'Bao gồm phí ăn uống', '0'),
('3', N'Du Lịch Cà Mau'  ,N'Sài Gòn', 'img', '3 Ngày 2 đêm', '01/01/2024', 'LoShip', 'TpHCM', '2300000', N'Bao gồm phí ăn uống', '0'),
('4', N'Du Lịch Miền Tây',N'Sài Gòn', 'img', '7 Ngày 6 đêm', '01/01/2024', 'LoShip', 'TpHCM', '9300000', N'Bao gồm phí ăn uống', '0'),
('5', N'Du Lịch Phú Quốc',N'Sài Gòn', 'img', '7 Ngày 6 đêm', '01/01/2024', 'LoShip', 'TpHCM', '3500000', N'Bao gồm phí ăn uống', '0');
go
INSERT INTO KhachSan VALUES
(N'Khách sạn Ánh Sao',N'img',N'<i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i>',N'Giường Lớn',N'123 Quang Trung','0123456789','5000000','','100'),
(N'Khách sạn Ánh Sao',N'img',N'<i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i>',N'Giường Lớn',N'123 Quang Trung','0123456789','5000000','','100'),
(N'Khách sạn Ánh Sao',N'img',N'<i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i>',N'Giường Lớn',N'123 Quang Trung','0123456789','5000000','','100'),
(N'Khách sạn Ánh Sao',N'img',N'<i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i>',N'Giường Lớn',N'123 Quang Trung','0123456789','5000000','','100'),
(N'Khách sạn Ánh Sao',N'img',N'<i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i><i class="fa-solid fa-star" style="color: #fff700;"></i>',N'Giường Lớn',N'123 Quang Trung','0123456789','5000000','','100')
go
create table ThueXe
(
	MaKH int identity(1,1) not null primary key,
	HoTenKH nvarchar(max) not null,
	SDT nvarchar(10) not null,
	Email nvarchar(max) not null,
	MaXe int not null,
	LoaiXe nvarchar(max) not null,
	DiemDi nvarchar(max)not null,
	DiemDen nvarchar(max) not null,
	NgayDi date,
	NgayVe date,
	Khac nvarchar(max),
	foreign key (MaKH) references DatTour(MaKH),
	foreign key (MaXe) references Xe(MaXe)
)
go
drop table ThueXe
go
go

insert into ThueXe values
(N'Nguyễn Lê Thị Hồng Minh','0123456789','minh@gmail.com','1',N'Xe du lịch 4 chỗ',N'Sài Gòn',N'Đà Lạt','2024-02-10','2022-02-14',''),
(N'Lê Thanh Tùng','0123456789','tung@gmail.com','2',N'Xe du lịch 7 chỗ',N'Sài Gòn',N'Vũng Tàu','2024-02-10','2022-02-14',''),
(N'Trương Tuấn Dũng','0123456789','dung@gmail.com','3',N'Xe du lịch 16 chỗ',N'Sài Gòn',N'Đà Nẵng','2024-02-10','2022-02-14',''),
(N'Ngô Quang Trường','0123456789','truong@gmail.com','4',N'Xe du lịch 24 chỗ',N'Sài Gòn',N'Vĩnh Hy','2024-02-10','2022-02-14',''),
(N'Huỳnh Đăng Khoa','0123456789','khoa@gmail.com','5',N'Xe du lịch 29 chỗ',N'Sài Gòn',N'Quy Nhơn','2024-02-10','2022-02-14',''),
(N'User','0123456789','user@gmail.com','6',N'Xe du lịch 35 chỗ',N'Sài Gòn',N'Nha Trang','2024-02-10','2022-02-14',''),
(N'AnhDev','0123456789','anhdev@gmail.com','7',N'Xe du lịch 39 chỗ',N'Sài Gòn',N'Vịnh Hạ Long','2024-02-10','2022-02-14',''),
(N'Bùi Quốc Đạt','0123456789','dat@gmail.com','8',N'Xe du lịch 45 chỗ',N'Sài Gòn',N'Phú Quốc','2024-02-10','2022-02-14','')
go
create table Xe
(
	MaXe int identity(1,1) not null primary key,
	HangXe nvarchar(50) not null,
	KieuXe nvarchar(50) not null,
	SoCho int not null,
	DoiXe nvarchar(50),
	MauXe nvarchar(100) not null,
	Gia int not null
)
go
insert into Xe values
('Mercedes-Benz',N'4 Chỗ','4','0',N'Nâu, Xanh, Đỏ, Trắng, Đen','3000000'),
('Audi',N'4 Chỗ','4','2012',N'Đỏ, Trắng','3000000'),
('Ferrari',N'4 Chỗ','4','2012',N'Đỏ','3000000'),
('Chrysler',N'4 Chỗ','4','0',N'Trắng','3000000'),
('Hyundai',N'7 Chỗ','9','0',N'Đỏ, Trắng, Đen','3000000'),
('Hyundai',N'35 Chỗ','0','0',N'Nâu, Xanh, Xanh đọt chuối, Vàng, Đỏ, Trắng, Đen','10000000'),
('Mitsibishi',N'4 Chỗ','4','2012',N'Đỏ','10000000'),
('Volkswagen',N'4 Chỗ','3','2011',N'Trắng, Đen','10000000')

drop table Xe
go
select * from ThueXe
go
select * from DatTour
GO
select * from TaiKhoan
GO
select * from Tour
go
select * from KhachSan
go
select * from Xe
go