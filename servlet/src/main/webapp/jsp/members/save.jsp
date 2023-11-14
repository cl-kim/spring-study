<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  // request, response 는 알아서 사용 가능함 -> JSP가 서블릿으로 변환되기 때문
  MemberRepository memberRepository = MemberRepository.getInstance();

  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);

  // 이후 코드는 다 print된다.
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공!
<ul>
  <li> id = <%=member.getId()%></li>
  <li> username = <%=member.getUsername()%></li>
  <li> age = <%=member.getAge()%></li>
</ul>
</body>
</html>
