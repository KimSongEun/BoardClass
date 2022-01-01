# <div align=center><img src="https://user-images.githubusercontent.com/87016481/147854283-a08c1fd7-e29a-4ccf-858b-d940bc2d4730.png" width="400" height="200"></div><br>BoardClass by BcMaster
> BoardClass는 보드게임과 관련된 다양한 컨텐츠를 한 곳에서 즐길 수 있는 보드게임 커뮤니티입니다. 국내외 보드게임 시장 성장세에도 불구하고 국내보드게임 커뮤니티는 한 곳에 불과합니다. 보드게임에 처음 발을 들이는 사용자도 쉽게 이용할 수 있고, 마니아층 사용자 역시 꾸준히 찾을 수 있도록 보드게임 검색과 정보 확인을 편리하게 만들고자 했으며, 회원제 시스템을 이용하여 찜한 글 확인 등 '내 관심사'를 모아볼 수 있는 마이페이지를 제공합니다. 

## 목차
[1. 개발환경](#개발환경)   
[2. 프로젝트 설계주안점](#프로젝트-설계주안점)   
[3. 구현 기능](#구현-기능)   
[4. 팀원 및 주 담당 기능](#팀원-및-주-담당-기능)   
[5. 프로젝트 화면](#프로젝트-화면)   

## 개발환경
+ **Language**
  + JAVA 8
  + HTML5
  + CSS3
  + JavaScript
  + JSP&Servlet
  + SQL
+ **Database**
  + Oracle 11g 
+ **Web Server & WAS**
  + Apache-Tomcat   
+ **Framework & Library**
  + jQuery
  + Gson
  + JSTL Core
  + EL
  + Ajax
  + CKFinder
  + CKEditor
  + BootStrap
+ **Tools & ETC**
  + Eclipse
  + GitHub
  + Oracle SQL Developer
  + TortoiseGit

## 프로젝트 설계주안점
+ 사용자에게 친숙한 이미지 기반 인터페이스를 활용하여 보드게임 정보를 제공
+ 방문자의 회원가입을 유도하기 위해 보드게임 찜 기능과 중고거래글 찜 기능을 회원제로 운영
+ 방문자의 사이트 이용시간을 늘리기 위해 메인페이지와 커뮤니티 메인페이지에 실시간 인기글을 제공
+ 회원이 사이트와 상호작용한 자신의 활동을 손쉽게 확인할 수 있는 마이페이지를 제공
+ 사이트 관리의 편의를 위해 회원 및 게시판에 관련된 모든 활동을 관리자가 관리자페이지에서 확인하고 제어할 수 있게 함

## 구현 기능
+ **메인 페이지** : 슬라이드 배너, 실시간 인기글, 중고거래 최신글, 보드게임 검색 기능, 공지사항, 위로 가기 버튼   
+ **로그인 및 회원제** : 로그인/로그아웃, 회원가입, 아이디/비밀번호 찾기, 회원정보 조회/수정/탈퇴   
+ **마이페이지** : 내 보드게임 관리(찜/리뷰), 내 중고거래 관리(판매 게시글, 찜 리스트), 내 커뮤니티 관리(작성글/작성댓글)   
+ **보드게임 정보** : 조건 별 정렬 기능(난이도/평점/이름), 검색 기능(이름/연령/인원수/작가명), 글 조회, 중고거래글과 보드게임 연동 기능, 글 찜 기능, 글 신고 기능, 보드게임 리뷰 조회/등록/수정/삭제   
+ **보드게임 랭킹** : 조건 별 정렬 기능(조회수/평점/찜), 검색 기능(연령/인원/장르/가격)   
+ **커뮤니티** : 게시판 세분화(공지사항/자유/유저정보/모임), 글 조회/등록/수정/삭제, 댓글 조회/등록/수정/삭제, 인기글 기능, 검색 기능(제목/내용/작성자), 글 및 댓글 찜 기능, 글 신고 기능   
+ **중고거래 게시판** : 글 조회/등록/수정/삭제, 검색 기능(제목/내용), 중고거래글과 보드게임 연동 기능, 글 찜 기능, 글 신고 기능, 조건 별 정렬 기능(장르)   
+ **관리자 페이지** : 사이트 통계(총 회원수/일일 방문횟수/총 방문횟수/일일 등록글 수), 관리자 메인 페이지 신고 관리, 공지사항 조회/검색/등록/수정/삭제, 보드게임 정보 조회/검색/등록/수정/삭제, 광고 조회/검색/등록/수정/삭제, 전체 글 목록 조회/삭제, 전체 댓글 목록 조회/삭제, 커뮤니티 글 카테코리/타입 수정, 전체 글 검색(아이디/회원번호/글제목), 전체 댓글 검색(아이디/회원번호/글제목), 회원 리스트 조회 및 통계(작성글/댓글/리뷰/중고글), 회원검색(아이디/회원번호), 회원정보 상세보기, 개인활동 기반 회원정보 조회, 회원 강제 탈퇴 처리, 신고된 글 상세조회/정렬/삭제/검색(아이디/회원번호), 신고된 댓글상세조회/정렬/삭제/검색(아이디/회원번호), 신고된 리뷰 상세조회/정렬/삭제/검색(아이디/회원번호), 신고된 중고글 상세조회/정렬/삭제/검색(아이디/회원번호)

## 팀원 및 주 담당 기능
> **한설빈**
>> 중고거래 게시판   
>> 메인 페이지 일부 기능-검색 기능, 중고거래 최신글

> **김송은**
>> 관리자 페이지   
>> 메인 페이지 전체적인 UI 및 기능

> **김경숙**
>> 로그인 및 회원제   
>> 마이페이지

> **이윤비**
>> 커뮤니티   
>> 메인 페이지 일부 기능-인기글

> **유병현**
>> 보드게임 정보   
>> 보드게임 랭킹

## 프로젝트 화면

### [메인 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147854945-00cda6f9-6d68-4c60-b43b-479436c988a4.png" width="100%"></div>

### [로그인]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147854969-bd0d7750-7031-4585-bc90-d4d11c927d01.png" width="100%"></div>

### [메인 페이지 검색 기능]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855013-88b76252-1b20-45ef-ac64-d4a17f6c9ef0.png" width="100%"></div>

### [커뮤니티 메인 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855194-285b91ef-ac98-4aa5-8ba8-d8914b3227fd.png" width="100%"></div>

### [커뮤니티 자유게시판]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855232-67affd97-5876-4883-a669-95b50f394936.png" width="100%"></div>

### [커뮤니티 글 상세보기]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855354-e4e430bb-624e-4d4d-b4f4-98960071553f.png" width="100%"></div>

### [커뮤니티 글 작성]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855356-6d0bed64-970b-4235-a0ee-ac4c44962e88.png" width="100%"></div>

### [중고거래 메인 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855433-a883b695-5dcf-4ccd-a039-418fbb706a78.png" width="100%"></div>

### [중고거래 글 상세보기]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855437-4e6c2c4f-db77-424a-ad39-fa0c36aea7e7.png" width="100%"></div>

### [중고거래 글 작성]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855435-8447ec84-044f-43be-b3e4-8ee3a84c0b55.png" width="100%"></div>

### [랭킹 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855050-f0cb683e-f822-4de9-bddd-08b1c064088b.png" width="100%"></div>

### [보드게임 정보 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855067-bba31fb3-9054-4ed9-9a63-62ef147db94a.png" width="100%"></div>

### [보드게임 정보 상세 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855126-c0277c40-a0f4-4271-93ab-bcfc159f18ad.png" width="100%"></div>

### [보드게임 리뷰 작성]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855164-a0021ca0-ed22-484a-88e1-3d1c8db42b41.png" width="100%"></div>

### [보드게임 리뷰 조회]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855165-6ceb1b44-767a-44a7-a494-1dad56d3a08a.png" width="100%"></div>

### [마이 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855570-8f9cf6a1-7b4d-42a6-a66b-1ed4a1edc7df.png" width="100%"></div>

### [내 정보 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855574-90f3aa09-3b8a-43f6-a6e8-320504389f82.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855587-85aba1b9-04cd-47ef-b289-a895549dc3c4.png" width="100%"></div>

### [내 보드게임 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855573-cb017222-42c3-4000-aae3-b2204b2ad5f8.png" width="100%"></div>

### [내 중고거래 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855575-3d5162d1-3fbb-46d9-b217-78c08e9a6bf3.png" width="100%"></div>

### [내 커뮤니티 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855584-8ab8c20b-9d4f-4dbf-aeca-c8d78fcac117.png" width="100%"></div>

### [관리자 메인 페이지]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855696-63e6a4f0-6e82-4b1e-b47d-6d58386836c6.png" width="100%"></div>

### [관리자 공지사항 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855786-b1b4cd01-da18-43b3-9f1f-baebe8a0aadb.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855787-78cc1818-b3dc-42df-8f04-90eef97e9d8f.png" width="100%"></div>

### [관리자 보드게임 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855816-a3ef8b63-c516-4362-b23c-c6ce9c4cb840.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855818-3a5294bc-780a-4efc-9088-d5f00af9be17.png" width="100%"></div>

### [관리자 광고 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855830-23fe9769-4f60-4f31-a0f3-f7ecb039bfd5.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855833-31c10df6-0ca8-422b-a4f0-e5d73d55cdca.png" width="100%"></div>

### [관리자 회원 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147856057-4c720dd9-10e1-423d-848c-ced5126d3e34.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855961-91c8b2f3-df28-4176-9a18-e146b94839f3.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147855962-c46ec36f-b01c-48b8-a2ec-b5772c694648.png" width="100%"></div>

### [관리자 신고 관리]
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147856083-072bf44e-8c2e-455c-b78c-0eebd7daa23b.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147856085-b2858c2c-a55f-494a-809f-73627cb796ba.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147856087-12e6b18b-2677-48bd-8a8d-4a27b42100d0.png" width="100%"></div>
<div align=center><img src="https://user-images.githubusercontent.com/87016481/147856088-555e2d5b-0ecc-4f3d-9964-94ff20495f8a.png" width="100%"></div>
