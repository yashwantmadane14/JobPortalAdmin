<!DOCTYPE html>
<%@page import="com.JobCategory.JobCategoryBean"%>
<%@page import="com.JobCategory.JobCategoryDao"%>
<%@ page import="java.util.List"%>

<html lang="en">
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body class="hold-transition sidebar-mini">
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
								<li class="breadcrumb-item active">General Form</li>
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
								<form action="../AddJobCategory" method="post">
									<div class="card-body">
										<div class="form-group">
											<label>Job Category</label> <input type="Text"
												class="form-control" id="exampleInputEmail1"
												name="job_category" placeholder="Enter Job category name">
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
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-8">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">Job Category Names</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th style="width: 10px">#</th>
												<th>Role Names</th>
												<th>Action</th>
											</tr>
										</thead>

										<%
										JobCategoryDao dao = new JobCategoryDao();
										List<JobCategoryBean> listJobCategory = dao.listCategory();

										for (JobCategoryBean i : listJobCategory) {
										%>
										<tr>
											<td><%=i.getId()%></td>
											<td><%=i.getJob_Category()%></td>
											<td><a
												href="/JobPortal/Admin/UpdtJobCategory.jsp?id=<%=i.getId()%>"><button
														class="badge bg-danger">Update</button></a> <a
												href="../DelJobCategory?id=<%=i.getId()%>"><button
														class="badge bg-warning">Delete</button></a></td>
										</tr>
										<%
										}
										%>
										</tbody>
									</table>
								</div>
								<!-- /.card-body -->
								<div class="card-footer clearfix">
									<ul class="pagination pagination-sm m-0 float-right">
										<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
										<li class="page-item"><a class="page-link" href="#">1</a></li>
										<li class="page-item"><a class="page-link" href="#">2</a></li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
									</ul>
								</div>
							</div>

						</div>
						<!-- /.col -->

						<!-- /.col -->
					</div>

				</div>
				<!-- /.container-fluid -->
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
