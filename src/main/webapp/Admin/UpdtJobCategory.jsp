<%@page import="java.awt.print.PrinterGraphics"%>
<%@page import="javax.xml.crypto.KeySelectorResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import= "com.JobCategory.*" %>	


<html lang="en">
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body class="hold-transition sidebar-mini" style="">
<% 
JobCategoryDao dao = new JobCategoryDao();
int id = Integer.parseInt(request.getParameter("id"));
JobCategoryBean jobcategorybean = dao.selectCategory(id);
String category = (jobcategorybean!= null)?jobcategorybean.getJob_Category():"N/A";
%>
	<div class="wrapper">
		<!-- Navbar -->
		<jsp:include page="navbar.jsp"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>General Form</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Edit Data form</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->
						<div class="col-md-6">
							<!-- general form elements -->
							<div class="card card-danger">
								<div class="card-header">
									<h3 class="card-title"></h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form action="../UpdtJobCategory" method="post">
									<div class="card-body">
										<div class="form-group">
											
												<label>Job category</label> <input type="Text"
												class="form-control"
												name="category_name" value="<%=category%>">
												<input type="hidden" class="form-control"
												name="id" value="<%=id%>">
										</div>

										<div class="form-check">
											<input type="checkbox" class="form-check-input"
												id="exampleCheck1"> <label class="form-check-label"
												for="exampleCheck1">Confirm</label>
										</div>
									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="submit" class="btn btn-danger">Submit</button>
									</div>
								</form>
							</div>


						</div>

					</div>
				</div>
			</section>

			

		</div>

	</div>


	<script src="plugins/jquery/jquery.min.js"></script>

	<script src="plugins/jquery-ui/jquery-ui.min.js"></script>

	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="plugins/sparklines/sparkline.js"></script>

	<script src="plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>

	<script src="plugins/jquery-knob/jquery.knob.min.js"></script>

	<script src="plugins/moment/moment.min.js"></script>
	<script src="plugins/daterangepicker/daterangepicker.js"></script>

	<script
		src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>

	<script src="plugins/summernote/summernote-bs4.min.js"></script>

	<script
		src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>

	<script src="dist/js/adminlte.js"></script>


	<script src="dist/js/pages/dashboard.js"></script>


</body>
</html>
