[#ftl output_format="HTML"]
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta http-equiv="X-UA-Compatible" content="IE=edge"><meta name="viewport" content="width=device-width, initial-scale=1.0"><title>Phone Registration
	</title><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2/dist/tailwind.min.css" type="text/css"></head>
<body>

  
	
	
	
	
	
  
  
	<div class="h-screen bg-gray-500 py-20 px-3">
	  <div class="container mx-auto">
		<div class="max-w-sm mx-auto md:max-w-lg">
		  <div class="w-full">
			<div class="bg-white h-full py-4 rounded text-center">
			  <form method="post" class="my-8">
				<h1 class="text-2xl font-bold">Phone Registration
				</h1>
				<div class="flex flex-col mt-4">
				  <div role="alert" class="p-4 mb-4 text-sm text-green-800 rounded-lg bg-green-50 dark:bg-gray-800 dark:text-green-400">
					<span class="font-medium">Hi ${username}!</span>
					<span class="font-medium">It looks like there is no phone number associated to your account.</span>
				  </div>
				</div>
				<div class="grid gap-6 mb-6 md:grid-cols-2">
				  <div>
					<label for="phoneNumber" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Enter your phone number:</label>
				  </div>
				  <div>
					<input type="text" name="phoneNumber" id="phoneNumber" placeholder="+237697778845" required="" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2-5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
				  </div>
				</div>
				<p id="helper-text-explanation" class="mt-2 mb-4 text-sm text-gray-500 dark:text-gray-400">We will send your OTP code to this phone number.
				</p>
				<button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2-5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Save</button>
			  </form>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  
  
</body>

<script>
	window.onload = function () {
	  var form = document.querySelector("form");
	  form.onsubmit = handleFormValidation;
	};
	function handleFormValidation() {
	  var userPhoneNumber = document.getElementById('phoneNumber').value
	  if (userPhoneNumber === '') {
		alert('Phone number is mandatory!')
		return false
	  }
	  return true
	}
  </script>
</html>