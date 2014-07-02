<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");

	// 현재 웹루트의 실제 경로
	String root=
	    session.getServletContext().getRealPath("/");
	
    String pathname=root+File.separator+"uploads";
    File f=new File(pathname);
    
    // 폴더가 존재하지 않으면 폴더를 작성
    if(! f.exists()) {
    	f.mkdirs(); // 뒤에 s 있는거. 그래야 모든 폴더 만듬
    }
    
    String encType="utf-8";
    int maxFilesize=5*1024*1024;
    
       // request,파일저장경로,업로드최대크기,enctype,
       //    동일한파일명버호여부(null이면 덮어씀)
       // MultipartRequest 객체를 생성하면 파일업로드가
       //   이루어지고 모든 파라미터를 분리해줌
    MultipartRequest mreq=new MultipartRequest(
    		request,pathname,maxFilesize,encType,
    		new DefaultFileRenamePolicy());
    
    String subject=mreq.getParameter("subject");
    String saveFilename=
    		mreq.getFilesystemName("upload");
    String originalFilename=
    		mreq.getOriginalFileName("upload");
   	long size=mreq.getFile("upload").length();

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

현재웹의 실제 루트 경로 : <%=  root %> <br/>
파일이 저장될 위치 : <%=pathname %><br/>
제목 : <%=subject%> <br/>
서버에저장된파일이름 : <%=saveFilename %><br/>
클라이언트가업로드한파일명 : <%=originalFilename %> <br/>
파일크기 : <%=size%> <br/>






</body>
</html>