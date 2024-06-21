CREATE DATABASE TRAVELING;
USE TRAVELING

CREATE TABLE [Role] (
    role_id INT PRIMARY KEY IDENTITY(1,1),
    role_name NVARCHAR(50) NOT NULL,
    description varchar(max)
);


INSERT INTO [Role] (role_name, description) VALUES
('Admin', 'Administrator'),
('User', 'User');


CREATE TABLE Account (
    UserID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Username NVARCHAR(100) NOT NULL,
    Pass NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Phone NVARCHAR(10) NOT NULL,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES [Role](role_id)
);


INSERT INTO Account (Username, Pass, Email, Phone, role_id) VALUES
('minh', '123', 'minh@gmail.com', '0123456789', 1),
('tung', '123', 'tung@gmail.com', '0123456789', 1),
('dung', '123', 'dung@gmail.com', '0123456789', 1),
('truong', '123', 'truong@gmail.com', '0123456789', 1),
('khoa', '123', 'khoa@gmail.com', '0123456789', 1),
('user', '123', 'user@gmail.com', '0123456789', 2),
('AnhDev', '123', 'anhdev@gmail.com', '0123456789', 2),
('dat', '123', 'dat@gmail.com', '0123456789', 2);


CREATE TABLE Type_Tour (
    Type_Id INT PRIMARY KEY IDENTITY(1,1),
    Type_Name NVARCHAR(100)
);


INSERT INTO Type_Tour (Type_Name) VALUES
(N'Du ?ch MLi?n B?c'),
(N'Du L?ch Mi?n Trung'),
(N'Du L?ch Mi?n Nam'),
(N'Du L?ch c? n??c'),
(N'Du L?ch Mi?n T�y');


CREATE TABLE Tour (
    Tour_ID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Tour_Name NVARCHAR(MAX) NOT NULL,
    Images NVARCHAR(MAX),
    Type_Id INT NOT NULL,
    Duration NVARCHAR(MAX) NOT NULL,
    Time_Start DATETIME NOT NULL,
    Transport NVARCHAR(100) NOT NULL,
    Starting_Place NVARCHAR(100) NOT NULL,
    Price INT NOT NULL,
    Description NVARCHAR(MAX) NOT NULL,
    Available INT NOT NULL,
    FOREIGN KEY (Type_Id) REFERENCES Type_Tour(Type_Id)
);


INSERT INTO Tour (Tour_Name, Images, Type_Id, Duration, Time_Start, Transport, Starting_Place, Price, Description, Available) VALUES
(N'H� N?i', 'hinh.jpg', 1, '3 days', '2024-07-01 08:00:00', 'Car', N'H� N?i', 3000000, N'H� N?i, n?i ??p l?i phong c?nh tuy?t ??p', 1),
(N'?� L?t', 'hinh.jpg', 2, '5 days', '2024-07-15 10:00:00', 'Car', N'?� L?t', 5000000, N'l� 1 ??a ?i?m ?? th? gi�n, th�ch h?p cho ng??i th�ch du l?ch', 1),
(N'Hu?', 'hinh.jpg', 3, '2 days', '2024-07-20 09:00:00', 'Car', N'Hu?', 2000000, N'C? ?� Hu?, n?i kh?i g?i v? l?ch s? n??c ta', 1),
(N'?� N?ng', 'hinh.jpg', 4, '4 days', '2024-07-25 07:00:00', 'Car', N'?� N?ng', 4000000, N'l� v�ng c� nhi?u ?i?u m?i m?', 1),
(N'Mi?n T�y', 'hinh.jpg', 5, '3 days', '2024-07-26 07:00:00', 'Car', N'Mi?n T�y', 3500000, N'??a ?i?m du l?ch s�ng n??c thu h�t nhi?u du kh�ch', 1);


CREATE TABLE Book_Tour (
    Book_Tour_Id INT IDENTITY(1,1) PRIMARY KEY,
    Tour_Id INT NOT NULL,
    Name_User NVARCHAR(MAX) NOT NULL,
    Phone NVARCHAR(10) NOT NULL,
    Email NVARCHAR(MAX) NOT NULL,
    Address NVARCHAR(MAX) NOT NULL,
    Description NVARCHAR(MAX) NOT NULL,
    Number_Adults INT NOT NULL,
    Number_Children INT NOT NULL,
    FOREIGN KEY (Tour_Id) REFERENCES Tour(Tour_ID)
);
drop table Book_Tour


INSERT INTO Book_Tour (Tour_Id, Name_User, Phone, Email, Address, Description, Number_Adults, Number_Children) VALUES
(1, 'Nguyen Van A', '0123456789', 'a@gmail.com', N'Q12,TP HCM', 'No specific requirements', 2, 1),
(2, 'Le Thi B', '0987654321', 'b@gmail.com', N'Q B�nh TH?nh, TP HCM', 'Vegetarian meals', 3, 2),
(3, 'Tran Van C', '0912345678', 'c@gmail.com', N'Q G� V?p, TP HCM', 'Prefer window seats', 1, 0),
(4, 'Pham Thi D', '0909876543', 'd@gmail.com', N'Q12, TP HCM', 'Need extra pillows', 4, 2),
(5, 'Huynh Van E', '0901234532', 'e@gmail.com', N'Q Th? ??c, TP HCM', 'Need extra pillows', 4, 2);


CREATE TABLE Feedback (
    Feedback_ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT NOT NULL,
    Comments NVARCHAR(MAX),
    FOREIGN KEY (UserID) REFERENCES Account(UserID),
);
select * from Feedback
drop table Feedback

INSERT INTO Feedback (UserID, Comments) VALUES
(1, N'Chuy?n ?i r?t tuy?t.'),
(2, N'Th?i ti?t r?t m�t m?, t�i mu?n ??n ?�y th�m'),
(3, N'T�i th�ch n?i n�y'),
(4, N'Chuy?n ?i v??t c? mong ??i'),
(5, N' Mi?n T�y r?t tuy?t v?i. T�i ?� th�ch Mi?n T�y m?t r?i');

CREATE TABLE Hotel (
    Hotel_Id INT PRIMARY KEY IDENTITY(1,1),
    Hotel_Name NVARCHAR(255) NOT NULL,
    Address NVARCHAR(255) NOT NULL,
    Rating INT NOT NULL,
    Description NVARCHAR(MAX)
);

INSERT INTO Hotel (Hotel_Name, Address, Rating, Description)
VALUES 
(N'Kh�ch s?n Grand', N'123 ???ng Ch�nh, Th�nh ph? Springfield', 5, N'M?t kh�ch s?n sang tr?ng v?i c�c ti?n nghi v� d?ch v? xu?t s?c.'),
(N'City Inn', N'456 ???ng Elm, Th�nh ph? Springfield', 4, N'M?t kh�ch s?n tho?i m�i v� gi� c? ph?i ch?ng ? trung t�m th�nh ph?.'),
(N'Khu ngh? d??ng Oceanview', N'789 ???ng B�i Bi?n, Th�nh ph? Seaside', 5, N'M?t khu ngh? d??ng ven bi?n v?i t?m nh�n ra ??i d??ng tuy?t ??p v� c�c ti?n �ch h�ng ??u.'),
(N'Nh� ngh? Mountain', N'101 ???ng N�i, Th? tr?n Hilltown', 3, N'M?t nh� ngh? ?m c�ng n?m ? v�ng n�i, l� t??ng cho m?t k? ngh? cu?i tu?n.'),
(N'Kh�ch s?n S�n bay', N'202 ???ng S�n bay, Th�nh ph? Metro', 4, N'N?m g?n s�n bay, l� t??ng cho kh�ch du l?ch c�ng t�c.');

CREATE TABLE Book_HoTel
(
	UserID INT PRIMARY KEY IDENTITY(1,1),
	Hotel_Id INT NOT NULL,
	Name_User nvarchar(max) not null,
	Phone nvarchar(10) not null,
	Email nvarchar(max) not null,
	Address nvarchar(max)not null,
	Description nvarchar(max) not null,
	FOREIGN KEY (Hotel_Id) REFERENCES Hotel(Hotel_Id)
)

INSERT INTO Book_Hotel (Hotel_Id, Name_User, Phone, Email, Address, Description)
VALUES 
(1, 'Nguyen Van A', '0123456789', 'a@gmail.com', N'Q12,TP HCM', 'No specific requirements'),
(2, 'Le Thi B', '0987654321', 'b@gmail.com', N'Q B�nh TH?nh, TP HCM', 'Vegetarian meals'),
(3, 'Tran Van C', '0912345678', 'c@gmail.com', N'Q G� V?p, TP HCM', 'Prefer window seats'),
(4, 'Pham Thi D', '0909876543', 'd@gmail.com', N'Q12, TP HCM', 'Need extra pillows'),
(5, 'Huynh Van E', '0901234532', 'e@gmail.com', N'Q Th? ??c, TP HCM', 'Need extra pillows');


CREATE TABLE Car (
    Car_Id INT PRIMARY KEY IDENTITY(1,1),
	Image_Car NVARCHAR(100) NOT NULL,
    Type_Car NVARCHAR(100) NOT NULL,
	Number_Seats INT NOT NULL,
    Price INT NOT NULl,
	Color NVARCHAR(100) NOT NULL,
	Phone NVARCHAR(10) NOT NULL,
    Availability bit NOT NULL,
    Description NVARCHAR(MAX)
);


INSERT INTO Car (Image_Car,Type_Car, Number_Seats, Price, Color, Phone, Availability, Description)
VALUES 
    ('img','Sedan', 4, 20000, 'Red', '0123456789', 1, 'A comfortable red sedan.'),
    ('img','SUV', 7, 35000, 'Black', '0987654321', 1, 'A spacious black SUV.'),
    ('img','Convertible', 2, 45000, 'Blue', '0234567891', 0, 'A stylish blue convertible.'),
    ('img','Hatchback', 5, 15000, 'White', '0345678912', 1, 'A compact white hatchback.'),
    ('img','Coupe', 4, 30000, 'Silver', '0456789123', 1, 'A sleek silver coupe.');


	CREATE TABLE Car_Rental (
	User_Id INT PRIMARY KEY IDENTITY(1,1),
    Car_Id INT NOT NULL,
	Name_User nvarchar(max) not null,
	Phone nvarchar(10) not null,
	Email nvarchar(max) not null,
	Address nvarchar(max)not null,
	Description nvarchar(max) not null,
	FOREIGN KEY (Car_Id) REFERENCES Car(Car_Id)
);


INSERT INTO Car_Rental (Car_Id, Name_User, Phone, Email, Address, Description)
VALUES
    (1, 'John Doe', '1234567890', 'john@example.com', '123 Main St, Anytown', 'Rental for a weekend trip'),
    (2, 'Jane Smith', '0987654321', 'jane@example.com', '456 Elm St, Othertown', 'Rental for a family vacation'),
    (3, 'Alice Johnson', '1122334455', 'alice@example.com', '789 Oak St, Anycity', 'Rental for a business trip')



