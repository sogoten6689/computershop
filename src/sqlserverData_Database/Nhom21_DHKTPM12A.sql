USE [master]
GO
/****** Object:  Database [Nhom21_DHKTPM12A]    Script Date: 5/7/2019 11:35:47 PM ******/
CREATE DATABASE [Nhom21_DHKTPM12A]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Nhom21_DHKTPM11A', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Nhom21_DHKTPM11A.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Nhom21_DHKTPM11A_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Nhom21_DHKTPM11A_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Nhom21_DHKTPM12A].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET ARITHABORT OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET  MULTI_USER 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Nhom21_DHKTPM12A]
GO
/****** Object:  Table [dbo].[Chitietdonhang]    Script Date: 5/7/2019 11:35:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chitietdonhang](
	[imadonhang] [int] NOT NULL,
	[soluongct] [int] NULL,
	[masp] [int] NOT NULL,
	[sDongiact] [float] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 5/7/2019 11:35:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[iMadonhang] [int] IDENTITY(1,1) NOT NULL,
	[sSDT] [nchar](15) NOT NULL,
	[dtNgaydathang] [date] NULL,
	[sPtthanhtoan] [nvarchar](50) NULL,
	[sDiachiNhanhang] [nvarchar](50) NULL,
 CONSTRAINT [PK_DonHAng] PRIMARY KEY CLUSTERED 
(
	[iMadonhang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/7/2019 11:35:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[iMakh] [int] IDENTITY(1,1) NOT NULL,
	[tenkh] [nvarchar](50) NULL,
	[sSDT] [nchar](15) NOT NULL,
	[sDiachi] [nvarchar](100) NULL,
	[sEmail] [nvarchar](50) NULL,
	[Gioitinh] [nvarchar](50) NULL,
	[Ngaysinh] [date] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[iMakh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 5/7/2019 11:35:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[spMaLoai] [int] IDENTITY(1,1) NOT NULL,
	[spTenLoai] [nvarchar](50) NULL,
	[spThongTinLoai] [nvarchar](200) NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[spMaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 5/7/2019 11:35:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quyen](
	[imaquyen] [int] NOT NULL,
	[sTenquyen] [nvarchar](50) NULL,
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[imaquyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sanpham]    Script Date: 5/7/2019 11:35:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sanpham](
	[masp] [int] IDENTITY(1,1) NOT NULL,
	[sTensp] [nvarchar](50) NULL,
	[dDongia] [float] NULL,
	[sAnhsp] [nvarchar](50) NULL,
	[sMota] [nvarchar](50) NULL,
	[spMaLoai] [int] NOT NULL,
	[trangthai] [nvarchar](50) NULL,
 CONSTRAINT [PK_Sanpham] PRIMARY KEY CLUSTERED 
(
	[masp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/7/2019 11:35:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[sSDT] [nchar](15) NOT NULL,
	[sMatkhau] [nchar](15) NOT NULL,
	[iMaquyen] [int] NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[sSDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Chitietdonhang] ([imadonhang], [soluongct], [masp], [sDongiact]) VALUES (1, 4, 3, 49999)
INSERT [dbo].[Chitietdonhang] ([imadonhang], [soluongct], [masp], [sDongiact]) VALUES (1, 4, 3, 49999)
INSERT [dbo].[Chitietdonhang] ([imadonhang], [soluongct], [masp], [sDongiact]) VALUES (1, 4, 3, 49999)
INSERT [dbo].[Chitietdonhang] ([imadonhang], [soluongct], [masp], [sDongiact]) VALUES (1, 4, 3, 49999)
INSERT [dbo].[Chitietdonhang] ([imadonhang], [soluongct], [masp], [sDongiact]) VALUES (1, 4, 3, 49999)
INSERT [dbo].[Chitietdonhang] ([imadonhang], [soluongct], [masp], [sDongiact]) VALUES (1, 4, 2, 49999)
INSERT [dbo].[Chitietdonhang] ([imadonhang], [soluongct], [masp], [sDongiact]) VALUES (1, 4, 2, 49999)
SET IDENTITY_INSERT [dbo].[DonHang] ON 

INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (1, N'1212121212     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (2, N'1212121212     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (3, N'1212121212     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (4, N'1212121212     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (5, N'1212121212     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (6, N'1212121212     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (7, N'1212121212     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (8, N'0789600766     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (9, N'1212121212     ', NULL, N'Khi nhận', N'')
INSERT [dbo].[DonHang] ([iMadonhang], [sSDT], [dtNgaydathang], [sPtthanhtoan], [sDiachiNhanhang]) VALUES (15, N'1212121212     ', NULL, N'Khi nhận', N'')
SET IDENTITY_INSERT [dbo].[DonHang] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([iMakh], [tenkh], [sSDT], [sDiachi], [sEmail], [Gioitinh], [Ngaysinh]) VALUES (1, N'Nguyễn Ngọc Lâm', N'0789600766     ', N'Gò xoài', N'sogoten6689@gmail.com', N'nam', CAST(N'1997-06-04' AS Date))
INSERT [dbo].[KhachHang] ([iMakh], [tenkh], [sSDT], [sDiachi], [sEmail], [Gioitinh], [Ngaysinh]) VALUES (3, N'Phúc Nhất', N'0123456789     ', N'Nguyễn Văn Bảo', N'doanphucnhat@gmail.com', N'Nữ', CAST(N'1997-12-12' AS Date))
INSERT [dbo].[KhachHang] ([iMakh], [tenkh], [sSDT], [sDiachi], [sEmail], [Gioitinh], [Ngaysinh]) VALUES (14, N'Nhật Tân', N'1212121212     ', N'Nguyễn Thái Sơn', N'nhattan@gmail.com', N'Nam', NULL)
INSERT [dbo].[KhachHang] ([iMakh], [tenkh], [sSDT], [sDiachi], [sEmail], [Gioitinh], [Ngaysinh]) VALUES (17, N'Phúc Nhất', N'0987654321     ', N'Binh Tan', N'Phucnhat@gmail.com', N'Nam', NULL)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiSanPham] ON 

INSERT [dbo].[LoaiSanPham] ([spMaLoai], [spTenLoai], [spThongTinLoai]) VALUES (1005, N' Chuột có dây ', N' chuột quang có dây. cổng usb dành cho máy bàn laptop,... ')
INSERT [dbo].[LoaiSanPham] ([spMaLoai], [spTenLoai], [spThongTinLoai]) VALUES (1006, N' Bàn phím có dây ', N' Bàn phím có dây cổng usb ')
INSERT [dbo].[LoaiSanPham] ([spMaLoai], [spTenLoai], [spThongTinLoai]) VALUES (2005, N' Màn hình ', N'  ')
INSERT [dbo].[LoaiSanPham] ([spMaLoai], [spTenLoai], [spThongTinLoai]) VALUES (2006, N' Tai nghe ', N'  ')
INSERT [dbo].[LoaiSanPham] ([spMaLoai], [spTenLoai], [spThongTinLoai]) VALUES (3005, N' Dell ', N' Hiệu máy tính dell ')
SET IDENTITY_INSERT [dbo].[LoaiSanPham] OFF
INSERT [dbo].[Quyen] ([imaquyen], [sTenquyen]) VALUES (1, N'USER')
INSERT [dbo].[Quyen] ([imaquyen], [sTenquyen]) VALUES (2, N'ADMIN')
SET IDENTITY_INSERT [dbo].[Sanpham] ON 

INSERT [dbo].[Sanpham] ([masp], [sTensp], [dDongia], [sAnhsp], [sMota], [spMaLoai], [trangthai]) VALUES (2, N'chuột 50k', 49999, N'', N'Chuột giá có dây nhỏ gọn tiện lợi', 1005, N'Còn hàng')
INSERT [dbo].[Sanpham] ([masp], [sTensp], [dDongia], [sAnhsp], [sMota], [spMaLoai], [trangthai]) VALUES (3, N'chuột 70k', 49999, N'', N'Bán đúng giá nhé!', 1005, N'Còn hàng')
INSERT [dbo].[Sanpham] ([masp], [sTensp], [dDongia], [sAnhsp], [sMota], [spMaLoai], [trangthai]) VALUES (4, N'Bàn phím nhật', 80000, N'', N'', 1006, N'Còn hàng')
INSERT [dbo].[Sanpham] ([masp], [sTensp], [dDongia], [sAnhsp], [sMota], [spMaLoai], [trangthai]) VALUES (5, N'', 0, N'HARPOOR_GRP.png', N'', 1005, N'')
INSERT [dbo].[Sanpham] ([masp], [sTensp], [dDongia], [sAnhsp], [sMota], [spMaLoai], [trangthai]) VALUES (13, N'lammm', 0, N'null', N'', 1005, N'')
INSERT [dbo].[Sanpham] ([masp], [sTensp], [dDongia], [sAnhsp], [sMota], [spMaLoai], [trangthai]) VALUES (14, N'Tai nghe iphone 50k', 200000, N'null', N'', 2006, N'')
SET IDENTITY_INSERT [dbo].[Sanpham] OFF
INSERT [dbo].[TaiKhoan] ([sSDT], [sMatkhau], [iMaquyen]) VALUES (N'0123456789     ', N'123456         ', 2)
INSERT [dbo].[TaiKhoan] ([sSDT], [sMatkhau], [iMaquyen]) VALUES (N'0789600766     ', N'123456         ', 1)
INSERT [dbo].[TaiKhoan] ([sSDT], [sMatkhau], [iMaquyen]) VALUES (N'0987654321     ', N'123456         ', 2)
INSERT [dbo].[TaiKhoan] ([sSDT], [sMatkhau], [iMaquyen]) VALUES (N'1212121212     ', N'123456         ', 2)
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_DonHang]    Script Date: 5/7/2019 11:35:47 PM ******/
CREATE NONCLUSTERED INDEX [IX_DonHang] ON [dbo].[DonHang]
(
	[sSDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_KhachHang]    Script Date: 5/7/2019 11:35:47 PM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_KhachHang] ON [dbo].[KhachHang]
(
	[sSDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = ON, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Chitietdonhang]  WITH CHECK ADD  CONSTRAINT [FK_Chitietdonhang_DonHang] FOREIGN KEY([imadonhang])
REFERENCES [dbo].[DonHang] ([iMadonhang])
GO
ALTER TABLE [dbo].[Chitietdonhang] CHECK CONSTRAINT [FK_Chitietdonhang_DonHang]
GO
ALTER TABLE [dbo].[Chitietdonhang]  WITH CHECK ADD  CONSTRAINT [FK_Chitietdonhang_Sanpham] FOREIGN KEY([masp])
REFERENCES [dbo].[Sanpham] ([masp])
GO
ALTER TABLE [dbo].[Chitietdonhang] CHECK CONSTRAINT [FK_Chitietdonhang_Sanpham]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_KhachHang] FOREIGN KEY([sSDT])
REFERENCES [dbo].[KhachHang] ([sSDT])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_KhachHang]
GO
ALTER TABLE [dbo].[Sanpham]  WITH CHECK ADD  CONSTRAINT [FK_Sanpham_LoaiSanPham] FOREIGN KEY([spMaLoai])
REFERENCES [dbo].[LoaiSanPham] ([spMaLoai])
GO
ALTER TABLE [dbo].[Sanpham] CHECK CONSTRAINT [FK_Sanpham_LoaiSanPham]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_KhachHang] FOREIGN KEY([sSDT])
REFERENCES [dbo].[KhachHang] ([sSDT])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_KhachHang]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_Quyen] FOREIGN KEY([iMaquyen])
REFERENCES [dbo].[Quyen] ([imaquyen])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_Quyen]
GO
USE [master]
GO
ALTER DATABASE [Nhom21_DHKTPM12A] SET  READ_WRITE 
GO
