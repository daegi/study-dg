<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
   String cp = request.getContextPath();
   request.setCharacterEncoding("UTF-8");
%>

<div id="header">
      <div id="headerTop">
      		<div id="headerLeft">
      		    <p style="margin: 2px;">
                     <a href="<%=cp%>" style="text-decoration: none;">
                        <span 
                             style="width: 200px; height: 70; position: relative; left: 0; top:20px; color: #2984ff; filter: mask(color=red) shadow(direction=135) chroma(color=red);font-style: italic; font-family: arial black; font-size: 40px; font-weight: bold;">ABLE</span>
                     </a>
                </p>
      		</div>
      		<div id="headerRight">
      		      <div style="margin-top: 5px; float: right;">
					<c:choose>
					      <c:when test="${empty sessionScope.session}">
							<a href="<%=cp%>/login/login.do">로그인</a>
							&nbsp;|&nbsp;
							<a href="<%=cp%>/member/member.do">회원가입</a>
						</c:when>
						<c:otherwise>
								<font color="blue">${sessionScope.session.userName}</font>님
								&nbsp;|&nbsp;
								<a href="<%=cp%>/login/logout.do">로그아웃</a>
								&nbsp;|&nbsp;
								<a href="<%=cp%>/member/update.do">정보수정</a>
						</c:otherwise>
					</c:choose>
      		      </div>
      		</div>
      </div>
      <div id="menu">
			<ul id="nav">
			<li><a href="#">회사소개</a>
				<ul>
				<li><a href="#">회사개요</a></li>
				<li><a href="#">회사연혁</a></li>
				<li><a href="#">사업분야</a></li>
				<li><a href="#">조직도</a></li>
				<li><a href="#">찾아오시는길</a></li>
				</ul>
			</li>
			
			<li><a href="#">커뮤니티</a>
				<ul>
				<li><a href="#">방명록</a></li>
				<li><a href="<%=cp%>/bbs/list.do">게시판</a></li>
				<li><a href="<%=cp%>/pds/list.do">자료실</a></li>
				<li><a href="#">포토겔러리</a></li>
				</ul>
			</li>

			<li><a href="#">마이페이지</a>
				<ul>
				<li><a href="#" style="margin-left:150px; " onmouseover="this.style.marginLeft='150px';">쪽지</a></li>
				<li><a href="#">친구관리</a></li>
				<li><a href="#">사진첩</a></li>
				<li><a href="#">채팅</a></li>
				</ul>
			</li>
			
			<li><a href="#">고객센터</a>
				<ul >
				<li><a href="#" style="margin-left:250px; " onmouseover="this.style.marginLeft='250px';">공지사항</a></li>
				<li><a href="#">FAQ</a></li>
				<li><a href="<%=cp%>/board/list.do">질문답변</a></li>
				<li><a href="#">일정관리</a></li>
				</ul>
			</li>
			
			<li style="float: right;"><a href="#">전체보기</a></li>
				
			</ul>      
      </div>
</div>
<div id="navigation">
	<div id="navBar">Home &gt; 회사소개</div>
</div>
