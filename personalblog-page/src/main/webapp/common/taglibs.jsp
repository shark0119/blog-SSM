<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--  system values--%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="addr" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}" />
<c:set var="siteName" value="******理系统" />
<%-- css file define--%>
<c:set var="index_css" value="<link href='${ctx}/css/index.css' rel='stylesheet' type='text/css' />"/>
<c:set var="validate_css" value="<link href='${ctx}/css/validate.css' rel='stylesheet' type='text/css' />"/>
<%-- js file define --%>
<c:set var="jquery_js" value="<script type='text/javascript' src='${ctx}/resources/js/jquery-1.7.js'></script>"  />
<c:set var="jquery_form_js" value="<script type='text/javascript' src='${ctx}/resources/js/jquery.form.js'></script>"  />
<c:set var="jquery_select_js" value="<script type='text/javascript' src='${ctx}/resources/js/jquery.select.js'></script>"  />
<c:set var="WdatePicker_js" value="<script type='text/javascript' src='${ctx}/resources/js/my97/WdatePicker.js'></script>"  />
<c:set var="thickbox_js" value="<script type='text/javascript' src='${ctx}/resources/js/thickbox.js'></script>"  />
<c:set var="validate_js" value="<script type='text/javascript' src='${ctx}/resources/js/jquery.validate.js'></script>"  />
<c:set var="area_js" value="<script type='text/javascript' src='${ctx}/resources/js/area.js'></script>"  />
<c:set var="jmpopups_js" value="<script type='text/javascript' src='${ctx}/resources/js/jquery.jmpopups.js'></script>"  />
<c:set var="map_js" value="<script type='text/javascript' src='${ctx}/resources/js/map.js'></script>"  />
<c:set var="cookie_js" value="<SCRIPT type='text/javascript' src='${ctx}/resources/js/jquery.cookie.js'></SCRIPT>"  />
<c:set var="util_js" value="<SCRIPT type='text/javascript' src='${ctx}/resources/js/util.js'></SCRIPT>"  />
<%@ page trimDirectiveWhitespaces="true" %>