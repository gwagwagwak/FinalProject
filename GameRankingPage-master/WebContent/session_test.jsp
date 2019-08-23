<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<%
Cookie[] cookieArray = request.getCookies();
Cookie cookie = null;
int countNum = 0;
String countStr="";
if(cookieArray!=null)
{
    for(int i=0;i<cookieArray.length;i++)
    {
        if(cookieArray[i].getName().equals("counter")){
            cookie = cookieArray[i];
            break;
        }
    }
}
if(cookie!=null)
{
    countNum = Integer.parseInt(cookie.getValue())+1;
    countStr = Integer.toString(countNum);
    cookie.setValue(countStr);
}
else
{
    cookie = new Cookie("counter","1");
}
response.addCookie(cookie);
%>
<%=cookie.getValue()%>

</body>
</html>