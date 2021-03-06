USE [master]
GO
/****** Object:  Database [Lab2]    Script Date: 2/28/2021 8:23:52 PM ******/
CREATE DATABASE [Lab2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Lab2', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Lab2.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Lab2_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Lab2_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Lab2] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Lab2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Lab2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Lab2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Lab2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Lab2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Lab2] SET ARITHABORT OFF 
GO
ALTER DATABASE [Lab2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Lab2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Lab2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Lab2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Lab2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Lab2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Lab2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Lab2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Lab2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Lab2] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Lab2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Lab2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Lab2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Lab2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Lab2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Lab2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Lab2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Lab2] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Lab2] SET  MULTI_USER 
GO
ALTER DATABASE [Lab2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Lab2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Lab2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Lab2] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Lab2] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Lab2]
GO
/****** Object:  Table [dbo].[tblAnswerContent]    Script Date: 2/28/2021 8:23:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblAnswerContent](
	[answerContentID] [varchar](20) NOT NULL,
	[A] [varchar](100) NOT NULL,
	[B] [varchar](100) NOT NULL,
	[C] [varchar](100) NOT NULL,
	[D] [varchar](100) NOT NULL,
 CONSTRAINT [PK_tblAnswerContent] PRIMARY KEY CLUSTERED 
(
	[answerContentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblQuiz]    Script Date: 2/28/2021 8:23:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblQuiz](
	[ID] [int] NOT NULL,
	[question] [varchar](500) NOT NULL,
	[answerContentID] [varchar](20) NOT NULL,
	[answerCorrect] [varchar](50) NOT NULL,
	[createDate] [datetime] NOT NULL,
	[subjectID] [varchar](50) NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblQuiz] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblSubject]    Script Date: 2/28/2021 8:23:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblSubject](
	[subjectID] [varchar](50) NOT NULL,
	[subjectName] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_tblSubject] PRIMARY KEY CLUSTERED 
(
	[subjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 2/28/2021 8:23:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[role] [bit] NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q1', N'1', N'2', N'3', N'4')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q10', N'1000', N'102', N'200', N'202')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q11', N'10', N'5', N'0', N'2')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q12', N'10', N'5', N'0', N'2')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q13', N'10', N'5', N'0', N'2')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q14', N'10', N'5', N'0', N'2')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q2', N'1', N'2', N'3', N'4')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q3', N'1', N'2', N'3', N'4')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q4', N'10', N'11', N'12', N'13')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q5', N'10', N'9', N'12', N'11')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q6', N'0', N'1', N'2', N'3')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q7', N'-8', N'-9', N'8', N'9')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q8', N'5', N'6', N'7', N'8')
INSERT [dbo].[tblAnswerContent] ([answerContentID], [A], [B], [C], [D]) VALUES (N'Q9', N'1', N'10', N'100', N'20')
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (1, N'1 + 1', N'Q1', N'B', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (2, N'1 + 2', N'Q2', N'C', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (3, N'2 + 2', N'Q3', N'D', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (4, N'5 + 5', N'Q4', N'A', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (5, N'10 - 1', N'Q5', N'B', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (6, N'10 - 10', N'Q6', N'A', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (7, N'1 - 10', N'Q7', N'B', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (8, N'2 * 3', N'Q8', N'B', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (9, N'10 * 10', N'Q9', N'C', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (10, N'100 * 2', N'Q10', N'C', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (11, N'10 / 5', N'Q11', N'D', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (12, N'100 / 10', N'Q12', N'A', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (13, N'10 / 10', N'Q13', N'C', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (14, N'(10+10) / 2', N'Q14', N'A', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MATH', 1)
INSERT [dbo].[tblQuiz] ([ID], [question], [answerContentID], [answerCorrect], [createDate], [subjectID], [status]) VALUES (15, N'lim(1)', N'Q15', N'A', CAST(N'2021-01-08 11:28:18.000' AS DateTime), N'MAE', 1)
INSERT [dbo].[tblSubject] ([subjectID], [subjectName]) VALUES (N'MAD', N'Toan roi rac')
INSERT [dbo].[tblSubject] ([subjectID], [subjectName]) VALUES (N'MAE', N'Toan cao cap')
INSERT [dbo].[tblSubject] ([subjectID], [subjectName]) VALUES (N'MATH', N'Toan')
INSERT [dbo].[tblUsers] ([userID], [password], [fullName], [role], [status]) VALUES (N'danh', N'123', N'Công Danh', 1, 1)
USE [master]
GO
ALTER DATABASE [Lab2] SET  READ_WRITE 
GO
