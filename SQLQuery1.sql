create database DUANB12
use DUANB12
go
create table HangXe(
MaHang nvarchar(50) not null,
TenHang nvarchar(50) not null,
ThongTinHang nvarchar(50) not null,
primary key(MaHang)
)
go 
create table HoaDonCT(
MaHD int  not null,
MaXe int not null,
SoLuong int not null,
Gia float not null,
TenSP nvarchar(50) not null,
primary key(MaHD),
foreign key(MaHD) references HoaDon(MaHD),
foreign key(MaXe) references ThongTinXe(MaXe),
)
go
create table HoaDon(
MaHD int IDENTITY(1,1) not null,
MaNV nvarchar(50) not null,
MaKH nvarchar(50) not null,
NgayLap date not null,
TongTien float not null,
primary key(MaHD),
foreign key(MaNV) references NhanVien(MaNV),
foreign key(MaKH) references KhachHang(MaKH),
)
go
create table KhachHang(
MaKH nvarchar(50) not null,
TenKH nvarchar(50) not null,
GioiTinh bit not null,
DiaChi nvarchar(50) not null,
SDT nvarchar(50) not null,
NgayCN date not null,
primary key(MaKH)
)
go 
create table LoaiXe(
MaLoai nvarchar(50) not null,
TenLoai nvarchar(50) not null,
ThongTinLoai nvarchar(50) not null,
primary key(MaLoai)
)
go
create table MauXe(
MaMau nvarchar(50) not null,
MauXe nvarchar(50) not null,
primary key(MaMau)
)
go 
create table NhanVien(
MaNV nvarchar(50) not null,
MatKhau nvarchar(50) not null,
HoTen nvarchar(50) not null,
GioiTinh bit not null,
ChucVu bit not null,
DiaChi nvarchar(50) not null,
SDT nvarchar(50) not null,
ThongTin nvarchar(50) not null,
Hinh nvarchar(50) not null,
primary key(MaNV)
)
go
create table ThongTinXe(
MaXe int IDENTITY(1,1) not null,
TenXe nvarchar(50) not null,
TenHang nvarchar(50) not null,
TenMau nvarchar(50) not null,
SoMay nvarchar(50) not null,
Gia float not null,
LoaiXe nvarchar(50) not null,
SoKhung nvarchar(50) not null,
DungTich nvarchar(50) not null,
SoLuong int not null,
Hinh nvarchar(50) not null,
primary key(MaXe),
foreign key(TenHang) references HangXe(MaHang),
foreign key(TenMau) references MauXe(MaMau),
foreign key(LoaiXe) references LoaiXe(MaLoai)
)
go
create table BaoHanh(
MaBH nvarchar(50) not null,
MaNV nvarchar(50) not null,
MaKH nvarchar(50) not null,
MaXe int not null,
NgayMua date not null,
NgayHH date not null,
primary key (MaBH)
)


INSERT NhanVien (MaNV, MatKhau, HoTen, GioiTinh,ChucVu,DiaChi, SDT, ThongTin,Hinh) VALUES (N'NV011', N'1234', N'Trần Văn Nam', 1,0, N'Trà Vinh', N'0898989898', N'',N'')
go
insert MauXe(MaMau,MauXe) values(N'#0000',N'Đen')

go
insert LoaiXe(MaLoai,TenLoai,ThongTinLoai) values (N'TG',N'Tay Ga',N'')
go
insert HangXe(MaHang,TenHang,ThongTinHang) values(N'HD',N'Honda',N'')
INSERT ThongTinXe (MaXe, TenXe, TenHang, TenMau, So999May, Gia, LoaiXe, SoKhung, DungTich, SoLuong, Hinh) VALUES (N'', N'SH-213', N'HonDa', N'Đen', N'62371', N'50000', N'Tay ga', N'73284', N'120cc', N'5', N'')