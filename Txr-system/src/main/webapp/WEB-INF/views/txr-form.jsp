<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Txr_system</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
</head>
<body class="container">

	<hr />
	<h1>Txr_system</h1>
	<div class="row">
		<div class="col-6 col-sm-6 col-md-6">
			<div class="card card-body">
				<form action="txr" method="post">
					<div class="form-group">
						<label>Amount</label> <input name="amount" class="form-control">
					</div>
					<div class="form-group">
						<label>From Account</label> <input name="fromAccNum"
							class="form-control">
					</div>
					<div class="form-group">
						<label>To Account</label> <input name="toAccNum"
							class="form-control">
					</div>
					<button>Txr</button>
				</form>
			</div>
		</div>
		<div class="col-6 col-sm-6 col-md-6">
			<div class="card card-body">
				<div class="alert alert-info">${response.status}</div>
			</div>
		</div>
	</div>

</body>
</html>